package com.topie.huaifang.core.api.mobile;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.IAdviceBoxService;
import com.topie.huaifang.core.service.IAppUserService;
import com.topie.huaifang.database.core.model.AdviceBox;
import com.topie.huaifang.database.core.model.AppUser;
import com.topie.huaifang.security.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/m/adviceBox")
public class MoAdviceBoxController {

    @Autowired
    private IAdviceBoxService iAdviceBoxService;

    @Autowired
    private IAppUserService iAppUserService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(AdviceBox adviceBox,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        AppUser appUser = iAppUserService.selectByPlatformId(SecurityUtil.getCurrentUserId());
        if (appUser == null) return ResponseUtil.error(401,"未登录");
        adviceBox.setContactUserId(appUser.getId());
        PageInfo<AdviceBox> pageInfo = iAdviceBoxService.selectByFilterAndPage(adviceBox, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public Result post(@RequestBody AdviceBox adviceBox) {
        AppUser appUser = iAppUserService.selectByPlatformId(SecurityUtil.getCurrentUserId());
        if (appUser == null) return ResponseUtil.error(401,"未登录");
        adviceBox.setContactUserId(appUser.getId());
        adviceBox.setMessageTime(new Date());
        adviceBox.setStatus("未处理");
        int result = iAdviceBoxService.saveNotNull(adviceBox);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

}
