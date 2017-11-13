package com.topie.huaifang.core.api.mobile;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.IAppUserService;
import com.topie.huaifang.core.service.IAroundActivityJoinService;
import com.topie.huaifang.core.service.IAroundActivityService;
import com.topie.huaifang.database.core.model.AppUser;
import com.topie.huaifang.database.core.model.AroundActivity;
import com.topie.huaifang.database.core.model.AroundActivityJoin;
import com.topie.huaifang.security.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/m/aroundActivity")
public class MoAroundActivityController {

    @Autowired
    private IAroundActivityService iAroundActivityService;

    @Autowired
    private IAppUserService iAppUserService;

    @Autowired
    private IAroundActivityJoinService iAroundActivityJoinService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result activityList(AroundActivity aroundActivity,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        Integer userId = SecurityUtil.getCurrentUserId();
        if (userId == null) return ResponseUtil.error(401, "未登录");
        AppUser appUser = iAppUserService.selectByPlatformId(userId);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        String type = aroundActivity.getType();
        aroundActivity.setType(null);
        if ("2".equals(type)) {
            aroundActivity.setPublishUserId(appUser.getId());
        }
        PageInfo<AroundActivity> pageInfo = iAroundActivityService
                .selectByFilterAndPage(aroundActivity, pageNum, pageSize);
        if (pageNum > pageInfo.getPages()) {
            return ResponseUtil.success(PageConvertUtil.grid(new ArrayList<>()));
        }
        for (AroundActivity activity : pageInfo.getList()) {
            AroundActivityJoin aroundActivityJoin = new AroundActivityJoin();
            aroundActivityJoin.setActivityId(aroundActivity.getId());
            activity.setTotal(iAroundActivityJoinService.selectByFilter(aroundActivityJoin).size());
        }
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public Result activityDetail(@RequestParam(value = "id") Integer id) {
        Integer userId = SecurityUtil.getCurrentUserId();
        if (userId == null) return ResponseUtil.error(401, "未登录");
        AppUser appUser = iAppUserService.selectByPlatformId(userId);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        AroundActivity aroundActivity = iAroundActivityService.selectByKey(id);
        AroundActivityJoin aroundActivityJoin = new AroundActivityJoin();
        aroundActivityJoin.setActivityId(aroundActivity.getId());
        aroundActivity.setTotal(iAroundActivityJoinService.selectByFilter(aroundActivityJoin).size());
        aroundActivityJoin.setUserId(appUser.getId());
        if (iAroundActivityJoinService.selectByFilter(aroundActivityJoin).size() > 0) {
            aroundActivity.setHasJoin(true);
        } else {
            aroundActivity.setHasJoin(false);
        }
        return ResponseUtil.success(aroundActivity);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public Result activityPost(AroundActivity aroundActivity) {
        Integer userId = SecurityUtil.getCurrentUserId();
        if (userId == null) return ResponseUtil.error(401, "未登录");
        AppUser appUser = iAppUserService.selectByPlatformId(userId);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        aroundActivity.setTotal(0);
        aroundActivity.setStatus("未开始");
        aroundActivity.setPublishUserId(appUser.getId());
        aroundActivity.setPublishUser(appUser.getRealname());
        iAroundActivityService.saveNotNull(aroundActivity);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    @ResponseBody
    public Result activityJoin(@RequestParam(value = "id") Integer id) {
        Integer userId = SecurityUtil.getCurrentUserId();
        if (userId == null) return ResponseUtil.error(401, "未登录");
        AppUser appUser = iAppUserService.selectByPlatformId(userId);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        AroundActivityJoin aroundActivityJoin = new AroundActivityJoin();
        aroundActivityJoin.setActivityId(id);
        aroundActivityJoin.setUserId(appUser.getId());
        if (iAroundActivityJoinService.selectByFilter(aroundActivityJoin).size() > 0) {
            return ResponseUtil.success();
        }
        iAroundActivityJoinService.saveNotNull(aroundActivityJoin);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/cancelJoin", method = RequestMethod.GET)
    @ResponseBody
    public Result cancelJoin(@RequestParam(value = "id") Integer id) {
        Integer userId = SecurityUtil.getCurrentUserId();
        if (userId == null) return ResponseUtil.error(401, "未登录");
        AppUser appUser = iAppUserService.selectByPlatformId(userId);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        AroundActivityJoin aroundActivityJoin = new AroundActivityJoin();
        aroundActivityJoin.setActivityId(id);
        aroundActivityJoin.setUserId(appUser.getId());
        List<AroundActivityJoin> list = iAroundActivityJoinService.selectByFilter(aroundActivityJoin);
        if (list.size() > 0) {
            for (AroundActivityJoin activityJoin : list) {
                iAroundActivityJoinService.delete(activityJoin);
            }
        }
        return ResponseUtil.success();
    }

}
