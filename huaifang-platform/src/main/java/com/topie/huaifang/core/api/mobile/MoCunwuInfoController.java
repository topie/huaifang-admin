package com.topie.huaifang.core.api.mobile;

import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.IJuwuInfoService;
import com.topie.huaifang.database.core.model.JuwuInfo;
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
@RequestMapping("/api/m/cunwuInfo")
public class MoCunwuInfoController {

    @Autowired
    private IJuwuInfoService iJuwuInfoService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(JuwuInfo juwuInfo) {
        juwuInfo.setStatus("上线");
        List<JuwuInfo> list = iJuwuInfoService.selectByFilter(juwuInfo);
        return ResponseUtil.success(PageConvertUtil.grid(list));
    }

    @RequestMapping(value = "/navs", method = RequestMethod.GET)
    @ResponseBody
    public Result navs() {
        List<JuwuInfo> list = iJuwuInfoService.selectTitles();
        return ResponseUtil.success(PageConvertUtil.grid(list));
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public Result load(@RequestParam(value = "id") Integer id) {
        JuwuInfo juwuInfo = iJuwuInfoService.selectByKey(id);
        return ResponseUtil.success(juwuInfo);
    }

}
