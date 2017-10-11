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
