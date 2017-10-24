package com.topie.huaifang.core.api;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.tools.plugins.FormItem;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.IAppUserService;
import com.topie.huaifang.core.service.IAroundActivityService;
import com.topie.huaifang.core.service.ICommonQueryService;
import com.topie.huaifang.core.service.IAroundActivityJoinService;
import com.topie.huaifang.database.core.model.AppUser;
import com.topie.huaifang.database.core.model.AroundActivity;
import com.topie.huaifang.database.core.model.AroundActivityJoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/core/aroundActivity")
public class AroundActivityController {

    @Autowired
    private IAroundActivityService iAroundActivityService;

    @Autowired
    private ICommonQueryService iCommonQueryService;

    @Autowired
    private IAroundActivityJoinService iAroundActivityJoinService;

    @Autowired
    private IAppUserService iAppUserService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(AroundActivity aroundActivity,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<AroundActivity> pageInfo = iAroundActivityService
                .selectByFilterAndPage(aroundActivity, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/formItems", method = RequestMethod.GET)
    @ResponseBody
    public Result formItems() {
        List<FormItem> list = iCommonQueryService.selectFormItemsByTable("d_around_activity");
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(AroundActivity aroundActivity) {
        int result = iAroundActivityService.saveNotNull(aroundActivity);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(AroundActivity aroundActivity) {
        iAroundActivityService.updateNotNull(aroundActivity);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result load(@PathVariable(value = "id") Integer id) {
        AroundActivity aroundActivity = iAroundActivityService.selectByKey(id);
        return ResponseUtil.success(aroundActivity);
    }

    @RequestMapping(value = "/joinUsers", method = RequestMethod.GET)
    @ResponseBody
    public Result joinUsers(@RequestParam(value = "id") Integer id) {
        AroundActivityJoin aroundActivityJoin = new AroundActivityJoin();
        aroundActivityJoin.setActivityId(id);
        List<AroundActivityJoin> list = iAroundActivityJoinService.selectByFilter(aroundActivityJoin);
        List<Integer> userList = new ArrayList<>();
        for (AroundActivityJoin activityJoin : list) {
            userList.add(activityJoin.getUserId());
        }
        List<AppUser> appUsers = new ArrayList<>();
        if (userList.size() > 0) {
            AppUser appUser = new AppUser();
            appUser.setUserIds(userList);
            appUsers = iAppUserService.selectByFilter(appUser);
        }
        return ResponseUtil.success(PageConvertUtil.grid(appUsers));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iAroundActivityService.delete(id);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/online", method = RequestMethod.GET)
    @ResponseBody
    public Result online(@RequestParam(value = "id") Integer id) {
        AroundActivity aroundActivity = iAroundActivityService.selectByKey(id);
        aroundActivity.setStatus("已开始");
        iAroundActivityService.updateNotNull(aroundActivity);
        return ResponseUtil.success();
    }

}
