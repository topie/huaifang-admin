package com.topie.huaifang.core.api;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.tools.plugins.FormItem;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.*;
import com.topie.huaifang.database.core.model.*;
import com.topie.huaifang.security.exception.AuBzConstant;
import com.topie.huaifang.security.exception.AuthBusinessException;
import com.topie.huaifang.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/core/appUser")
public class AppUserController {

    @Autowired
    private IAppUserService iAppUserService;

    @Autowired
    private ICommonQueryService iCommonQueryService;

    @Autowired
    private UserService userService;

    @Autowired
    private IAuthUserService iAuthUserService;

    @Autowired
    private IPersonInfoService iPersonInfoService;

    @Autowired
    private IPersonInfoLiveService iPersonInfoLiveService;

    @Autowired
    private IPersonInfoRentService iPersonInfoRentService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(AppUser appUser,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<AppUser> pageInfo = iAppUserService.selectByFilterAndPage(appUser, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/formItems", method = RequestMethod.GET)
    @ResponseBody
    public Result formItems() {
        List<FormItem> list = iCommonQueryService.selectFormItemsByTable("d_app_user");
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(AppUser appUser) {
        User user = new User();
        user.setLoginName(appUser.getMobilePhone());
        user.setContactPhone(appUser.getMobilePhone());
        user.setDisplayName(appUser.getMobilePhone());
        user.setPassword(appUser.getPassword());
        if (userService.findExistUser(user) > 0) {
            throw new AuthBusinessException(AuBzConstant.LOGIN_NAME_EXIST);
        }
        userService.insertUser(user);
        appUser.setPlatformId(user.getId());
        int result = iAppUserService.saveNotNull(appUser);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(AppUser appUser) {
        iAppUserService.updateNotNull(appUser);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result load(@PathVariable(value = "id") Integer id) {
        AppUser appUser = iAppUserService.selectByKey(id);
        return ResponseUtil.success(appUser);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iAppUserService.delete(id);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/pass", method = RequestMethod.GET)
    @ResponseBody
    public Result pass(@RequestParam(value = "id") Integer id) {
        AppUser appUser = iAppUserService.selectByKey(id);
        appUser.setStatus(2);
        iAppUserService.updateNotNull(appUser);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/nopass", method = RequestMethod.GET)
    @ResponseBody
    public Result nopass(@RequestParam(value = "id") Integer id) {
        AppUser appUser = iAppUserService.selectByKey(id);
        appUser.setStatus(3);
        iAppUserService.updateNotNull(appUser);
        AuthUser authUser = iAuthUserService.selectByKey(appUser.getId());
        PersonInfo personInfo = iPersonInfoService.selectByKey(authUser.getPersonId());
        //清除人口信息
        if (personInfo != null) {
            PersonInfoRent personInfoRent = iPersonInfoRentService.selectByPersonId(personInfo.getpId());
            if (personInfoRent != null) iPersonInfoRentService.delete(personInfoRent);
            PersonInfoLive personInfoLive = iPersonInfoLiveService.selectByPersonId(personInfo.getpId());
            if (personInfoLive != null) iPersonInfoLiveService.delete(personInfoLive);
            iPersonInfoService.delete(personInfo);
        }
        authUser.setHouseId(0);
        authUser.setPersonId(0);
        iAuthUserService.updateNotNull(authUser);
        return ResponseUtil.success();
    }

}
