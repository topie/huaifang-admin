package com.topie.huaifang.core.api.mobile;

import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.IAppUserService;
import com.topie.huaifang.core.service.IAuthUserService;
import com.topie.huaifang.database.core.model.AppUser;
import com.topie.huaifang.database.core.model.AuthUser;
import com.topie.huaifang.database.core.model.User;
import com.topie.huaifang.security.exception.AuBzConstant;
import com.topie.huaifang.security.exception.AuthBusinessException;
import com.topie.huaifang.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chenguojun on 8/31/16.
 */
@Controller
@RequestMapping("/api/m/noneAuth")
public class MoNoneAuthController {

    @Autowired
    private IAppUserService iAppUserService;

    @Autowired
    private UserService userService;

    @Autowired
    private IAuthUserService iAuthUserService;

    @RequestMapping("/unique")
    @ResponseBody
    public Result unique(@RequestParam(value = "mobile") String mobile) {
        int count = userService.countByLoginName(mobile);
        return count > 0 ? ResponseUtil.success(false) : ResponseUtil.success(true);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result register(AppUser appUser) {
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
        AuthUser authUser = new AuthUser();
        authUser.setUserId(appUser.getId());
        iAuthUserService.saveNotNull(authUser);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }
}
