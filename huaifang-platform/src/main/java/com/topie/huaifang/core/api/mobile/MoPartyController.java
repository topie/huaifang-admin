package com.topie.huaifang.core.api.mobile;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.*;
import com.topie.huaifang.database.core.model.*;
import com.topie.huaifang.security.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/m/party")
public class MoPartyController {

    @Autowired
    private IPartyMembersActivityService iPartyMembersActivityService;

    @Autowired
    private IPartyMembersInfoService iPartyMembersInfoService;

    @Autowired
    private IPartyMembersBusinessService iPartyMembersBusinessService;

    @Autowired
    private IAppUserService iAppUserService;

    @Autowired
    private IPartyActivityJoinService iPartyActivityJoinService;

    @RequestMapping(value = "/activity/list", method = RequestMethod.GET)
    @ResponseBody
    public Result activityList(PartyMembersActivity partyMembersActivity,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<PartyMembersActivity> pageInfo = iPartyMembersActivityService
                .selectByFilterAndPage(partyMembersActivity, pageNum, pageSize);
        for (PartyMembersActivity membersActivity : pageInfo.getList()) {
            PartyActivityJoin partyActivityJoin = new PartyActivityJoin();
            partyActivityJoin.setActivityId(membersActivity.getId());
            membersActivity.setTotal(iPartyActivityJoinService.selectByFilter(partyActivityJoin).size());
        }
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/activity/detail", method = RequestMethod.GET)
    @ResponseBody
    public Result activityDetail(@RequestParam(value = "id") Integer id) {
        Integer userId = SecurityUtil.getCurrentUserId();
        if (userId == null) return ResponseUtil.error(401, "未登录");
        AppUser appUser = iAppUserService.selectByPlatformId(userId);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        PartyMembersActivity partyMembersActivity = iPartyMembersActivityService.selectByKey(id);
        PartyActivityJoin partyActivityJoin = new PartyActivityJoin();
        partyActivityJoin.setActivityId(partyMembersActivity.getId());
        partyMembersActivity.setTotal(iPartyActivityJoinService.selectByFilter(partyActivityJoin).size());
        partyActivityJoin.setUserId(appUser.getId());
        if (iPartyActivityJoinService.selectByFilter(partyActivityJoin).size() > 0) {
            partyMembersActivity.setHasJoin(true);
        } else {
            partyMembersActivity.setHasJoin(false);
        }
        return ResponseUtil.success(partyMembersActivity);
    }

    @RequestMapping(value = "/activity/post", method = RequestMethod.POST)
    @ResponseBody
    public Result activityPost(PartyMembersActivity partyMembersActivity) {
        Integer userId = SecurityUtil.getCurrentUserId();
        if (userId == null) return ResponseUtil.error(401, "未登录");
        AppUser appUser = iAppUserService.selectByPlatformId(userId);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        partyMembersActivity.setTotal(0);
        partyMembersActivity.setStatus(1);
        partyMembersActivity.setPublishUserId(appUser.getId());
        partyMembersActivity.setPublishUser(appUser.getRealname());
        iPartyMembersActivityService.saveNotNull(partyMembersActivity);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/activity/join", method = RequestMethod.GET)
    @ResponseBody
    public Result activityJoin(@RequestParam(value = "id") Integer id) {
        Integer userId = SecurityUtil.getCurrentUserId();
        if (userId == null) return ResponseUtil.error(401, "未登录");
        AppUser appUser = iAppUserService.selectByPlatformId(userId);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        PartyActivityJoin partyActivityJoin = new PartyActivityJoin();
        partyActivityJoin.setActivityId(id);
        partyActivityJoin.setUserId(appUser.getId());
        if (iPartyActivityJoinService.selectByFilter(partyActivityJoin).size() > 0) {
            return ResponseUtil.success();
        }
        iPartyActivityJoinService.saveNotNull(partyActivityJoin);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/activity/cancelJoin", method = RequestMethod.GET)
    @ResponseBody
    public Result cancelJoin(@RequestParam(value = "id") Integer id) {
        Integer userId = SecurityUtil.getCurrentUserId();
        if (userId == null) return ResponseUtil.error(401, "未登录");
        AppUser appUser = iAppUserService.selectByPlatformId(userId);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        PartyActivityJoin partyActivityJoin = new PartyActivityJoin();
        partyActivityJoin.setActivityId(id);
        partyActivityJoin.setUserId(appUser.getId());
        List<PartyActivityJoin> list = iPartyActivityJoinService.selectByFilter(partyActivityJoin);
        if (list.size() > 0) {
            for (PartyActivityJoin activityJoin : list) {
                iPartyActivityJoinService.delete(activityJoin);
            }
        }
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/member/list", method = RequestMethod.GET)
    @ResponseBody
    public Result infoList(PartyMembersInfo partyMembersInfo) {
        List<PartyMembersInfo> list = iPartyMembersInfoService.selectByFilter(partyMembersInfo);
        return ResponseUtil.success(PageConvertUtil.grid(list));
    }

    @RequestMapping(value = "/business/list", method = RequestMethod.GET)
    @ResponseBody
    public Result businessList(PartyMembersBusiness partyMembersBusiness,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<PartyMembersBusiness> pageInfo = iPartyMembersBusinessService
                .selectByFilterAndPage(partyMembersBusiness, pageNum, pageSize);
        for (PartyMembersBusiness membersBusiness : pageInfo.getList()) {
            membersBusiness.setContent(null);
        }
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/business/detail", method = RequestMethod.GET)
    @ResponseBody
    public Result load(@RequestParam(value = "id") Integer id) {
        PartyMembersBusiness partyMembersBusiness = iPartyMembersBusinessService.selectByKey(id);
        partyMembersBusiness.setReadCount(partyMembersBusiness.getReadCount() + 1);
        iPartyMembersBusinessService.updateNotNull(partyMembersBusiness);
        return ResponseUtil.success(partyMembersBusiness);
    }

}
