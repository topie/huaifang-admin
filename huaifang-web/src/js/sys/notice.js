;(function ($, window, document, undefined) {
    var mapping = {
        "/api/core/notice/list": "notice"
    };
    App.requestMapping = $.extend({}, window.App.requestMapping, mapping);
    App.notice = {
        page: function (title) {
            App.content.empty();
            App.title(title);
            var style = $('<style type="text/css">tr th{white-space: nowrap;text-align: left;} tr td{white-space: nowrap;text-align: left;}</style>');
            App.content.append(style);
            var content = $('<div class="panel-body" id="grid"></div>');
            App.content.append(content);
            initEvents();
        }
    };
    var initEvents = function () {
        var grid = {};
        var options = {
            url: App.href + "/api/core/notice/list",
            pageNum: 1,//当前页码
            pageSize: 15,//每页显示条数
            idField: "id",//id域指定
            headField: "title",
            showCheck: true,//是否显示checkbox
            checkboxWidth: "3%",
            showIndexNum: true,
            indexNumWidth: "5%",
            pageSelect: [2, 15, 30, 50],
            columns: [
                {
                    title: "标题",
                    field: "title"
                }, {
                    title: '发布者',
                    field: 'cUser'
                }, {
                    title: '发布时间',
                    field: 'pTime'
                }
            ],
            actionColumnText: "操作",//操作列文本
            actionColumnWidth: "20%",
            actionColumns: [
                {
                    text: "预览",
                    cls: "btn-primary btn-sm",
                    handle: function (index, data) {
                        var modal = $.orangeModal({
                            id: "notice_edit_modal",
                            title: data.title,
                            width: 900,
                            height: 500,
                            destroy: true,
                            buttons: [
                                {
                                    type: 'button',
                                    text: '关闭',
                                    cls: "btn-default",
                                    handle: function () {
                                        modal.hide()
                                    }
                                }
                            ]
                        }).show();
                        var formOpts = {
                            id: "notice_form",
                            name: "notice_form",
                            method: "POST",
                            labelInline: false,
                            action: App.href + "/api/core/notice/update",
                            ajaxSubmit: true,//是否使用ajax提交表单
                            ajaxSuccess: function () {
                                modal.hide();
                                grid.reload();
                            },
                            submitText: "保存",//保存按钮的文本
                            showReset: false,//是否显示重置按钮
                            showSubmit: false,
                            resetText: "重置",//重置按钮文本
                            isValidate: true,//开启验证
                            buttonsAlign: "center",
                            items: [
                                {
                                    type: 'display',
                                    name: 'title',
                                    id: 'title',
                                    style: 'text-align: center;',
                                    label: '',
                                    format: function (val) {
                                        return '<h1>' + val + '</h1>'
                                    }
                                },
                                {
                                    type: 'display',
                                    name: 'content',
                                    id: 'content',
                                    label: ''
                                }
                            ]
                        };
                        var form = modal.$body.orangeForm(formOpts);
                        form.loadRemote(App.href + "/api/core/notice/load/" + data.id)
                    }
                }, {
                    text: "编辑",
                    cls: "btn-primary btn-sm",
                    handle: function (index, data) {
                        var modal = $.orangeModal({
                            id: "edit_modal",
                            title: "编辑",
                            destroy: true
                        }).show();
                        var form = modal.$body.orangeForm({
                            id: "edit_form",
                            name: "edit_form",
                            method: "POST",
                            action: App.href + "/api/core/notice/update",
                            ajaxSubmit: true,//是否使用ajax提交表单
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
                                    modal.hide()
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
                                    name: 'title',
                                    id: 'title',
                                    label: '标题',
                                    cls: 'input-large',
                                    rule: {
                                        required: true
                                    },
                                    message: {
                                        required: "请输入标题"
                                    }
                                }, {
                                    type: 'datepicker',
                                    name: 'pTime',
                                    id: 'pTime',
                                    label: '发布时间',
                                    config: {
                                        timePicker: true,
                                        singleDatePicker: true,
                                        locale: {
                                            format: 'YYYY-MM-DD HH:mm:ss'
                                        }
                                    },
                                    rule: {
                                        required: true
                                    },
                                    message: {
                                        required: "请选择日期"
                                    }
                                }, {
                                    type: 'kindEditor',
                                    name: 'content',
                                    id: 'content',
                                    label: '正文',
                                    height: "300px",
                                    rule: {
                                        required: true
                                    },
                                    message: {
                                        required: "正文"
                                    }
                                }
                            ]
                        });
                        form.loadRemote(App.href + "/api/core/notice/load/" + data.id);
                    }
                }, {
                    text: "删除",
                    cls: "btn-danger btn-sm",
                    handle: function (index, data) {
                        bootbox.confirm("确定该操作?", function (result) {
                            if (result) {
                                var requestUrl = App.href + "/api/core/notice/delete";
                                $.ajax({
                                    type: "POST",
                                    dataType: "json",
                                    data: {
                                        id: data.id
                                    },
                                    url: requestUrl,
                                    success: function (data) {
                                        if (data.code === 200) {
                                            grid.reload()
                                        } else {
                                            alert(data.message)
                                        }
                                    },
                                    error: function (e) {
                                        alert("请求异常。")
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
                        modal.$body.orangeForm({
                            id: "add_form",
                            name: "add_form",
                            method: "POST",
                            action: App.href + "/api/core/notice/insert",
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
                            buttons: [
                                {
                                    type: 'button',
                                    text: '关闭',
                                    handle: function () {
                                        modal.hide()
                                    }
                                }
                            ],
                            buttonsAlign: "center",
                            items: [
                                {
                                    type: 'text',
                                    name: 'title',
                                    id: 'title',
                                    label: '标题',
                                    cls: 'input-large',
                                    rule: {
                                        required: true
                                    },
                                    message: {
                                        required: "请输入标题"
                                    }
                                }, {
                                    type: 'datepicker',
                                    name: 'pTime',
                                    id: 'pTime',
                                    label: '发布时间',
                                    config: {
                                        timePicker: true,
                                        singleDatePicker: true,
                                        locale: {
                                            format: 'YYYY-MM-DD HH:mm:ss'
                                        }
                                    },
                                    rule: {
                                        required: true
                                    },
                                    message: {
                                        required: "请选择日期"
                                    }
                                }, {
                                    type: 'kindEditor',
                                    name: 'content',
                                    id: 'content',
                                    label: '正文',
                                    height: "300px",
                                    rule: {
                                        required: true
                                    },
                                    message: {
                                        required: "正文"
                                    }
                                }
                            ]
                        })
                    }
                }
            ],
            search: {
                rowEleNum: 2,
                //搜索栏元素
                items: [
                    {
                        type: "text",
                        label: "标题",
                        name: "title",
                        placeholder: "搜索标题"
                    }
                ]
            }
        };
        grid = window.App.content.find("#grid").orangeGrid(options)
    };
})(jQuery, window, document);
