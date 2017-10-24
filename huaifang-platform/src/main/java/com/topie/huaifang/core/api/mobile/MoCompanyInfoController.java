package com.topie.huaifang.core.api.mobile;

import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.ICompanyInfoService;
import com.topie.huaifang.database.core.model.CompanyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/m/companyInfo")
public class MoCompanyInfoController {

    @Autowired
    private ICompanyInfoService iCompanyInfoService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(CompanyInfo companyInfo) {
        List<CompanyInfo> list = iCompanyInfoService.selectByFilter(companyInfo);
        return ResponseUtil.success(PageConvertUtil.grid(list));
    }
}
