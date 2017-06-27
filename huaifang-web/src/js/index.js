/**
 * Created by chenguojun on 8/10/16.
 */
;
(function ($, window, document, undefined) {
    var token = $.cookie('huaifang_token');
    if (token == undefined) {
        window.location.href = '../login.html';
    }
    App.token = token;

    var requestMapping = {
        "/api/index": "index"
    };
    App.requestMapping = $.extend({}, App.requestMapping, requestMapping);

    App.index = {
        page: function (title) {
            App.content.empty();
            App.title(title);
            var content = $('<div class="panel-body" >' +
                '<div class="row">' +
                '<div class="col-md-12" >' +
                '<div class="panel panel-default" >' +
                '<div class="panel-heading">当日实时总GMV</div>' +
                '<div class="panel-body" id="content1"></div>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="col-md-12" >' +
                '<div class="panel panel-default" >' +
                '<div class="panel-heading">当日实时分类GMV</div>' +
                '<div class="panel-body" id="content2"></div>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</div>');
            App.content.append(content);
            initEvents();
        }
    };
    /**
     * 初始化事件
     */
    var initEvents = function () {
        var sumGmvDiv = $('<div class="row"></div>');
        var gmvDiv = $(
            '<div class="col-lg-6 col-md-6">' +
            '<div class="panel panel-warning">' +
            '<div class="panel-heading">' +
            '<div class="row">' +
            '<div class="col-xs-12 text-right">' +
            '<div role="gmv" class="huge">0</div> ' +
            '<div>总GMV</div> ' +
            '<div>昨日同期:<span role="yGmv" class="pull-right">0</span></div>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '<div class="panel-footer">' +
            '<div class="progress">' +
            '<div role="okr1" class="progress-bar progress-bar-warning" role="progressbar" aria-valuemax="100" style="border-color:white;width: 0%">' +
            ' </div>' +
            ' </div>' +
            ' <span role="okr2" class="pull-right">0%</span>' +
            ' <div class="clearfix"></div>' +
            '  </div>' +
            '</div>');
        sumGmvDiv.append(gmvDiv);
        var orderDiv = $(
            '<div class="col-lg-6 col-md-6">' +
            '<div class="panel panel-info">' +
            '<div class="panel-heading">' +
            '<div class="row">' +
            '<div class="col-xs-12 text-right">' +
            '<div role="gmv" class="huge">0</div> ' +
            '<div>总订单</div> ' +
            '<div>昨日同期:<span role="yGmv" class="pull-right">0</span></div>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '<div class="panel-footer">' +
            '<div class="progress">' +
            '<div role="okr1" class="progress-bar progress-bar-info" role="progressbar" aria-valuemax="100" style="border-color:white;width: 0%">' +
            ' </div>' +
            ' </div>' +
            ' <span role="okr2" class="pull-right">-</span>' +
            ' <div class="clearfix"></div>' +
            '  </div>' +
            '</div>');
        sumGmvDiv.append(orderDiv);
        App.content.find("#content1").append(sumGmvDiv);

        var dashboard = $('<div class="row"></div>');
        var bookDiv = $(
            '<div class="col-lg-4 col-md-6">' +
            '<div class="panel panel-warning">' +
            '<div class="panel-heading">' +
            '<div class="row">' +
            '<div class="col-xs-12 text-right">' +
            '<div role="gmv" style="font-size: 24px;">0</div> ' +
            '<div>图书</div> ' +
            '<div>昨日同期:<span role="yGmv" class="pull-right">0</span></div>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '<div class="panel-footer">' +
            '<div class="progress">' +
            '<div role="okr1" class="progress-bar progress-bar-warning" role="progressbar" aria-valuemax="100" style="border-color:white;width: 0%">' +
            ' </div>' +
            ' </div>' +
            ' <span role="okr2" class="pull-right">0%</span>' +
            ' <div class="clearfix"></div>' +
            '  </div>' +
            '</div>');
        dashboard.append(bookDiv);
        var babyDiv = $(
            '<div class="col-lg-4 col-md-6">' +
            '<div class="panel panel-info">' +
            '<div class="panel-heading">' +
            '<div class="row">' +
            '<div class="col-xs-12 text-right">' +
            '<div role="gmv" style="font-size: 24px;">0</div> ' +
            '<div>婴童</div> ' +
            '<div>昨日同期:<span role="yGmv" class="pull-right">0</span></div>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '<div class="panel-footer">' +
            '<div class="progress">' +
            '<div role="okr1" class="progress-bar progress-bar-info" role="progressbar" aria-valuemax="100" style="border-color:white;width: 0%">' +
            ' </div>' +
            ' </div>' +
            ' <span role="okr2" class="pull-right">0%</span>' +
            ' <div class="clearfix"></div>' +
            '  </div>' +
            '</div>');
        dashboard.append(babyDiv);
        var toyDiv = $(
            '<div class="col-lg-4 col-md-6">' +
            '<div class="panel panel-success">' +
            '<div class="panel-heading">' +
            '<div class="row">' +
            '<div class="col-xs-12 text-right">' +
            '<div role="gmv" style="font-size: 24px;">0</div> ' +
            '<div>玩具</div> ' +
            '<div>昨日同期:<span role="yGmv" class="pull-right">0</span></div>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '<div class="panel-footer">' +
            '<div class="progress">' +
            '<div role="okr1" class="progress-bar progress-bar-success" role="progressbar" aria-valuemax="100" style="border-color:white;width: 0%">' +
            ' </div>' +
            ' </div>' +
            ' <span role="okr2" class="pull-right">0%</span>' +
            ' <div class="clearfix"></div>' +
            '  </div>' +
            '</div>');
        dashboard.append(toyDiv);
        var beautyDiv = $(
            '<div class="col-lg-4 col-md-6">' +
            '<div class="panel panel-danger">' +
            '<div class="panel-heading">' +
            '<div class="row">' +
            '<div class="col-xs-12 text-right">' +
            '<div role="gmv" style="font-size: 24px;">0</div> ' +
            '<div>美护</div> ' +
            '<div>昨日同期:<span role="yGmv" class="pull-right">0</span></div>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '<div class="panel-footer">' +
            '<div class="progress">' +
            '<div role="okr1" class="progress-bar progress-bar-danger" role="progressbar" aria-valuemax="100" style="border-color:white;width: 0%">' +
            ' </div>' +
            ' </div>' +
            ' <span role="okr2" class="pull-right">0%</span>' +
            ' <div class="clearfix"></div>' +
            '  </div>' +
            '</div>');
        dashboard.append(beautyDiv);
        var lifeDiv = $(
            '<div class="col-lg-4 col-md-6">' +
            '<div class="panel panel-warning">' +
            '<div class="panel-heading">' +
            '<div class="row">' +
            '<div class="col-xs-12 text-right">' +
            '<div role="gmv" style="font-size: 24px;">0</div> ' +
            '<div>生活</div> ' +
            '<div>昨日同期:<span role="yGmv" class="pull-right">0</span></div>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '<div class="panel-footer">' +
            '<div class="progress">' +
            '<div role="okr1" class="progress-bar progress-bar-warning" role="progressbar" aria-valuemax="100" style="border-color:white;width: 0%">' +
            ' </div>' +
            ' </div>' +
            ' <span role="okr2" class="pull-right">0%</span>' +
            ' <div class="clearfix"></div>' +
            '  </div>' +
            '</div>');
        dashboard.append(lifeDiv);
        var shopDiv = $(
            '<div class="col-lg-4 col-md-6">' +
            '<div class="panel panel-info">' +
            '<div class="panel-heading">' +
            '<div class="row">' +
            '<div class="col-xs-12 text-right">' +
            '<div role="gmv" style="font-size: 24px;">0</div> ' +
            '<div>开店</div> ' +
            '<div>昨日同期:<span role="yGmv" class="pull-right">0</span></div>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '<div class="panel-footer">' +
            '<div class="progress">' +
            '<div role="okr1" class="progress-bar progress-bar-info" role="progressbar" aria-valuemax="100" style="border-color:white;width: 0%">' +
            ' </div>' +
            ' </div>' +
            ' <span role="okr2" class="pull-right">-</span>' +
            ' <div class="clearfix"></div>' +
            '  </div>' +
            '</div>');
        dashboard.append(shopDiv);
        App.content.find("#content2").append(dashboard);
        $.ajax({
            type: "GET",
            dataType: "json",
            url: App.href + "/api/dvd/index/dashboard/gmv",
            success: function (data) {
                if (data.code === 200) {
                    bookDiv.find("[role=gmv]").html(toThousands(data.data.bookGmv));
                    bookDiv.find("[role=yGmv]").html(toThousands(data.data.yesterdayBookGmv));
                    bookDiv.find("[role=okr1]").css("width", parseFloat(data.data.bookGmv / data.data.bookOkr * 100).toFixed(2) + "%");
                    bookDiv.find("[role=okr2]").html(parseFloat(data.data.bookGmv / data.data.bookOkr * 100).toFixed(2) + "%");
                    babyDiv.find("[role=gmv]").html(toThousands(data.data.babyGmv));
                    babyDiv.find("[role=yGmv]").html(toThousands(data.data.yesterdayBabyGmv));
                    babyDiv.find("[role=okr1]").css("width", parseFloat(data.data.babyGmv / data.data.babyOkr * 100).toFixed(2) + "%");
                    babyDiv.find("[role=okr2]").html(parseFloat(data.data.babyGmv / data.data.babyOkr * 100).toFixed(2) + "%");
                    toyDiv.find("[role=gmv]").html(toThousands(data.data.toyGmv));
                    toyDiv.find("[role=yGmv]").html(toThousands(data.data.yesterdayToyGmv));
                    toyDiv.find("[role=okr1]").css("width", parseFloat(data.data.toyGmv / data.data.toyOkr * 100).toFixed(2) + "%");
                    toyDiv.find("[role=okr2]").html(parseFloat(data.data.toyGmv / data.data.toyOkr * 100).toFixed(2) + "%");
                    beautyDiv.find("[role=gmv]").html(toThousands(data.data.beautyGmv));
                    beautyDiv.find("[role=yGmv]").html(toThousands(data.data.yesterdayBeautyGmv));
                    beautyDiv.find("[role=okr1]").css("width", parseFloat(data.data.beautyGmv / data.data.beautyOkr * 100).toFixed(2) + "%");
                    beautyDiv.find("[role=okr2]").html(parseFloat(data.data.beautyGmv / data.data.beautyOkr * 100).toFixed(2) + "%");
                    lifeDiv.find("[role=gmv]").html(toThousands(data.data.lifeGmv));
                    lifeDiv.find("[role=yGmv]").html(toThousands(data.data.yesterdayLifeGmv));
                    lifeDiv.find("[role=okr1]").css("width", parseFloat(data.data.lifeGmv / data.data.lifeOkr * 100).toFixed(2) + "%");
                    lifeDiv.find("[role=okr2]").html(parseFloat(data.data.lifeGmv / data.data.lifeOkr * 100).toFixed(2) + "%");
                    shopDiv.find("[role=gmv]").html(toThousands(data.data.shopGmv));
                    shopDiv.find("[role=yGmv]").html(toThousands(data.data.yesterdayShopGmv));
                    shopDiv.find("[role=okr1]").css("width", parseFloat(data.data.shopGmv / data.data.shopOkr * 100).toFixed(2) + "%");
                    shopDiv.find("[role=okr2]").html(parseFloat(data.data.shopGmv / data.data.shopOkr * 100).toFixed(2) + "%");
                    gmvDiv.find("[role=gmv]").html(toThousands(data.data.allGmv));
                    gmvDiv.find("[role=yGmv]").html(toThousands(data.data.yesterdayAllGmv));
                    gmvDiv.find("[role=okr1]").css("width", parseFloat(data.data.allGmv / data.data.allOkr * 100).toFixed(2) + "%");
                    gmvDiv.find("[role=okr2]").html(parseFloat(data.data.allGmv / data.data.allOkr * 100).toFixed(2) + "%");
                    orderDiv.find("[role=gmv]").html(toThousands(data.data.allOrderCount));
                    orderDiv.find("[role=yGmv]").html(toThousands(data.data.yesterdayAllOrderCount));
                } else {
                    bootbox.alert(data.message)
                }
            }
        });
        dashboard.everyTime('150s', function () {
            $.ajax({
                type: "GET",
                dataType: "json",
                url: App.href + "/api/dvd/index/dashboard/gmv",
                success: function (data) {
                    if (data.code === 200) {
                        bookDiv.find("[role=gmv]").html(toThousands(data.data.bookGmv));
                        bookDiv.find("[role=yGmv]").html(toThousands(data.data.yesterdayBookGmv));
                        bookDiv.find("[role=okr1]").css("width", parseFloat(data.data.bookGmv / data.data.bookOkr * 100).toFixed(2) + "%");
                        bookDiv.find("[role=okr2]").html(parseFloat(data.data.bookGmv / data.data.bookOkr * 100).toFixed(2) + "%");
                        babyDiv.find("[role=gmv]").html(toThousands(data.data.babyGmv));
                        babyDiv.find("[role=yGmv]").html(toThousands(data.data.yesterdayBabyGmv));
                        babyDiv.find("[role=okr1]").css("width", parseFloat(data.data.babyGmv / data.data.babyOkr * 100).toFixed(2) + "%");
                        babyDiv.find("[role=okr2]").html(parseFloat(data.data.babyGmv / data.data.babyOkr * 100).toFixed(2) + "%");
                        toyDiv.find("[role=gmv]").html(toThousands(data.data.toyGmv));
                        toyDiv.find("[role=yGmv]").html(toThousands(data.data.yesterdayToyGmv));
                        toyDiv.find("[role=okr1]").css("width", parseFloat(data.data.toyGmv / data.data.toyOkr * 100).toFixed(2) + "%");
                        toyDiv.find("[role=okr2]").html(parseFloat(data.data.toyGmv / data.data.toyOkr * 100).toFixed(2) + "%");
                        beautyDiv.find("[role=gmv]").html(toThousands(data.data.beautyGmv));
                        beautyDiv.find("[role=yGmv]").html(toThousands(data.data.yesterdayBeautyGmv));
                        beautyDiv.find("[role=okr1]").css("width", parseFloat(data.data.beautyGmv / data.data.beautyOkr * 100).toFixed(2) + "%");
                        beautyDiv.find("[role=okr2]").html(parseFloat(data.data.beautyGmv / data.data.beautyOkr * 100).toFixed(2) + "%");
                        lifeDiv.find("[role=gmv]").html(toThousands(data.data.lifeGmv));
                        lifeDiv.find("[role=yGmv]").html(toThousands(data.data.yesterdayLifeGmv));
                        lifeDiv.find("[role=okr1]").css("width", parseFloat(data.data.lifeGmv / data.data.lifeOkr * 100).toFixed(2) + "%");
                        lifeDiv.find("[role=okr2]").html(parseFloat(data.data.lifeGmv / data.data.lifeOkr * 100).toFixed(2) + "%");
                        shopDiv.find("[role=gmv]").html(toThousands(data.data.shopGmv));
                        shopDiv.find("[role=yGmv]").html(toThousands(data.data.yesterdayShopGmv));
                        shopDiv.find("[role=okr1]").css("width", parseFloat(data.data.shopGmv / data.data.shopOkr * 100).toFixed(2) + "%");
                        shopDiv.find("[role=okr2]").html(parseFloat(data.data.shopGmv / data.data.shopOkr * 100).toFixed(2) + "%");
                        gmvDiv.find("[role=gmv]").html(toThousands(data.data.allGmv));
                        gmvDiv.find("[role=yGmv]").html(toThousands(data.data.yesterdayAllGmv));
                        gmvDiv.find("[role=okr1]").css("width", parseFloat(data.data.allGmv / data.data.allOkr * 100).toFixed(2) + "%");
                        gmvDiv.find("[role=okr2]").html(parseFloat(data.data.allGmv / data.data.allOkr * 100).toFixed(2) + "%");
                        orderDiv.find("[role=gmv]").html(toThousands(data.data.allOrderCount));
                        orderDiv.find("[role=yGmv]").html(toThousands(data.data.yesterdayAllOrderCount));
                    } else {
                        bootbox.alert(data.message)
                    }
                }
            });
        });

    };

    var toThousands = function (num) {
        return (num || 0).toString().replace(/(\d{1,3})(?=(\d{3})+(?:$|\.))/g, "$1,");
    }

})(jQuery, window, document);
