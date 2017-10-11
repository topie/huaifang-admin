/**
 * Created by chenguojun on 8/10/16.
 */
;
(function ($, window, document, undefined) {
    var uploadMapping = {
        "/api/core/partyMembersInfo/list": "corePartyMembersInfo"
    };
    App.requestMapping = $.extend({}, window.App.requestMapping, uploadMapping);
    App.corePartyMembersInfo = {
        page: function (title) {
            window.App.content.empty();
            window.App.title(title);
            var content = $('<div class="panel-body" >' +
                '<div class="row">' +
                '<div class="col-md-3" >' +
                '<div class="panel panel-default" >' +
                '<div class="panel-heading">党组织' +
                '<div class="pull-right">' +
                '<div class="btn-group">' +
                '<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false">' +
                '操作' +
                '<span class="caret"></span>' +
                '</button>' +
                '<ul class="dropdown-menu pull-right" role="menu">' +
                '<li><a id="add_node" href="javascript:void(0);">添加</a>' +
                '</li>' +
                '</ul>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '<div class="panel-body">' +
                '<ul id="tree" class="ztree"></ul>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '<div class="col-md-9" >' +
                '<div class="panel panel-default" >' +
                '<div class="panel-heading">党员列表</div>' +
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
            url: App.href + "/api/core/partyMembersInfo/list",
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
                    title: "id",
                    field: "id",
                    sort: true,
                    width: "5%"
                },
                {
                    title: "党员名称",
                    field: "name",
                    sort: true
                }
            ],
            actionColumnText: "操作",//操作列文本
            actionColumnWidth: "20%",
            actionColumns: [{
                text: "编辑",
                cls: "btn-primary btn-sm",
                handle: function (index, d) {
                    var modal = $.orangeModal({
                        id: "partyMembersInfoForm",
                        title: "编辑",
                        destroy: true
                    }).show();
                    $.ajax({
                        type: "GET",
                        dataType: "json",
                        url: App.href + "/api/core/partyMembersInfo/formItems",
                        success: function (data) {
                            if (data.code === 200) {
                                var getFullName = function (name, node) {
                                    if (node.getParentNode() != null) {
                                        name = node.getParentNode().name + ' ' + name;
                                        name = getFullName(name, node.getParentNode());
                                    }
                                    return name;
                                };
                                var formItems = data.data;
                                var items = [];
                                $.each(formItems, function (i, d) {
                                    if (d.name == 'nodeId') {
                                        d.type = 'tree';
                                        d.url = App.href + "/api/core/partyMembersNode/treeNodes";
                                        d.chkStyle = 'radio';
                                        d.expandAll = true;
                                        d.beforeCheck = function (treeId, treeNode, form) {
                                            var fullName = '';
                                            if (treeNode.getParentNode() != null) {
                                                fullName = getFullName(treeNode.name, treeNode);
                                            } else {
                                                fullName = treeNode.name;
                                            }
                                            form.$element.find("#partyNodeName").val(fullName);
                                        };
                                    }
                                    if (d.name == 'nodeName') {
                                        d.readonly = "readonly";
                                        d.name = 'partyNodeName';
                                        d.id = 'partyNodeName';
                                    }
                                    items.push(d);
                                });
                                var form = modal.$body.orangeForm({
                                    id: "edit_form",
                                    name: "edit_form",
                                    method: "POST",
                                    action: App.href + "/api/core/partyMembersInfo/update",
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
                                    items: items
                                });
                                form.loadRemote(App.href + "/api/core/partyMembersInfo/load/" + d.id);
                            } else {
                                alert(data.message);
                            }
                        },
                        error: function (e) {
                            alert("请求异常。");
                        }
                    });

                }
            }, {
                text: "删除",
                cls: "btn-danger btn-sm",
                handle: function (index, data) {
                    bootbox.confirm("确定该操作?", function (result) {
                        if (result) {
                            var requestUrl = App.href + "/api/core/partyMembersInfo/delete";
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
                        }).show();
                        $.ajax({
                            type: "GET",
                            dataType: "json",
                            url: App.href + "/api/core/partyMembersInfo/formItems",
                            success: function (data) {
                                if (data.code === 200) {
                                    var getFullName = function (name, node) {
                                        if (node.getParentNode() != null) {
                                            name = node.getParentNode().name + ' ' + name;
                                            name = getFullName(name, node.getParentNode());
                                        }
                                        return name;
                                    };
                                    var formItems = data.data;
                                    var items = [];
                                    $.each(formItems, function (i, d) {
                                        if (d.name == 'nodeId') {
                                            d.type = 'tree';
                                            d.url = App.href + "/api/core/partyMembersNode/treeNodes";
                                            d.chkStyle = 'radio';
                                            d.expandAll = true;
                                            d.beforeCheck = function (treeId, treeNode, form) {
                                                var fullName = '';
                                                if (treeNode.getParentNode() != null) {
                                                    fullName = getFullName(treeNode.name, treeNode);
                                                } else {
                                                    fullName = treeNode.name;
                                                }
                                                form.$element.find("#partyNodeName").val(fullName);
                                            };
                                        }
                                        if (d.name == 'nodeName') {
                                            d.readonly = "readonly";
                                            d.name = 'partyNodeName';
                                            d.id = 'partyNodeName';
                                        }
                                        items.push(d);
                                    });
                                    var form = modal.$body.orangeForm({
                                        id: "add_form",
                                        name: "add_form",
                                        method: "POST",
                                        action: App.href + "/api/core/partyMembersInfo/insert",
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
                                        items: items
                                    });
                                } else {
                                    alert(data.message);
                                }
                            },
                            error: function (e) {
                                alert("请求异常。");
                            }
                        });
                    }
                }
            ],
            search: {
                rowEleNum: 2,
                //搜索栏元素
                items: [
                    {
                        type: "text",
                        label: "党员名称",
                        name: "houseNo",
                        placeholder: "输入要搜索的党员名称"
                    }
                ]
            }
        };
        grid = window.App.content.find("#grid").orangeGrid(options);

        var setting = {
            async: {
                enable: true,
                url: App.href + "/api/core/partyMembersNode/treeNodes",
                autoParam: ["id", "name", "pId"]
            },
            edit: {
                enable: true
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
                },
                onRename: function (e, treeId, treeNode, isCancel) {
                    var zTree = $.fn.zTree.getZTreeObj(treeId);
                    tree.reAsyncChildNodes(null, "refresh");
                },
                beforeRename: beforeRename,
                beforeRemove: beforeRemove
            }
        };


        $.fn.zTree.init($("#tree"), setting);
        tree = $.fn.zTree.getZTreeObj("tree");

        function beforeRename(treeId, treeNode, newName, isCancel) {
            if (newName.length == 0) {
                return false;
            }
            if (!isCancel) {
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    data: {
                        id: treeNode.id,
                        pid: treeNode.getParentNode() == undefined ? 0 : treeNode.getParentNode().id,
                        name: newName
                    },
                    url: App.href + "/api/core/partyMembersNode/update",
                    success: function (data) {
                        if (data.code === 200) {
                            tree.reAsyncChildNodes(null, "refresh");
                        } else {
                            alert(data.message);
                        }
                    },
                    error: function (e) {
                        alert("请求异常。");
                    }
                });
            }
            return true;
        }

        function beforeRemove(treeId, treeNode) {
            var requestUrl = App.href + "/api/core/partyMembersNode/delete";
            bootbox.confirm("确定该操作?", function (result) {
                if (result) {
                    $.ajax({
                        type: "GET",
                        dataType: "json",
                        data: {
                            id: treeNode.id
                        },
                        async: false,
                        url: requestUrl,
                        success: function (data) {
                            if (data.code === 200) {
                                tree.reAsyncChildNodes(null, "refresh");
                            } else {
                                alert(data.message);
                            }
                        },
                        error: function (e) {
                            alert("请求异常。");
                        }
                    });
                    return true;
                } else {
                    return false;
                }
            });

        }

        $("#add_node").on("click", function (e) {
            var modal = $.orangeModal({
                id: "add_modal",
                title: "添加节点",
                destroy: true
            }).show();
            modal.$body.orangeForm({
                id: "add_form",
                name: "add_form",
                method: "POST",
                action: App.href + "/api/core/partyMembersNode/insert",
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
                        url: App.href + "/api/core/partyMembersNode/treeNodes",
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
            });
        });


    }
})(jQuery, window, document);
