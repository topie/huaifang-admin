package com.topie.huaifang.core.api;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.tools.plugins.FormItem;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.common.utils.TreeNode;
import com.topie.huaifang.core.service.ICommonQueryService;
import com.topie.huaifang.core.service.IPartyMembersNodeService;
import com.topie.huaifang.database.core.model.PartyMembersNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/core/partyMembersNode")
public class PartyMembersNodeController {

    @Autowired
    private IPartyMembersNodeService iPartyMembersNodeService;

    @Autowired
    private ICommonQueryService iCommonQueryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(PartyMembersNode partyMembersNode,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<PartyMembersNode> pageInfo = iPartyMembersNodeService
                .selectByFilterAndPage(partyMembersNode, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/formItems", method = RequestMethod.GET)
    @ResponseBody
    public Result formItems() {
        List<FormItem> list = iCommonQueryService.selectFormItemsByTable("d_party_members_node");
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(PartyMembersNode partyMembersNode) {
        if (partyMembersNode.getPid() == null) partyMembersNode.setPid(0);
        int result = iPartyMembersNodeService.saveNotNull(partyMembersNode);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(PartyMembersNode partyMembersNode) {
        if (partyMembersNode.getPid() == null) partyMembersNode.setPid(0);
        iPartyMembersNodeService.updateNotNull(partyMembersNode);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result load(@PathVariable(value = "id") Integer id) {
        PartyMembersNode partyMembersNode = iPartyMembersNodeService.selectByKey(id);
        return ResponseUtil.success(partyMembersNode);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iPartyMembersNodeService.delete(id);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/treeNodes", method = RequestMethod.POST)
    @ResponseBody
    public Object treeNodes(PartyMembersNode partyMembersNode) {
        List<TreeNode> nodes = new ArrayList<>();
        List<PartyMembersNode> list = iPartyMembersNodeService.selectByFilter(partyMembersNode);
        for (PartyMembersNode nodeInfo : list) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(nodeInfo.getId());
            treeNode.setpId(nodeInfo.getPid());
            treeNode.setName(nodeInfo.getName());
            nodes.add(treeNode);
        }
        return nodes;
    }

}
