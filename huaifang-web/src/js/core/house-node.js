/**
 * Created by chenguojun on 8/10/16.
 */
;
(function ($, window, document, undefined) {
    var uploadMapping = {
        "/api/core/houseNode/list": "coreHouseNode"
    };
    App.requestMapping = $.extend({}, window.App.requestMapping, uploadMapping);
    App.coreHouseNode = {
        page: function (title) {
            window.App.content.empty();
            window.App.title(title);
            var content = $('<div class="panel-body" >' +
                '<div class="row">' +
                '<div class="col-md-3" >' +
                '<div class="panel panel-default" >' +
                '<div class="panel-heading">节点树预览</div>' +
                '<div class="panel-body">' +
                '<ul id="tree" class="ztree"></ul>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '<div class="col-md-9" >' +
                '<div class="panel panel-default" >' +
                '<div class="panel-heading">节点管理</div>' +
                '<div class="panel-body" id="grid"></div>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</div>');
            window.App.content.append(content);
            initEvents();
        }
    };
    var initEvents = function () {
        var grid;
        var tree;
        var options = {
            url: App.href + "/api/core/houseNode/list",
            contentType: "table",
            contentTypeItems: "table,card,list",
            pageNum: 1,//当前页码
            pageSize: 15,//每页显示条数
            idField: "id",//id域指定
            headField: "name",
            showCheck: true,//是否显示checkbox
            checkboxWidth: "3%",
            showIndexNum: false,
            indexNumWidth: "5%",
            pageSelect: [2, 15, 30, 50],
            columns: [
                {
                    title: "节点id",
                    field: "id",
                    sort: true,
                    width: "5%"
                }, {
                    title: "父节点id",
                    field: "pid",
                    sort: true,
                    width: "5%"
                }, {
                    title: "节点名",
                    field: "name",
                    sort: true
                }
            ],
            actionColumnText: "操作",//操作列文本
            actionColumnWidth: "20%",
            actionColumns: [{
                text: "编辑",
                cls: "btn-primary btn-sm",
                handle: function (index, data) {
                    var modal = $.orangeModal({
                        id: "houseNodeForm",
                        title: "编辑",
                        destroy: true
                    });
                    var formOpts = {
                        id: "edit_form",
                        name: "edit_form",
                        method: "POST",
                        action: App.href + "/api/core/houseNode/update",
                        ajaxSubmit: true,
                        ajaxSuccess: function () {
                            modal.hide();
                            grid.reload();
                            tree.reAsyncChildNodes(null, "refresh");
                        },
                        submitText: "保存",
                        showReset: true,
                        resetText: "重置",
                        isValidate: true,
                        buttons: [{
                            type: 'button',
                            text: '关闭',
                            handle: function () {
                                modal.hide();
                            }
                        }],
                        buttonsAlign: "center",
                        items: [
                            {
                                type: 'hidden',
                                name: 'id',
                                id: 'id'
                            }, {
                                type: 'tree',
                                name: 'pid',
                                id: 'pid',
                                label: '父节点',
                                url: App.href + "/api/core/houseNode/treeNodes",
                                expandAll: true,
                                autoParam: ["id", "name", "pId"],
                                chkStyle: "radio"
                            }, {
                                type: 'text',
                                name: 'name',
                                id: 'name',
                                label: '节点名称',
                                cls: 'input-large',
                                rule: {
                                    required: true
                                },
                                message: {
                                    required: "请输入节点名称"
                                }
                            }
                        ]
                    };
                    var form = modal.$body.orangeForm(formOpts);
                    form.loadRemote(App.href + "/api/core/houseNode/load/" + data.id);
                    modal.show();
                }
            }, {
                text: "删除",
                cls: "btn-danger btn-sm",
                handle: function (index, data) {
                    bootbox.confirm("确定该操作?", function (result) {
                        if (result) {
                            var requestUrl = App.href + "/api/core/houseNode/delete";
                            $.ajax({
                                type: "GET",
                                dataType: "json",
                                data: {
                                    id: data.id
                                },
                                url: requestUrl,
                                success: function (data) {
                                    if (data.code === 200) {
                                        grid.reload();
                                    } else {
                                        alert(data.message);
                                    }
                                },
                                error: function (e) {
                                    alert("请求异常。");
                                }
                            });
                        }
                    });
                }
            }],
            tools: [
                {
                    text: " 添 加",
                    cls: "btn btn-primary",
                    icon: "fa fa-plus",
                    handle: function (grid) {
                        var modal = $.orangeModal({
                            id: "add_modal",
                            title: "添加",
                            destroy: true
                        });
                        var formOpts = {
                            id: "add_form",
                            name: "add_form",
                            method: "POST",
                            action: App.href + "/api/core/houseNode/insert",
                            ajaxSubmit: true,
                            rowEleNum: 1,
                            ajaxSuccess: function () {
                                modal.hide();
                                grid.reload();
                                tree.reAsyncChildNodes(null, "refresh");
                            },
                            submitText: "保存",//保存按钮的文本
                            showReset: true,//是否显示重置按钮
                            resetText: "重置",//重置按钮文本
                            isValidate: true,//开启验证
                            buttons: [{
                                type: 'button',
                                text: '关闭',
                                handle: function () {
                                    modal.hide();
                                    grid.reload();
                                }
                            }],
                            buttonsAlign: "center",
                            items: [
                                {
                                    type: 'tree',
                                    name: 'pid',
                                    id: 'pid',
                                    label: '父节点',
                                    url: App.href + "/api/core/houseNode/treeNodes",
                                    expandAll: true,
                                    autoParam: ["id", "name", "pId"],
                                    chkStyle: "radio"
                                }, {
                                    type: 'text',
                                    name: 'name',
                                    id: 'name',
                                    label: '节点名称',
                                    cls: 'input-large',
                                    rule: {
                                        required: true
                                    },
                                    message: {
                                        required: "请输入节点名称"
                                    }
                                }
                            ]
                        };
                        modal.show().$body.orangeForm(formOpts);
                    }
                }
            ],
            search: {
                rowEleNum: 2,
                //搜索栏元素
                items: [
                    {
                        type: "text",
                        label: "节点名称",
                        name: "name",
                        placeholder: "输入要搜索的节点名称"
                    }
                ]
            }
        };
        grid = window.App.content.find("#grid").orangeGrid(options);


        var setting = {
            async: {
                enable: true,
                url: App.href + "/api/core/houseNode/treeNodes",
                autoParam: ["id", "name", "pId"]
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback: {
                onAsyncSuccess: function (event, treeId, treeNode, msg) {
                    var zTree = $.fn.zTree.getZTreeObj(treeId);
                    zTree.expandAll(true);
                }
            }
        };

        $.fn.zTree.init($("#tree"), setting);
        tree = $.fn.zTree.getZTreeObj("tree");


    }
})(jQuery, window, document);
