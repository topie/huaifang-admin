package com.topie.huaifang.core.api;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.common.utils.TreeNode;
import com.topie.huaifang.core.service.IHouseNodeService;
import com.topie.huaifang.database.core.model.HouseNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/core/houseNode")
public class HouseNodeController {

    @Autowired
    private IHouseNodeService iHouseNodeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(HouseNode houseNode,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<HouseNode> pageInfo = iHouseNodeService.selectByFilterAndPage(houseNode, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(HouseNode houseNode) {
        if (houseNode.getPid() == null) houseNode.setPid(0);
        int result = iHouseNodeService.saveNotNull(houseNode);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(HouseNode houseNode) {
        if (houseNode.getPid() == null) houseNode.setPid(0);
        iHouseNodeService.updateNotNull(houseNode);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result load(@PathVariable(value = "id") Integer id) {
        HouseNode houseNode = iHouseNodeService.selectByKey(id);
        return ResponseUtil.success(houseNode);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iHouseNodeService.delete(id);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/treeNodes", method = RequestMethod.POST)
    @ResponseBody
    public Object treeNodes(HouseNode houseNode) {
        List<TreeNode> nodes = new ArrayList<>();
        List<HouseNode> list = iHouseNodeService.selectByFilter(houseNode);
        for (HouseNode nodeInfo : list) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(nodeInfo.getId());
            treeNode.setpId(nodeInfo.getPid());
            treeNode.setName(nodeInfo.getName());
            nodes.add(treeNode);
        }
        return nodes;
    }

}
