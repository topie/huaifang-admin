package com.topie.huaifang.core.api.mobile;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.IPartyMembersActivityService;
import com.topie.huaifang.core.service.IPartyMembersBusinessService;
import com.topie.huaifang.core.service.IPartyMembersInfoService;
import com.topie.huaifang.database.core.model.PartyMembersActivity;
import com.topie.huaifang.database.core.model.PartyMembersBusiness;
import com.topie.huaifang.database.core.model.PartyMembersInfo;
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

    @RequestMapping(value = "/activity/list", method = RequestMethod.GET)
    @ResponseBody
    public Result activityList(PartyMembersActivity partyMembersActivity,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<PartyMembersActivity> pageInfo = iPartyMembersActivityService
                .selectByFilterAndPage(partyMembersActivity, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/activity/join", method = RequestMethod.GET)
    @ResponseBody
    public Result activityJoin(@RequestParam(value = "id") Integer id) {
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
        return ResponseUtil.success(partyMembersBusiness);
    }

}
