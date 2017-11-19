package com.topie.huaifang.core.api;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.tools.plugins.FormItem;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.dto.TagUserDTO;
import com.topie.huaifang.core.service.ICommonQueryService;
import com.topie.huaifang.core.service.ITagService;
import com.topie.huaifang.database.core.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/core/tag")
public class TagController {

    @Autowired
    private ITagService iTagService;

    @Autowired
    private ICommonQueryService iCommonQueryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(Tag tag, @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<Tag> pageInfo = iTagService.selectByFilterAndPage(tag, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/formItems", method = RequestMethod.GET)
    @ResponseBody
    public Result formItems() {
        List<FormItem> list = iCommonQueryService.selectFormItemsByTable("d_advice_box");
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(Tag tag) {
        int result = iTagService.saveNotNull(tag);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(Tag tag) {
        iTagService.updateNotNull(tag);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result load(@PathVariable(value = "id") Integer id) {
        Tag tag = iTagService.selectByKey(id);
        return ResponseUtil.success(tag);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iTagService.delete(id);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public Result hasRoleUserList(@RequestParam("tagId") Integer tagId,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        if (tagId == null) {
            return ResponseUtil.error("标签id不能为空");
        }
        PageInfo<TagUserDTO> pageInfo = iTagService.selectAppUsersByPage(tagId, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/selectUser", method = RequestMethod.GET)
    @ResponseBody
    public Result selectUser(@RequestParam(value = "tagId") Integer tagId,
            @RequestParam(value = "userId") Integer userId) {
        iTagService.insertUserTag(userId, tagId);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/cancelUser", method = RequestMethod.GET)
    @ResponseBody
    public Result cancelUser(@RequestParam(value = "tagId") Integer tagId,
            @RequestParam(value = "userId") Integer userId) {
        iTagService.deleteUserTag(userId,tagId);
        return ResponseUtil.success();
    }

}
