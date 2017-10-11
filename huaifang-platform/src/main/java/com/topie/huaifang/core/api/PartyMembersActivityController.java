package com.topie.huaifang.core.api;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.tools.plugins.FormItem;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.IAppUserService;
import com.topie.huaifang.core.service.ICommonQueryService;
import com.topie.huaifang.core.service.IPartyActivityJoinService;
import com.topie.huaifang.core.service.IPartyMembersActivityService;
import com.topie.huaifang.database.core.model.AppUser;
import com.topie.huaifang.database.core.model.PartyActivityJoin;
import com.topie.huaifang.database.core.model.PartyMembersActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/core/partyMembersActivity")
public class PartyMembersActivityController {

    @Autowired
    private IPartyMembersActivityService iPartyMembersActivityService;

    @Autowired
    private ICommonQueryService iCommonQueryService;

    @Autowired
    private IPartyActivityJoinService iPartyActivityJoinService;

    @Autowired
    private IAppUserService iAppUserService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(PartyMembersActivity partyMembersActivity,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<PartyMembersActivity> pageInfo = iPartyMembersActivityService
                .selectByFilterAndPage(partyMembersActivity, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/formItems", method = RequestMethod.GET)
    @ResponseBody
    public Result formItems() {
        List<FormItem> list = iCommonQueryService.selectFormItemsByTable("d_party_members_activity");
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(PartyMembersActivity partyMembersActivity) {
        int result = iPartyMembersActivityService.saveNotNull(partyMembersActivity);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(PartyMembersActivity partyMembersActivity) {
        iPartyMembersActivityService.updateNotNull(partyMembersActivity);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result load(@PathVariable(value = "id") Integer id) {
        PartyMembersActivity partyMembersActivity = iPartyMembersActivityService.selectByKey(id);
        return ResponseUtil.success(partyMembersActivity);
    }

    @RequestMapping(value = "/joinUsers", method = RequestMethod.GET)
    @ResponseBody
    public Result joinUsers(@RequestParam(value = "id") Integer id) {
        PartyActivityJoin partyActivityJoin = new PartyActivityJoin();
        partyActivityJoin.setActivityId(id);
        List<PartyActivityJoin> list = iPartyActivityJoinService.selectByFilter(partyActivityJoin);
        List<Integer> userList = new ArrayList<>();
        for (PartyActivityJoin activityJoin : list) {
            userList.add(activityJoin.getUserId());
        }
        AppUser appUser = new AppUser();
        appUser.setUserIds(userList);
        List<AppUser> appUsers = iAppUserService.selectByFilter(appUser);
        return ResponseUtil.success(PageConvertUtil.grid(appUsers));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iPartyMembersActivityService.delete(id);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/online", method = RequestMethod.GET)
    @ResponseBody
    public Result online(@RequestParam(value = "id") Integer id) {
        PartyMembersActivity partyMembersActivity = iPartyMembersActivityService.selectByKey(id);
        partyMembersActivity.setStatus(1);
        iPartyMembersActivityService.updateNotNull(partyMembersActivity);
        return ResponseUtil.success();
    }

}
