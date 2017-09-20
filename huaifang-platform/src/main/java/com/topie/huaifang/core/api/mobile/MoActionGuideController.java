package com.topie.huaifang.core.api.mobile;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.IActionGuideCatService;
import com.topie.huaifang.core.service.IActionGuideService;
import com.topie.huaifang.database.core.model.ActionGuide;
import com.topie.huaifang.database.core.model.ActionGuideCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/m/actionGuide")
public class MoActionGuideController {

    @Autowired
    private IActionGuideCatService iActionGuideCatService;

    @Autowired
    private IActionGuideService iActionGuideService;

    @RequestMapping(value = "/navs", method = RequestMethod.GET)
    @ResponseBody
    public Result navs(ActionGuideCat actionGuideCat) {
        actionGuideCat.setStatus("已上线");
        List<ActionGuideCat> list = iActionGuideCatService.selectByFilter(actionGuideCat);
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(ActionGuide actionGuide,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<ActionGuide> pageInfo = iActionGuideService.selectByFilterAndPage(actionGuide, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public Result detail(@RequestParam(value = "id") Integer id) {
        ActionGuide actionGuide = iActionGuideService.selectByKey(id);
        return ResponseUtil.success(actionGuide);
    }

}
