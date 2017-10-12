/**
 * Created by chenguojun on 8/10/16.
 */
;
(function ($, window, document, undefined) {
    var uploadMapping = {
        "/api/core/personInfo/list": "corePersonInfo"
    };
    App.requestMapping = $.extend({}, window.App.requestMapping, uploadMapping);
    App.corePersonInfo = {
        page: function (title) {
            window.App.content.empty();
            window.App.title(title);
            var content = $('<div class="panel-body" >' +
                '<div class="row">' +
                '<div class="col-md-12" >' +
                '<div class="panel panel-default" >' +
                '<div class="panel-heading">人口信息</div>' +
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
            url: App.href + "/api/core/personInfo/list",
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
                    title: "人口ID",
                    field: "pId",
                    width: "5%"
                },
                {
                    title: "用户类型",
                    field: "pPersonType"
                },
                {
                    title: "姓名",
                    field: "pName",
                    width: "5%"
                },
                {
                    title: "身份证号",
                    field: "pIdentifyNumber"
                },
                {
                    title: "绑定房屋信息",
                    field: "pHouseInfo"
                }
            ],
            actionColumnText: "操作",//操作列文本
            actionColumnWidth: "20%",
            actionColumns: [
                {
                    text: "编辑",
                    cls: "btn-primary btn-sm",
                    handle: function (index, d) {
                        var type = '';
                        if (d.pPersonType == '租户') {
                            type = 'Rent';
                        } else if (d.pPersonType == '住户') {
                            type = 'Live';
                        }
                        if (type == '')
                            return;
                        var modal = $.orangeModal({
                            id: "personInfoForm",
                            title: "编辑" + d.pPersonType,
                            destroy: true
                        }).show();
                        $.ajax({
                            type: "GET",
                            dataType: "json",
                            url: App.href + "/api/core/personInfo/formItems",
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
                                    items.push(
                                        {
                                            type: 'section',
                                            title: '基本信息'
                                        }
                                    );
                                    $.each(formItems, function (ii, dd) {
                                        if (dd.name == 'pPersonType') {
                                            dd.items = [{
                                                text: d.pPersonType,
                                                value: d.pPersonType
                                            }];
                                        }
                                        if (dd.name == 'pMobilePhone' || dd.name == 'pName' || dd.name == 'pIdentifyNumber') {
                                            dd.rule = {
                                                required: true
                                            };
                                            dd.message = {
                                                required: "必填"
                                            }
                                        }
                                        items.push(dd);
                                    });
                                    items.push(
                                        {
                                            type: 'section',
                                            title: '详细信息'
                                        }
                                    );
                                    $.ajax(
                                        {
                                            type: "GET",
                                            dataType: "json",
                                            url: App.href + "/api/core/personInfo" + type + "/formItems",
                                            async: false,
                                            success: function (data) {
                                                if (data.code === 200) {
                                                    var formItems = data.data;
                                                    $.each(formItems, function (ii, dd) {
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
                                                        items.push(dd);
                                                    });
                                                }
                                            }
                                        }
                                    );
                                    var form = modal.$body.orangeForm({
                                        id: "add_form",
                                        name: "add_form",
                                        method: "POST",
                                        action: App.href + "/api/core/personInfo/update" + type,
                                        ajaxSubmit: true,
                                        ajaxSuccess: function () {
                                            modal.hide();
                                            grid.reload();
                                        },
                                        submitText: "保存",//保存按钮的文本
                                        showReset: true,//是否显示重置按钮
                                        resetText: "重置",//重置按钮文本
                                        isValidate: true,//开启验证
                                        rowEleNum: 2,
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
                                    form.loadRemote(App.href + "/api/core/personInfo/load" + type + "/" + d.pId);
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
                                var requestUrl = App.href + "/api/core/personInfo/delete";
                                $.ajax({
                                    type: "GET",
                                    dataType: "json",
                                    data: {
                                        id: data.pId
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
                    text: "绑定房屋信息",
                    cls: "btn-info btn-sm",
                    handle: function (index, data) {
                        var modal = $.orangeModal({
                            id: "bindHouseInfo",
                            title: "绑定",
                            destroy: true
                        }).show();
                        var form = modal.$body.orangeForm({
                            id: "bind_form",
                            name: "bind_form",
                            method: "POST",
                            action: App.href + "/api/core/personInfo/bindHouse",
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
                            items: [
                                {
                                    type: 'tree',
                                    label: '房屋',
                                    name: 'houseId',
                                    id: 'houseId',
                                    expandAll: true,
                                    chkStyle: 'radio',
                                    url: App.href + "/api/core/houseInfo/treeNodes",
                                    rule: {
                                        required: true,
                                        max: -1
                                    },
                                    message: {
                                        required: "必选",
                                        max: "必须是房屋节点"
                                    }
                                }, {
                                    type: 'hidden',
                                    name: 'personId'
                                }
                            ]
                        });
                        form.loadRemote(App.href + "/api/core/personInfo/loadBindHouse?personId=" + data.pId);
                    }
                }
            ],
            tools: [
                {
                    text: "添加租户",
                    cls: "btn btn-primary",
                    icon: "fa fa-plus",
                    handle: function (grid) {
                        var modal = $.orangeModal({
                            id: "add_modal",
                            title: "添加租户",
                            destroy: true
                        }).show();
                        $.ajax({
                            type: "GET",
                            dataType: "json",
                            url: App.href + "/api/core/personInfo/formItems",
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
                                    items.push(
                                        {
                                            type: 'section',
                                            title: '基本信息'
                                        }
                                    );
                                    $.each(formItems, function (ii, dd) {
                                        if (dd.name == 'pPersonType') {
                                            dd.items = [
                                                {
                                                    text: '租户',
                                                    value: '租户'
                                                }
                                            ];
                                        }
                                        if (dd.name == 'pMobilePhone' || dd.name == 'pName' || dd.name == 'pIdentifyNumber') {
                                            dd.rule = {
                                                required: true
                                            };
                                            dd.message = {
                                                required: "必填"
                                            }
                                        }
                                        items.push(dd);

                                    });
                                    items.push(
                                        {
                                            type: 'section',
                                            title: '详细信息'
                                        }
                                    );
                                    $.ajax(
                                        {
                                            type: "GET",
                                            dataType: "json",
                                            url: App.href + "/api/core/personInfoRent/formItems",
                                            async: false,
                                            success: function (data) {
                                                if (data.code === 200) {
                                                    var formItems = data.data;
                                                    $.each(formItems, function (ii, dd) {
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
                                                                }
                                                            ]
                                                        }
                                                        items.push(dd);
                                                    });
                                                }
                                            }
                                        }
                                    );
                                    var form = modal.$body.orangeForm({
                                        id: "add_form",
                                        name: "add_form",
                                        method: "POST",
                                        action: App.href + "/api/core/personInfo/insertRent",
                                        ajaxSubmit: true,
                                        ajaxSuccess: function () {
                                            modal.hide();
                                            grid.reload();
                                        },
                                        submitText: "保存",//保存按钮的文本
                                        showReset: true,//是否显示重置按钮
                                        resetText: "重置",//重置按钮文本
                                        isValidate: true,//开启验证
                                        rowEleNum: 2,
                                        buttons: [
                                            {
                                                type: 'button',
                                                text: '关闭',
                                                handle: function () {
                                                    modal.hide();
                                                    grid.reload();
                                                }
                                            }
                                        ],
                                        buttonsAlign: "center",
                                        items: items
                                    });

                                } else {
                                    alert(data.message);
                                }
                            }
                            ,
                            error: function (e) {
                                alert("请求异常。");
                            }
                        });
                    }
                },
                {
                    text: "添加住户",
                    cls: "btn btn-primary",
                    icon: "fa fa-plus",
                    handle: function (grid) {
                        var modal = $.orangeModal({
                            id: "add_modal",
                            title: "添加住户",
                            destroy: true
                        }).show();
                        $.ajax({
                            type: "GET",
                            dataType: "json",
                            url: App.href + "/api/core/personInfo/formItems",
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
                                    items.push(
                                        {
                                            type: 'section',
                                            title: '基本信息'
                                        }
                                    );
                                    $.each(formItems, function (ii, dd) {
                                        if (dd.name == 'pPersonType') {
                                            dd.items = [{
                                                text: '住户',
                                                value: '住户'
                                            }];
                                        }
                                        if (dd.name == 'pMobilePhone' || dd.name == 'pName' || dd.name == 'pIdentifyNumber') {
                                            dd.rule = {
                                                required: true
                                            };
                                            dd.message = {
                                                required: "必填"
                                            }
                                        }
                                        items.push(dd);
                                    });
                                    items.push(
                                        {
                                            type: 'section',
                                            title: '详细信息'
                                        }
                                    );
                                    $.ajax(
                                        {
                                            type: "GET",
                                            dataType: "json",
                                            url: App.href + "/api/core/personInfoLive/formItems",
                                            async: false,
                                            success: function (data) {
                                                if (data.code === 200) {
                                                    var formItems = data.data;
                                                    $.each(formItems, function (ii, dd) {
                                                        if (dd.name != 'name' && dd.name != 'birth' && dd.name != 'identifyNumber') {
                                                            items.push(dd);
                                                        }
                                                    });
                                                }
                                            }
                                        }
                                    );
                                    var form = modal.$body.orangeForm({
                                        id: "add_form",
                                        name: "add_form",
                                        method: "POST",
                                        action: App.href + "/api/core/personInfo/insertLive",
                                        ajaxSubmit: true,
                                        ajaxSuccess: function () {
                                            modal.hide();
                                            grid.reload();
                                        },
                                        submitText: "保存",//保存按钮的文本
                                        showReset: true,//是否显示重置按钮
                                        resetText: "重置",//重置按钮文本
                                        isValidate: true,//开启验证
                                        rowEleNum: 2,
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
                            }
                            ,
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
                        label: "姓名",
                        name: "pName",
                        placeholder: "输入要搜索的姓名"
                    }
                ]
            }
        };
        grid = window.App.content.find("#grid").orangeGrid(options);

    }
})(jQuery, window, document);
