/**
 * Created by chenguojun on 8/10/16.
 */
;
(function ($, window, document, undefined) {
    var uploadMapping = {
        "/api/core/houseInfo/list": "coreHouseInfo"
    };
    App.requestMapping = $.extend({}, window.App.requestMapping, uploadMapping);
    App.coreHouseInfo = {
        page: function (title) {
            window.App.content.empty();
            window.App.title(title);
            var content = $('<div class="panel-body" >' +
                '<div class="row">' +
                '<div class="col-md-12" >' +
                '<div class="panel panel-default" >' +
                '<div class="panel-heading">房屋列表</div>' +
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
        var options = {
            url: App.href + "/api/core/houseInfo/list",
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
                    title: "房屋地址",
                    field: "address"
                },
                {
                    title: "房屋编号",
                    field: "houseNo",
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
                        id: "houseInfoForm",
                        title: "编辑",
                        destroy: true
                    }).show();
                    $.ajax({
                        type: "GET",
                        dataType: "json",
                        url: App.href + "/api/core/houseInfo/formItems",
                        success: function (data) {
                            if (data.code === 200) {
                                var formItems = data.data;
                                var items = [];
                                var getFullName = function (name, node) {
                                    if (node.getParentNode() != null) {
                                        name = node.getParentNode().name + ' ' + name;
                                        name = getFullName(name, node.getParentNode());
                                    }
                                    return name;
                                };
                                $.each(formItems, function (ii, dd) {
                                    if (dd.name == 'houseNodeId') {
                                        dd.type = 'tree';
                                        dd.expandAll = true;
                                        dd.url = App.href + "/api/core/houseNode/treeNodes";
                                        dd.chkStyle = 'radio';
                                        dd.beforeCheck = function (treeId, treeNode, form) {
                                            var fullName = '';
                                            if (treeNode.getParentNode() != null) {
                                                fullName = getFullName(treeNode.name, treeNode);
                                            } else {
                                                fullName = treeNode.name;
                                            }
                                            form.$element.find("#address").val(fullName);
                                        };
                                    }
                                    if (dd.name == 'address') {
                                        dd.readonly = 'readonly';
                                    }
                                    items.push(dd);
                                });
                                var form = modal.$body.orangeForm({
                                    id: "edit_form",
                                    name: "edit_form",
                                    method: "POST",
                                    action: App.href + "/api/core/houseInfo/update",
                                    ajaxSubmit: true,
                                    rowEleNum: 2,
                                    ajaxSuccess: function () {
                                        modal.hide();
                                        grid.reload();
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
                                form.loadRemote(App.href + "/api/core/houseInfo/load/" + d.id);
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
                            var requestUrl = App.href + "/api/core/houseInfo/delete";
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
                            url: App.href + "/api/core/houseInfo/formItems",
                            success: function (data) {
                                if (data.code === 200) {
                                    var formItems = data.data;
                                    var items = [];
                                    var getFullName = function (name, node) {
                                        if (node.getParentNode() != null) {
                                            name = node.getParentNode().name + ' ' + name;
                                            name = getFullName(name, node.getParentNode());
                                        }
                                        return name;
                                    };
                                    $.each(formItems, function (ii, dd) {
                                        if (dd.name == 'houseNodeId') {
                                            dd.type = 'tree';
                                            dd.expandAll = true;
                                            dd.url = App.href + "/api/core/houseNode/treeNodes";
                                            dd.chkStyle = 'radio';
                                            dd.beforeCheck = function (treeId, treeNode, form) {
                                                var fullName = '';
                                                if (treeNode.getParentNode() != null) {
                                                    fullName = getFullName(treeNode.name, treeNode);
                                                } else {
                                                    fullName = treeNode.name;
                                                }
                                                form.$element.find("#address").val(fullName);
                                            };
                                        }
                                        if (dd.name == 'address') {
                                            dd.readonly = 'readonly';
                                        }
                                        items.push(dd);
                                    });
                                    modal.$body.orangeForm({
                                        id: "add_form",
                                        name: "add_form",
                                        method: "POST",
                                        action: App.href + "/api/core/houseInfo/insert",
                                        ajaxSubmit: true,
                                        rowEleNum: 2,
                                        ajaxSuccess: function () {
                                            modal.hide();
                                            grid.reload();
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
                        label: "房屋编号",
                        name: "houseNo",
                        placeholder: "输入要搜索的房屋编号"
                    }
                ]
            }
        };
        grid = window.App.content.find("#grid").orangeGrid(options);

    }
})(jQuery, window, document);
