package com.topie.huaifang.core.api.mobile;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.IAppMessageService;
import com.topie.huaifang.core.service.IAppUserService;
import com.topie.huaifang.database.core.model.AppMessage;
import com.topie.huaifang.database.core.model.AppUser;
import com.topie.huaifang.security.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/m/appMessage")
public class MoAppMessageController {

    @Autowired
    private IAppMessageService iAppMessageService;

    @Autowired
    private IAppUserService iAppUserService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(AppMessage appMessage,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<AppMessage> pageInfo = iAppMessageService.selectByFilterAndPage(appMessage, pageNum, pageSize);
        for (AppMessage item : pageInfo.getList()) {
            item.setContent(null);
        }
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public Result detail(@RequestParam(value = "id") Integer id) {
        AppMessage appMessage = iAppMessageService.selectByKey(id);
        appMessage.setIsRead(1);
        return ResponseUtil.success(appMessage);
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(AppMessage appMessage) {
        AppUser appUser = iAppUserService.selectByPlatformId(SecurityUtil.getCurrentUserId());
        appMessage.setCreateTime(new Date());
        appMessage.setIsRead(0);
        appMessage.setFromUserId(appUser.getId());
        appMessage.setIcon(appUser.getHeadImage());
        int result = iAppMessageService.saveNotNull(appMessage);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }
}
