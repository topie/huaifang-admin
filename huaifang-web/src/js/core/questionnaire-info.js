/**
 * Created by chenguojun on 8/10/16.
 */
;
(function ($, window, document, undefined) {
    var uploadMapping = {
        "/api/core/questionnaireInfo/list": "coreQuestionnaireInfo"
    };
    App.requestMapping = $.extend({}, window.App.requestMapping, uploadMapping);
    App.coreQuestionnaireInfo = {
        page: function (title) {
            window.App.content.empty();
            window.App.title(title);
            var content = $('<div class="panel-body" >' +
                '<div class="row">' +
                '<div class="col-md-12" >' +
                '<div class="panel panel-default" >' +
                '<div class="panel-heading">问卷调查</div>' +
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
        var options = {
            url: App.href + "/api/core/questionnaireInfo/list",
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
                    title: "问卷调查名称",
                    field: "name"
                },
                {
                    title: "开始时间",
                    field: "begin"
                },
                {
                    title: "结束时间",
                    field: "end"
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
                    handle: function (index, d, grid) {
                        var modal = $.orangeModal({
                            id: "questionnaireInfoForm",
                            title: "编辑",
                            destroy: true
                        }).show();
                        $.ajax({
                            type: "GET",
                            dataType: "json",
                            url: App.href + "/api/core/questionnaireInfo/formItems",
                            success: function (data) {
                                if (data.code === 200) {
                                    var formItems = data.data;
                                    var form = modal.$body.orangeForm({
                                        id: "edit_form",
                                        name: "edit_form",
                                        method: "POST",
                                        action: App.href + "/api/core/questionnaireInfo/update",
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
                                    form.loadRemote(App.href + "/api/core/questionnaireInfo/load/" + d.id);
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
                    text: "管理题目",
                    cls: "btn-info btn-sm",
                    handle: function (index, data, grid) {
                        var modal = $.orangeModal({
                            id: "questionnaireItemGrid",
                            title: "管理题目-" + data.name,
                            destroy: true,
                            width: $(window).width()
                        }).show();
                        var infoId = data.id;
                        var requestUrl = App.href + "/api/core/questionnaireItem/list?infoId=" + infoId;
                        modal.$body.orangeGrid({
                            url: requestUrl,
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
                            sort: "questionIndex_asc",
                            columns: [
                                {
                                    title: "序号",
                                    field: "questionIndex",
                                    sort: true
                                },
                                {
                                    title: "问题题目",
                                    field: "question"
                                }
                            ],
                            actionColumnText: "操作",//操作列文本
                            actionColumnWidth: "20%",
                            actionColumns: [
                                {
                                    text: "上移",
                                    cls: "btn-info btn-sm",
                                    handle: function (index, d, grid) {
                                        if (index == 1)
                                            return;
                                        var prev = grid._grids[index - 2];
                                        $.ajax({
                                            type: "POST",
                                            dataType: "json",
                                            url: App.href + "/api/core/questionnaireItem/updateIndex",
                                            data: {
                                                idArr: d.id + "," + prev.id,
                                                indexArr: prev.questionIndex + "," + d.questionIndex
                                            },
                                            success: function (data) {
                                                if (data.code === 200) {
                                                    grid.reload();
                                                }
                                            }
                                        });
                                    }
                                },
                                {
                                    text: "下移",
                                    cls: "btn-success btn-sm",
                                    handle: function (index, d, grid) {
                                        if (index == grid._grids.length)
                                            return;
                                        var next = grid._grids[index];
                                        $.ajax({
                                            type: "POST",
                                            dataType: "json",
                                            url: App.href + "/api/core/questionnaireItem/updateIndex",
                                            data: {
                                                idArr: d.id + "," + next.id,
                                                indexArr: next.questionIndex + "," + d.questionIndex
                                            },
                                            success: function (data) {
                                                if (data.code === 200) {
                                                    grid.reload();
                                                }
                                            }
                                        });
                                    }
                                },
                                {
                                    text: "编辑",
                                    cls: "btn-primary btn-sm",
                                    handle: function (index, d, grid) {
                                        var modal = $.orangeModal({
                                            id: "questionnaireItemForm",
                                            title: "编辑",
                                            destroy: true
                                        }).show();
                                        $.ajax({
                                            type: "GET",
                                            dataType: "json",
                                            url: App.href + "/api/core/questionnaireItem/formItems",
                                            success: function (data) {
                                                if (data.code === 200) {
                                                    var formItems = data.data;
                                                    var listItem = {
                                                        type: 'list',
                                                        name: 'options',
                                                        label: '答案选项',
                                                        items: [
                                                            {
                                                                type: 'hidden',
                                                                name: 'optionId',
                                                                value: ''
                                                            }, {
                                                                type: 'text',
                                                                name: 'optionText',
                                                                label: '选项'
                                                            },
                                                            {
                                                                type: 'text',
                                                                name: 'optionIndex',
                                                                label: '排序号'
                                                            }
                                                        ]
                                                    };
                                                    formItems.push(listItem);
                                                    var form = modal.$body.orangeForm({
                                                        id: "edit_form",
                                                        name: "edit_form",
                                                        method: "POST",
                                                        action: App.href + "/api/core/questionnaireItem/update",
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
                                                    form.loadRemote(App.href + "/api/core/questionnaireItem/load/" + d.id);
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
                                    handle: function (index, d, grid) {
                                        bootbox.confirm("确定该操作?", function (result) {
                                            if (result) {
                                                var requestUrl = App.href + "/api/core/questionnaireItem/delete";
                                                $.ajax({
                                                    type: "GET",
                                                    dataType: "json",
                                                    data: {
                                                        id: d.id
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
                                    text: "添加题目",
                                    cls: "btn btn-primary",
                                    icon: "fa fa-plus",
                                    handle: function (grid) {
                                        var modal2 = $.orangeModal({
                                            id: "add_sub_modal",
                                            title: "添加题目",
                                            destroy: true
                                        }).show();
                                        $.ajax({
                                            type: "GET",
                                            dataType: "json",
                                            url: App.href + "/api/core/questionnaireItem/formItems",
                                            success: function (data) {
                                                if (data.code === 200) {
                                                    var formItems = data.data;
                                                    var items = [];
                                                    $.each(formItems, function (ii, dd) {
                                                        if (dd.name == 'infoId') {
                                                            dd.value = infoId;
                                                        }
                                                        items.push(dd);
                                                    });
                                                    var listItem = {
                                                        type: 'list',
                                                        name: 'options',
                                                        label: '答案选项',
                                                        items: [
                                                            {
                                                                type: 'hidden',
                                                                name: 'optionId'
                                                            }, {
                                                                type: 'text',
                                                                name: 'optionText',
                                                                label: '选项'
                                                            },
                                                            {
                                                                type: 'text',
                                                                name: 'optionIndex',
                                                                label: '排序号'
                                                            }
                                                        ]
                                                    };
                                                    items.push(listItem);
                                                    modal2.$body.orangeForm({
                                                        id: "add_form",
                                                        name: "add_form",
                                                        method: "POST",
                                                        action: App.href + "/api/core/questionnaireItem/insert",
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
                        });
                    }
                },
                {
                    text: "统计分析",
                    cls: "btn-info btn-sm",
                    handle: function (index, d, grid) {
                        var modal = $.orangeModal({
                            id: "questionStat",
                            title: "统计分析-" + d.name,
                            destroy: true
                        }).show();
                        $.ajax({
                            type: "GET",
                            dataType: "json",
                            data: {
                                id: d.id
                            },
                            url: App.href + "/api/core/questionnaireInfo/stat",
                            success: function (data) {
                                if (data.code === 200) {
                                    var items = data.data;
                                    var layoutOptions = {};
                                    layoutOptions.title = d.name;
                                    layoutOptions.rows = [];
                                    $.each(items, function (ii, dd) {
                                        var row = {};
                                        row.cols = [];
                                        var col = {};
                                        col.col = 12;
                                        col.id = "col_div_" + ii;
                                        col.title = (ii + 1) + " " + dd.q;
                                        col.type = 'panel';
                                        col.content = {};
                                        col.content.plugin = 'grid';
                                        col.content.options = {
                                            contentType: "table",
                                            showContentType: true,
                                            contentTypeItems: "table,chart-pie,chart-bar",
                                            pageNum: 1,//当前页码
                                            pageSize: 200,//每页显示条数
                                            idField: "uri",//id域指定
                                            headField: "uri",
                                            showCheck: true,//是否显示checkbox
                                            checkboxWidth: "3%",
                                            showIndexNum: false,
                                            indexNumWidth: "5%",
                                            pageSelect: [200],
                                            showPaging: false,
                                            columns: [
                                                {
                                                    title: "选项",
                                                    field: 'a',
                                                    chartX: true
                                                }, {
                                                    title: "选择用户",
                                                    field: "total",
                                                    chartY: true
                                                }, {
                                                    title: "占比",
                                                    field: "total",
                                                    format: function (i, d) {
                                                        return (d.total / dd.total) * 100 + "%";
                                                    }
                                                }
                                            ],
                                            data: {
                                                "total": dd.options.length,
                                                "data": dd.options
                                            }
                                        };
                                        row.cols.push(col);
                                        layoutOptions.rows.push(row);
                                    });
                                    modal.$body.orangeLayout(layoutOptions);
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
                    handle: function (index, data, grid) {
                        bootbox.confirm("确定该操作?", function (result) {
                            if (result) {
                                var requestUrl = App.href + "/api/core/questionnaireInfo/delete";
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
                            url: App.href + "/api/core/questionnaireInfo/formItems",
                            success: function (data) {
                                if (data.code === 200) {
                                    var formItems = data.data;
                                    var form = modal.$body.orangeForm({
                                        id: "add_form",
                                        name: "add_form",
                                        method: "POST",
                                        action: App.href + "/api/core/questionnaireInfo/insert",
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
        window.App.content.find("#grid").orangeGrid(options);
    }
})(jQuery, window, document);
