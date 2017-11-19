/**
 * Created by chenguojun on 8/10/16.
 */
;
(function ($, window, document, undefined) {
    var uploadMapping = {
        "/api/core/tag/list": "coreTag"
    };
    App.requestMapping = $.extend({}, window.App.requestMapping, uploadMapping);
    App.coreTag = {
        page: function (title) {
            window.App.content.empty();
            window.App.title(title);
            var content = $('<div class="panel-body" >' +
                '<div class="row">' +
                '<div class="col-md-12" >' +
                '<div class="panel panel-default" >' +
                '<div class="panel-heading">标签管理</div>' +
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
            url: App.href + "/api/core/tag/list",
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
                    title: "标签名",
                    field: "tagName"
                }
            ],
            actionColumnText: "操作",//操作列文本
            actionColumnWidth: "20%",
            actionColumns: [{
                text: "编辑",
                cls: "btn-primary btn-sm",
                handle: function (index, d) {
                    var modal = $.orangeModal({
                        id: "tagForm",
                        title: "编辑",
                        destroy: true
                    }).show();
                    var form = modal.$body.orangeForm({
                        id: "edit_form",
                        name: "edit_form",
                        method: "POST",
                        action: App.href + "/api/core/tag/update",
                        ajaxSubmit: true,
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
                        items: [
                            {
                                type: 'hidden',
                                name: 'id',
                                id: 'id'
                            }, {
                                type: 'text',
                                label: '标签名',
                                name: 'tagName',
                                id: 'tagName',//id
                                cls: 'input-large',
                                rule: {
                                    required: true
                                },
                                message: {
                                    required: "请输入标签名"
                                }
                            }
                        ]
                    });
                    form.loadRemote(App.href + "/api/core/tag/load/" + d.id);

                }
            }, {
                text: "设置用户",
                cls: "btn-primary btn-sm",
                handle: function (index, data) {
                    var userGrid;
                    var modal = $.orangeModal({
                        id: "user_grid",
                        title: "设置用户",
                        destroy: true
                    });
                    var options = {
                        url: App.href + "/api/core/tag/users?tagId=" + data.id,
                        pageNum: 1,//当前页码
                        pageSize: 15,//每页显示条数
                        idField: "userId",//id域指定
                        showCheck: true,//是否显示checkbox
                        checkboxWidth: "3%",
                        showIndexNum: false,
                        indexNumWidth: "5%",
                        pageSelect: [2, 15, 30, 50],
                        columns: [
                            {
                                title: "用户ID",
                                field: "userId",
                                sort: true,
                                width: "5%"
                            }, {
                                title: "昵称",
                                field: "nickname",
                                sort: true
                            }
                        ],
                        actionColumnText: "操作",//操作列文本
                        actionColumnWidth: "20%",
                        actionColumns: [{
                            textHandle: function (index, data) {
                                if (data.selected) {
                                    return "取消";
                                } else {
                                    return "选择";
                                }
                            },
                            clsHandle: function (index, data) {
                                if (data.selected) {
                                    return "btn-danger btn-sm";
                                } else {
                                    return "btn-primary btn-sm";
                                }
                            },
                            handle: function (i, d) {
                                var requestUrl = App.href + "/api/core/tag/selectUser";
                                if (d.selected) {
                                    requestUrl = App.href + "/api/core/tag/cancelUser";
                                }
                                $.ajax({
                                    type: "GET",
                                    dataType: "json",
                                    data: {
                                        tagId: data.id,
                                        userId: d.userId
                                    },
                                    url: requestUrl,
                                    success: function (data) {
                                        if (data.code === 200) {
                                            userGrid.reload();
                                        } else {
                                            alert(data.message);
                                        }
                                    },
                                    error: function (e) {
                                        alert("请求异常。");
                                    }
                                });
                            }
                        }],
                        search: {
                            rowEleNum: 2,
                            //搜索栏元素
                            items: [
                                {
                                    type: "text",
                                    label: "昵称",
                                    name: "nickname",
                                    placeholder: "输入要搜索的昵称"
                                }
                            ]
                        }
                    };
                    userGrid = modal.$body.orangeGrid(options);
                    modal.show();
                }
            }, {
                text: "删除",
                cls: "btn-danger btn-sm",
                handle: function (index, data) {
                    bootbox.confirm("确定该操作?", function (result) {
                        if (result) {
                            var requestUrl = App.href + "/api/core/tag/delete";
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
                        var form = modal.$body.orangeForm({
                            id: "add_form",
                            name: "add_form",
                            method: "POST",
                            action: App.href + "/api/core/tag/insert",
                            ajaxSubmit: true,
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
                            items: [
                                {
                                    label: '标签名',
                                    type: 'text',
                                    name: 'tagName',
                                    id: 'tagName',//id
                                    cls: 'input-large',
                                    rule: {
                                        required: true
                                    },
                                    message: {
                                        required: "请输入标签名"
                                    }
                                }
                            ]
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
                        label: "标签名称",
                        name: "tagName",
                        placeholder: "输入要搜索的标签名称"
                    }
                ]
            }
        };
        grid = window.App.content.find("#grid").orangeGrid(options);
    }
})(jQuery, window, document);
