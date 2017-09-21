package com.topie.huaifang.core.api.mobile;

import com.topie.huaifang.common.utils.Option;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.enums.YellowPageType;
import com.topie.huaifang.core.service.IYellowPageService;
import com.topie.huaifang.database.core.model.YellowPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/m/yellowPage")
public class MoYellowPageController {

    @Autowired
    private IYellowPageService iYellowPageService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(YellowPage yellowPage) {
        List<YellowPage> list = iYellowPageService.selectByFilter(yellowPage);
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/navs", method = RequestMethod.GET)
    @ResponseBody
    public Result options() {
        List<Option> options = new ArrayList<>();
        for (YellowPageType item : YellowPageType.getItemList()) {
            options.add(new Option(item.getName(), item.getCode()));
        }
        return ResponseUtil.success(options);
    }

}
