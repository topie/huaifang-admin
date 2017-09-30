package com.topie.huaifang.core.api.mobile;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.IAppUserService;
import com.topie.huaifang.core.service.IAuthUserService;
import com.topie.huaifang.core.service.ICompanyInfoService;
import com.topie.huaifang.database.core.model.AppUser;
import com.topie.huaifang.database.core.model.AuthUser;
import com.topie.huaifang.database.core.model.CompanyInfo;
import com.topie.huaifang.security.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/m/companyInfo")
public class MoCompanyInfoController {

    @Autowired
    private ICompanyInfoService iCompanyInfoService;

    @Autowired
    private IAuthUserService iAuthUserService;

    @Autowired
    private IAppUserService iAppUserService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(CompanyInfo companyInfo,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<CompanyInfo> pageInfo = iCompanyInfoService.selectByFilterAndPage(companyInfo, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/myCompany", method = RequestMethod.GET)
    @ResponseBody
    public Result myCompany() {
        Integer userId = SecurityUtil.getCurrentUserId();
        if (userId == null) return ResponseUtil.error("未登录");
        AppUser appUser = iAppUserService.selectByKey(userId);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        AuthUser authUser = iAuthUserService.selectByKey(appUser.getId());
        if (authUser == null || authUser.getCompanyId() == 0) {
            return ResponseUtil.error("未认证");
        }
        CompanyInfo companyInfo = iCompanyInfoService.selectByKey(authUser.getCompanyId());
        return ResponseUtil.success(companyInfo);
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    @ResponseBody
    public Result auth(@RequestParam("companyId") Integer companyId) {
        Integer userId = SecurityUtil.getCurrentUserId();
        if (userId == null) return ResponseUtil.error("未登录");
        AppUser appUser = iAppUserService.selectByKey(userId);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        AuthUser authUser = iAuthUserService.selectByKey(appUser.getId());
        if (authUser == null) {
            authUser = new AuthUser();
            authUser.setUserId(appUser.getId());
            authUser.setCompanyId(companyId);
            iAuthUserService.saveNotNull(authUser);
        } else {
            authUser.setUserId(appUser.getId());
            authUser.setCompanyId(companyId);
            iAuthUserService.updateNotNull(authUser);
        }
        return ResponseUtil.success();
    }
}
