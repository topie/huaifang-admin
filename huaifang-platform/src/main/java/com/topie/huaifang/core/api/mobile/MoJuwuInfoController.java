package com.topie.huaifang.core.api.mobile;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.ICommonQueryService;
import com.topie.huaifang.core.service.ICunwuInfoService;
import com.topie.huaifang.database.core.model.CunwuInfo;
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
@RequestMapping("/api/m/juwuInfo")
public class MoJuwuInfoController {

    @Autowired
    private ICunwuInfoService iCunwuInfoService;

    @Autowired
    private ICommonQueryService iCommonQueryService;

    @RequestMapping(value = "/navs", method = RequestMethod.GET)
    @ResponseBody
    public Result navs() {
        List<CunwuInfo> list = iCunwuInfoService.selectTitles();
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public Result load(@RequestParam(value = "id") Integer id) {
        CunwuInfo cunwuInfo = iCunwuInfoService.selectByKey(id);
        return ResponseUtil.success(cunwuInfo);
    }

}
