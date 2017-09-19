package com.topie.huaifang.core.api.mobile;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.IAppUserService;
import com.topie.huaifang.core.service.ICommonQueryService;
import com.topie.huaifang.database.core.model.AppUser;
import com.topie.huaifang.database.core.model.User;
import com.topie.huaifang.security.exception.AuBzConstant;
import com.topie.huaifang.security.exception.AuthBusinessException;
import com.topie.huaifang.security.service.UserService;
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
@RequestMapping("/api/m/appUser")
public class MoAppUserController {

    @Autowired
    private IAppUserService iAppUserService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/friends", method = RequestMethod.GET)
    @ResponseBody
    public Result friends(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        Integer userId = SecurityUtil.getCurrentUserId();
        PageInfo<AppUser> pageInfo = iAppUserService.selectAppUserFriends(userId, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public Result updatePassword(@RequestParam("id") Integer id, @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword) {
        AppUser appUser = iAppUserService.selectByKey(id);
        if (oldPassword.equals(appUser.getPassword())) {
            userService.updatePassword(appUser.getPlatformId(), appUser.getPassword());
            appUser.setPassword(newPassword);
        }
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/currentAppUser", method = RequestMethod.GET)
    @ResponseBody
    public Result currentAppUser() {
        AppUser appUser = iAppUserService.selectByPlatformId(SecurityUtil.getCurrentUserId());
        return ResponseUtil.success(appUser);
    }

}
