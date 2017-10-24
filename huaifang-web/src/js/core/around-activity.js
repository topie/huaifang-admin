/**
 * Created by chenguojun on 8/10/16.
 */
;
(function ($, window, document, undefined) {
    var uploadMapping = {
        "/api/core/aroundActivity/list": "coreAroundActivity"
    };
    App.requestMapping = $.extend({}, window.App.requestMapping, uploadMapping);
    App.coreAroundActivity = {
        page: function (title) {
            window.App.content.empty();
            window.App.title(title);
            var content = $('<div class="panel-body" >' +
                '<div class="row">' +
                '<div class="col-md-12" >' +
                '<div class="panel panel-default" >' +
                '<div class="panel-heading">发现活动管理</div>' +
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
            url: App.href + "/api/core/aroundActivity/list",
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
                    title: "ID",
                    field: "id",
                    width: "5%"
                },
                {
                    title: "活动标题",
                    field: "title"
                },
                {
                    title: "活动地址",
                    field: "address"
                },
                {
                    title: "开始时间",
                    field: "beginTime"
                },
                {
                    title: "结束时间",
                    field: "endTime"
                },
                {
                    title: "发布人",
                    field: "publishUser"
                },
                {
                    title: "发布时间",
                    field: "publishTime"
                },
                {
                    title: "状态",
                    field: "status"
                }
            ],
            actionColumnText: "操作",//操作列文本
            actionColumnWidth: "20%",
            actionColumns: [
                {
                    text: "编辑",
                    cls: "btn-primary btn-sm",
                    handle: function (index, d) {
                        var modal = $.orangeModal({
                            id: "aroundActivityForm",
                            title: "编辑",
                            destroy: true
                        }).show();
                        $.ajax({
                            type: "GET",
                            dataType: "json",
                            url: App.href + "/api/core/aroundActivity/formItems",
                            success: function (data) {
                                if (data.code === 200) {
                                    var formItems = data.data;
                                    var form = modal.$body.orangeForm({
                                        id: "edit_form",
                                        name: "edit_form",
                                        method: "POST",
                                        action: App.href + "/api/core/aroundActivity/update",
                                        ajaxSubmit: true,
                                        rowEleNum: 1,
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
                                        items: formItems
                                    });
                                    form.loadRemote(App.href + "/api/core/aroundActivity/load/" + d.id);
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
                                var requestUrl = App.href + "/api/core/aroundActivity/delete";
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
                }, {
                    text: "查看参加用户",
                    cls: "btn-info btn-sm",
                    handle: function (index, data) {
                        var modal = $.orangeModal({
                            id: "joinUsers",
                            title: "参加的用户",
                            destroy: true
                        }).show();
                        modal.$body.orangeGrid({
                            url: App.href + "/api/core/aroundActivity/joinUsers?id="+data.id,
                            contentType: "table",
                            contentTypeItems: "table,card",
                            pageNum: 1,//当前页码
                            pageSize: 15,//每页显示条数
                            idField: "id",//id域指定
                            headField: "nickname",
                            showCheck: true,//是否显示checkbox
                            checkboxWidth: "3%",
                            showIndexNum: false,
                            indexNumWidth: "5%",
                            pageSelect: [2, 15, 30, 50],
                            columns: [
                                {
                                    title: "昵称",
                                    field: "nickname"
                                },
                                {
                                    title: "姓名",
                                    field: "realname"
                                },
                                {
                                    title: "手机",
                                    field: "mobilePhone"
                                }
                            ]
                        });
                    }
                }, {
                    textHandle: function (i, d) {
                        return '上线';
                    },
                    visible: function (i, d) {
                        return d.status === 0;
                    },
                    cls: "btn-info btn-sm",
                    handle: function (index, data) {
                        bootbox.confirm("确定该操作?", function (result) {
                            if (result) {
                                var requestUrl = App.href + "/api/core/aroundActivity/online";
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
                }
            ],
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
                            url: App.href + "/api/core/aroundActivity/formItems",
                            success: function (data) {
                                if (data.code === 200) {
                                    var formItems = data.data;
                                    var form = modal.$body.orangeForm({
                                        id: "add_form",
                                        name: "add_form",
                                        method: "POST",
                                        action: App.href + "/api/core/aroundActivity/insert",
                                        ajaxSubmit: true,
                                        rowEleNum: 1,
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
                                        items: formItems
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
                rowEleNum: 1,
                //搜索栏元素
                items: [
                    {
                        type: "text",
                        label: "活动标题",
                        name: "title",
                        placeholder: "输入要搜索的活动标题"
                    }
                ]
            }
        };
        grid = window.App.content.find("#grid").orangeGrid(options);

    }
})(jQuery, window, document);
