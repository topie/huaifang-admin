package com.topie.huaifang.core.api.mobile;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.IAppMessageService;
import com.topie.huaifang.core.service.IAppUserMessageService;
import com.topie.huaifang.core.service.IAppUserService;
import com.topie.huaifang.database.core.model.AppUser;
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

    @Autowired
    private IAppMessageService iAppMessageService;

    @Autowired
    private IAppUserMessageService iAppUserMessageService;

    @RequestMapping(value = "/friends", method = RequestMethod.GET)
    @ResponseBody
    public Result friends(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        Integer userId = SecurityUtil.getCurrentUserId();
        PageInfo<AppUser> pageInfo = iAppUserService.selectAppUserFriends(userId, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/maybeKnown", method = RequestMethod.GET)
    @ResponseBody
    public Result maybeKnown(AppUser appUser,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        appUser.setStatus(2);
        PageInfo<AppUser> pageInfo = iAppUserService.selectByFilterAndPage(appUser, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public Result detail(@RequestParam(value = "id") Integer id) {
        AppUser appUser = iAppUserService.selectByKey(id);
        return ResponseUtil.success(appUser);
    }

    @RequestMapping(value = "/addFriend", method = RequestMethod.GET)
    @ResponseBody
    public Result addFriend(@RequestParam(value = "id") Integer id) {
        Integer userId = SecurityUtil.getCurrentUserId();
        if (userId == null) return ResponseUtil.error("未登录");
        AppUser appUser = iAppUserService.selectByKey(id);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        iAppUserService.insertToAddFriend(userId, id);
        iAppMessageService.sendSystemAppMessage(id, appUser.getHeadImage(), appUser.getNickname() + "添加好友",
                appUser.getNickname() + "添加您为好友");
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    @ResponseBody
    public Result sendMessage(@RequestParam(value = "userId") Integer userId,
            @RequestParam(value = "content") String content) {
        Integer cUserId = SecurityUtil.getCurrentUserId();
        if (userId == null) return ResponseUtil.error("未登录");
        AppUser appUser = iAppUserService.selectByKey(cUserId);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        iAppUserMessageService
                .insertToSendUserAppMessage(cUserId, appUser.getNickname(), appUser.getHeadImage(), userId, content);
        iAppMessageService.sentUserAppMessage(cUserId, userId, appUser.getNickname() + "发来新的消息");
        return ResponseUtil.success();
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
