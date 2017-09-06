package com.topie.huaifang.core.api;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.tools.plugins.FormItem;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.ICommonQueryService;
import com.topie.huaifang.core.service.IPartyMembersBusinessService;
import com.topie.huaifang.database.core.model.PartyMembersBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/core/partyMembersBusiness")
public class PartyMembersBusinessController {

    @Autowired
    private IPartyMembersBusinessService iPartyMembersBusinessService;

    @Autowired
    private ICommonQueryService iCommonQueryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(PartyMembersBusiness partyMembersBusiness,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<PartyMembersBusiness> pageInfo = iPartyMembersBusinessService
                .selectByFilterAndPage(partyMembersBusiness, pageNum, pageSize);
        for (PartyMembersBusiness membersBusiness : pageInfo.getList()) {
            membersBusiness.setContent(null);
        }
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/formItems", method = RequestMethod.GET)
    @ResponseBody
    public Result formItems() {
        List<FormItem> list = iCommonQueryService.selectFormItemsByTable("d_party_members_business");
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(PartyMembersBusiness partyMembersBusiness) {
        int result = iPartyMembersBusinessService.saveNotNull(partyMembersBusiness);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(PartyMembersBusiness partyMembersBusiness) {
        iPartyMembersBusinessService.updateNotNull(partyMembersBusiness);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result load(@PathVariable(value = "id") Integer id) {
        PartyMembersBusiness partyMembersBusiness = iPartyMembersBusinessService.selectByKey(id);
        return ResponseUtil.success(partyMembersBusiness);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iPartyMembersBusinessService.delete(id);
        return ResponseUtil.success();
    }

}
