/**
 * Created by chenguojun on 8/10/16.
 */
;
(function ($, window, document, undefined) {
    var uploadMapping = {
        "/api/core/repairReport/list": "coreRepairReport"
    };
    App.requestMapping = $.extend({}, window.App.requestMapping, uploadMapping);
    App.coreRepairReport = {
        page: function (title) {
            window.App.content.empty();
            window.App.title(title);
            var content = $('<div class="panel-body" >' +
                '<div class="row">' +
                '<div class="col-md-12" >' +
                '<div class="panel panel-default" >' +
                '<div class="panel-heading">意见箱</div>' +
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
            url: App.href + "/api/core/repairReport/list",
            contentType: "table",
            contentTypeItems: "table,card,list",
            pageNum: 1,//当前页码
            pageSize: 15,//每页显示条数
            idField: "id",//id域指定
            headField: "roomNumber",
            timeField: "reportTime",
            showCheck: true,//是否显示checkbox
            checkboxWidth: "3%",
            showIndexNum: false,
            indexNumWidth: "5%",
            pageSelect: [2, 15, 30, 50],
            columns: [
                {
                    title: "联系人",
                    field: "contactPerson"
                },
                {
                    title: "联系电话",
                    field: "contactPhone"
                },
                {
                    title: "房间号",
                    field: "roomNumber"
                },
                {
                    title: "报修时间",
                    field: "reportTime"
                },
                {
                    title: "维修状态",
                    field: "status"
                }
            ],
            actionColumnText: "操作",//操作列文本
            actionColumnWidth: "20%",
            actionColumns: [
                {
                    text: "维修进度",
                    cls: "btn-info btn-sm",
                    handle: function (i, d,g) {
                        var modal = $.orangeModal({
                            id: "questionnaireItemGrid",
                            title: "维修进度-" + d.roomNumber,
                            destroy: true,
                            width: $(window).width()
                        }).show();
                        var reportId = d.id;
                        var requestUrl = App.href + "/api/core/repairReportProcess/list?reportId=" + reportId;
                        modal.$body.orangeGrid({
                            url: requestUrl,
                            contentType: "timeline",
                            contentTypeItems: "table,timeline",
                            pageNum: 1,//当前页码
                            pageSize: 15,//每页显示条数
                            idField: "id",//id域指定
                            headField: "processStatus",
                            timeField: "processTime",
                            showCheck: true,//是否显示checkbox
                            checkboxWidth: "3%",
                            showIndexNum: false,
                            indexNumWidth: "5%",
                            pageSelect: [2, 15, 30, 50],
                            sort: "processTime_desc",
                            columns: [
                                {
                                    title: "进度情况",
                                    field: "processStatus"
                                }, {
                                    title: "联系人",
                                    field: "contactPerson",
                                    sort: true
                                },
                                {
                                    title: "联系人电话",
                                    field: "contactPhone"
                                },
                                {
                                    title: "进度时间",
                                    field: "processTime"
                                },
                                {
                                    title: "进度内容",
                                    field: "processContent"
                                },
                                {
                                    title: "进度状态",
                                    field: "status",
                                    check: true,
                                    checkFormat: function (i, d) {
                                        return d.status == '已完成';
                                    }
                                }
                            ],
                            actionColumnText: "操作",//操作列文本
                            actionColumnWidth: "20%",
                            actionColumns: [
                                {
                                    text: "编辑",
                                    cls: "btn-primary btn-sm",
                                    handle: function (ii, dd, grid) {
                                        var modal = $.orangeModal({
                                            id: "process_edit",
                                            title: "编辑",
                                            destroy: true
                                        }).show();
                                        $.ajax({
                                            type: "GET",
                                            dataType: "json",
                                            url: App.href + "/api/core/repairReportProcess/formItems",
                                            success: function (data) {
                                                if (data.code === 200) {
                                                    var formItems = data.data;
                                                    var form = modal.$body.orangeForm({
                                                        id: "edit_form",
                                                        name: "edit_form",
                                                        method: "POST",
                                                        action: App.href + "/api/core/repairReportProcess/update",
                                                        ajaxSubmit: true,
                                                        ajaxSuccess: function () {
                                                            modal.hide();
                                                            grid.reload();
                                                            g.reload();
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
                                                    form.loadRemote(App.href + "/api/core/repairReportProcess/load/" + dd.id);
                                                } else {
                                                    alert(data.message);
                                                }
                                            },
                                            error: function (e) {
                                                alert("请求异常。");
                                            }
                                        });
                                    }
                                },
                                {
                                    text: "删除",
                                    cls: "btn-danger btn-sm",
                                    handle: function (ii, dd, grid) {
                                        bootbox.confirm("确定该操作?", function (result) {
                                            if (result) {
                                                var requestUrl = App.href + "/api/core/repairReportProcess/delete";
                                                $.ajax({
                                                    type: "GET",
                                                    dataType: "json",
                                                    data: {
                                                        id: dd.id
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
                                    text: "添加进度",
                                    cls: "btn btn-primary",
                                    icon: "fa fa-plus",
                                    handle: function (grid) {
                                        var modal2 = $.orangeModal({
                                            id: "add_sub_modal",
                                            title: "添加进度",
                                            destroy: true
                                        }).show();
                                        $.ajax({
                                            type: "GET",
                                            dataType: "json",
                                            url: App.href + "/api/core/repairReportProcess/formItems",
                                            success: function (data) {
                                                if (data.code === 200) {
                                                    var formItems = data.data;
                                                    var items = [];
                                                    $.each(formItems, function (jj, jd) {
                                                        if (jd.name == 'reportId') {
                                                            jd.value = reportId;
                                                        }
                                                        if(jd.name == 'contactUserId')
                                                            jd.type='hidden';
                                                        items.push(jd);
                                                    });
                                                    modal2.$body.orangeForm({
                                                        id: "add_form",
                                                        name: "add_form",
                                                        method: "POST",
                                                        action: App.href + "/api/core/repairReportProcess/insert",
                                                        ajaxSubmit: true,
                                                        ajaxSuccess: function () {
                                                            modal2.hide();
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
                                                                modal2.hide();
                                                                grid.reload();
                                                                g.reload();
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
                            ]
                        })
                    }
                },
                {
                    text: "编辑",
                    cls: "btn-primary btn-sm",
                    handle: function (index, d) {
                        var modal = $.orangeModal({
                            id: "repairReportForm",
                            title: "编辑",
                            destroy: true
                        }).show();
                        $.ajax({
                            type: "GET",
                            dataType: "json",
                            url: App.href + "/api/core/repairReport/formItems",
                            success: function (data) {
                                if (data.code === 200) {
                                    var formItems = data.data;
                                    var form = modal.$body.orangeForm({
                                        id: "edit_form",
                                        name: "edit_form",
                                        method: "POST",
                                        action: App.href + "/api/core/repairReport/update",
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
                                        items: formItems
                                    });
                                    form.loadRemote(App.href + "/api/core/repairReport/load/" + d.id);
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
                                var requestUrl = App.href + "/api/core/repairReport/delete";
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
                            url: App.href + "/api/core/repairReport/formItems",
                            success: function (data) {
                                if (data.code === 200) {
                                    var formItems = data.data;
                                    var items = [];
                                    $.each(formItems, function (jj, jd) {
                                        if(jd.name == 'contactUserId')
                                            jd.type='hidden';
                                        items.push(jd);
                                    });
                                    var form = modal.$body.orangeForm({
                                        id: "add_form",
                                        name: "add_form",
                                        method: "POST",
                                        action: App.href + "/api/core/repairReport/insert",
                                        ajaxSubmit: true,
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
                        label: "联系电话",
                        name: "contactPhone",
                        placeholder: "输入要搜索的联系电话"
                    }
                ]
            }
        };
        grid = window.App.content.find("#grid").orangeGrid(options);
    }
})(jQuery, window, document);
