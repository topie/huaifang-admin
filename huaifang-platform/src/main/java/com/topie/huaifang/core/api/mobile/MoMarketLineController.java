package com.topie.huaifang.core.api.mobile;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.IAppUserService;
import com.topie.huaifang.core.service.IMarketLineService;
import com.topie.huaifang.database.core.model.AppUser;
import com.topie.huaifang.database.core.model.MarketLine;
import com.topie.huaifang.security.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/m/marketLine")
public class MoMarketLineController {

    @Autowired
    private IMarketLineService iMarketLineService;

    @Autowired
    private IAppUserService iAppUserService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(MarketLine marketLine,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<MarketLine> pageInfo = iMarketLineService.selectByFilterAndPage(marketLine, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public Result post(@RequestBody MarketLine marketLine) {
        AppUser appUser = iAppUserService.selectByPlatformId(SecurityUtil.getCurrentUserId());
        if (appUser == null) return ResponseUtil.error("未登录");
        marketLine.setAddUserId(appUser.getId());
        marketLine.setAddUserName(appUser.getNickname());
        marketLine.setAddTime(new Date());
        marketLine.setPublishTime(new Date());
        int result = iMarketLineService.saveNotNull(marketLine);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public Result detail(@RequestParam(value = "id") Integer id) {
        MarketLine marketLine = iMarketLineService.selectByKey(id);
        return ResponseUtil.success(marketLine);
    }

    @RequestMapping(value = "/like", method = RequestMethod.GET)
    @ResponseBody
    public Result like(@RequestParam(value = "id") Integer id) {
        MarketLine marketLine = iMarketLineService.selectByKey(id);
        marketLine.setiCount(marketLine.getiCount() + 1);
        return ResponseUtil.success(marketLine.getiCount() + 1);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iMarketLineService.delete(id);
        return ResponseUtil.success();
    }

}
