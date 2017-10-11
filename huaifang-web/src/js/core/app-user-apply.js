/**
 * Created by chenguojun on 8/10/16.
 */
;
(function ($, window, document, undefined) {
    var uploadMapping = {
        "/api/core/appUserApply/list": "coreAppUserApply"
    };
    App.requestMapping = $.extend({}, window.App.requestMapping, uploadMapping);
    App.coreAppUserApply = {
        page: function (title) {
            window.App.content.empty();
            window.App.title(title);
            var content = $('<div class="panel-body" >' +
                '<div class="row">' +
                '<div class="col-md-12" >' +
                '<div class="panel panel-default" >' +
                '<div class="panel-heading">用户信息管理</div>' +
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
            url: App.href + "/api/core/appUser/list",
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
                },
                {
                    title: "注册时间",
                    field: "regTime"
                },
                {
                    title: "审核状态",
                    field: "status",
                    format: function (i, d) {
                        switch (d.status) {
                            case 0:
                                return '未认证';
                                break;
                            case 1:
                                return '待审核';
                                break;
                            case 2:
                                return '审核通过';
                                break;
                            case 3:
                                return '审核不通过';
                                break;
                        }
                    }
                },
                {
                    title: "登录状态",
                    field: "loginStatus",
                    format: function (i, d) {
                        switch (d.loginStatus) {
                            case 0:
                                return '锁定';
                                break;
                            case 1:
                                return '激活';
                                break;
                            default:
                                return '锁定';
                        }
                    }
                }
            ],
            actionColumnText: "操作",//操作列文本
            actionColumnWidth: "20%",
            actionColumns: [
                {
                    text: "审核",
                    visible: function (i, d) {
                        return d.status === 1;
                    },
                    cls: "btn-primary btn-sm",
                    handle: function (index, d) {

                    }
                },
                {
                    text: "查看详情",
                    cls: "btn-primary btn-sm",
                    handle: function (index, d) {
                        var modal = $.orangeModal({
                            id: "appUserForm",
                            title: "查看详情",
                            destroy: true
                        }).show();

                        $.ajax({
                            type: "GET",
                            dataType: "json",
                            url: App.href + "/api/core/commonQuery/formItems",
                            data: {
                                tables: 'd_app_user,d_person_info,d_person_info_live,d_person_info_rent,d_house_info'
                            },
                            success: function (data) {
                                if (data.code === 200) {
                                    var formItems1 = data.data['d_app_user'];
                                    var items1 = [];
                                    $.each(formItems1, function (ii, dd) {
                                        dd.readonly = "readonly";
                                        if (dd.type === 'datepicker')
                                            dd.type = 'display';
                                        items1.push(dd);
                                    });

                                    var formItems2 = data.data['d_person_info'];
                                    var items2 = [];
                                    $.each(formItems2, function (ii, dd) {
                                        dd.readonly = "readonly";
                                        if (dd.type === 'datepicker')
                                            dd.type = 'display';
                                        items2.push(dd);
                                    });

                                    var formItems3 = data.data['d_person_info_live'];
                                    var items3 = [];
                                    $.each(formItems3, function (ii, dd) {
                                        dd.readonly = "readonly";
                                        if (dd.type === 'datepicker')
                                            dd.type = 'display';
                                        items3.push(dd);
                                    });

                                    var formItems4 = data.data['d_person_info_rent'];
                                    var items4 = [];
                                    $.each(formItems4, function (ii, dd) {
                                        if (dd.name == 'rFirmIndustry') {
                                            dd.items = [
                                                {
                                                    text: '请选择',
                                                    value: ''
                                                },
                                                {
                                                    text: '农、林、牧、渔业',
                                                    value: '农、林、牧、渔业'
                                                },
                                                {
                                                    text: '采矿业',
                                                    value: '采矿业'
                                                },
                                                {
                                                    text: '其它',
                                                    value: '其它'
                                                }
                                            ]
                                        }
                                        dd.readonly = "readonly";
                                        if (dd.type === 'datepicker')
                                            dd.type = 'display';
                                        items4.push(dd);
                                    });
                                    var formItems5 = data.data['d_house_info'];
                                    var items5 = [];
                                    $.each(formItems5, function (ii, dd) {
                                        dd.readonly = "readonly";
                                        if (dd.type === 'datepicker')
                                            dd.type = 'display';
                                        if (dd.type === 'tree')
                                            dd.type = 'hidden';
                                        items5.push(dd);
                                    });


                                    modal.$body.orangeTab({
                                        tabs: [
                                            {
                                                title: 'APP用户信息',
                                                active: true,
                                                content: {
                                                    plugin: 'form',
                                                    options: {
                                                        id: "app_view_form",
                                                        name: "app_view_form",
                                                        method: "POST",
                                                        action: App.href + "/api/core/appUser/update",
                                                        ajaxSubmit: true,
                                                        ajaxSuccess: function () {
                                                            modal.hide();
                                                            grid.reload();
                                                        },
                                                        showReset: false,
                                                        showSubmit: false,
                                                        isValidate: true,
                                                        buttons: [{
                                                            type: 'button',
                                                            text: '关闭',
                                                            handle: function () {
                                                                modal.hide();
                                                            }
                                                        }],
                                                        buttonsAlign: "center",
                                                        items: items1
                                                    },
                                                    afterRender: function (form) {
                                                        form.loadRemote(App.href + "/api/core/appUser/load/" + d.id);
                                                    }
                                                }
                                            },
                                            {
                                                title: '人口基本信息',
                                                active: false,
                                                content: {
                                                    plugin: 'form',
                                                    options: {
                                                        id: "p_view_form",
                                                        name: "p_view_form",
                                                        method: "POST",
                                                        action: "",
                                                        ajaxSubmit: true,
                                                        ajaxSuccess: function () {
                                                            modal.hide();
                                                            grid.reload();
                                                        },
                                                        showReset: false,
                                                        showSubmit: false,
                                                        isValidate: true,
                                                        buttons: [{
                                                            type: 'button',
                                                            text: '关闭',
                                                            handle: function () {
                                                                modal.hide();
                                                            }
                                                        }],
                                                        buttonsAlign: "center",
                                                        items: items2
                                                    },
                                                    afterRender: function (form) {
                                                        form.loadRemote(App.href + "/api/core/personInfo/loadByAppUser/" + d.id);
                                                    }
                                                }
                                            },
                                            {
                                                title: '人口租户信息',
                                                active: false,
                                                content: {
                                                    plugin: 'form',
                                                    options: {
                                                        id: "r_view_form",
                                                        name: "r_view_form",
                                                        method: "POST",
                                                        action: "",
                                                        ajaxSubmit: true,
                                                        ajaxSuccess: function () {
                                                            modal.hide();
                                                            grid.reload();
                                                        },
                                                        showReset: false,
                                                        showSubmit: false,
                                                        isValidate: true,
                                                        buttons: [{
                                                            type: 'button',
                                                            text: '关闭',
                                                            handle: function () {
                                                                modal.hide();
                                                            }
                                                        }],
                                                        buttonsAlign: "center",
                                                        items: items4
                                                    },
                                                    afterRender: function (form) {
                                                        form.loadRemote(App.href + "/api/core/personInfo/loadRentByAppUser/" + d.id);
                                                    }
                                                }
                                            },
                                            {
                                                title: '人口住户信息',
                                                active: false,
                                                content: {
                                                    plugin: 'form',
                                                    options: {
                                                        id: "l_view_form",
                                                        name: "l_view_form",
                                                        method: "POST",
                                                        action: "",
                                                        ajaxSubmit: true,
                                                        ajaxSuccess: function () {
                                                            modal.hide();
                                                            grid.reload();
                                                        },
                                                        showReset: false,
                                                        showSubmit: false,
                                                        isValidate: true,
                                                        buttons: [{
                                                            type: 'button',
                                                            text: '关闭',
                                                            handle: function () {
                                                                modal.hide();
                                                            }
                                                        }],
                                                        buttonsAlign: "center",
                                                        items: items3
                                                    },
                                                    afterRender: function (form) {
                                                        form.loadRemote(App.href + "/api/core/personInfo/loadLiveByAppUser/" + d.id);
                                                    }
                                                }
                                            },
                                            {
                                                title: '房屋信息',
                                                active: false,
                                                content: {
                                                    plugin: 'form',
                                                    options: {
                                                        id: "house_view_form",
                                                        name: "house_view_form",
                                                        method: "POST",
                                                        action: "",
                                                        ajaxSubmit: true,
                                                        ajaxSuccess: function () {
                                                            modal.hide();
                                                            grid.reload();
                                                        },
                                                        showReset: false,
                                                        showSubmit: false,
                                                        isValidate: true,
                                                        buttons: [{
                                                            type: 'button',
                                                            text: '关闭',
                                                            handle: function () {
                                                                modal.hide();
                                                            }
                                                        }],
                                                        buttonsAlign: "center",
                                                        items: items5
                                                    },
                                                    afterRender: function (form) {
                                                        form.loadRemote(App.href + "/api/core/houseInfo/loadByAppUser/" + d.id);
                                                    }
                                                }
                                            }
                                        ]
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
