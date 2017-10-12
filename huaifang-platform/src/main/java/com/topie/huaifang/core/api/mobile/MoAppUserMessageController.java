package com.topie.huaifang.core.api.mobile;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.common.utils.date.DateUtil;
import com.topie.huaifang.core.service.IAppMessageService;
import com.topie.huaifang.core.service.IAppUserMessageService;
import com.topie.huaifang.core.service.IAppUserService;
import com.topie.huaifang.database.core.model.AppUser;
import com.topie.huaifang.database.core.model.AppUserMessage;
import com.topie.huaifang.security.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/m/appUserMessage")
public class MoAppUserMessageController {

    @Autowired
    private IAppUserMessageService iAppUserMessageService;

    @Autowired
    private IAppMessageService iAppMessageService;

    @Autowired
    private IAppUserService iAppUserService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(AppUserMessage appUserMessage,
            @RequestParam(value = "time",required = false,defaultValue = "0") Long time,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        AppUser appUser = iAppUserService.selectByPlatformId(SecurityUtil.getCurrentUserId());
        if (appUser == null) return ResponseUtil.error(401,"未登录");
        appUserMessage.setToUserId(appUser.getId());
        if(time>0){
            appUserMessage.setSendTime(DateUtil.getDateByMillionSecond(time));
        }
        PageInfo<AppUserMessage> pageInfo = iAppUserMessageService
                .selectByFilterAndPage(appUserMessage, pageNum, pageSize);
        Map extra = new HashMap();
        extra.put("time", new Date().getTime());
        extra.put("me", appUser);
        AppUser toUser = iAppUserService.selectByKey(appUserMessage.getFromUserId());
        extra.put("friend", toUser);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo, extra));
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@RequestBody AppUserMessage appUserMessage) {
        AppUser appUser = iAppUserService.selectByPlatformId(SecurityUtil.getCurrentUserId());
        appUserMessage.setSendTime(new Date());
        appUserMessage.setIsRead(0);
        appUserMessage.setFromUserId(appUser.getId());
        appUserMessage.setHeadImage(appUser.getHeadImage());
        int result = iAppUserMessageService.saveNotNull(appUserMessage);
        String title = appUserMessage.getContent();
        if (title.length() > 15) title = title.substring(0, 14) + "...";
        iAppMessageService.sentUserAppMessage(appUser.getId(), appUserMessage.getToUserId(), title);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

}
