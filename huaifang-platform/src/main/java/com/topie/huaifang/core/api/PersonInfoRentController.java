package com.topie.huaifang.core.api;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.tools.plugins.FormItem;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.ICommonQueryService;
import com.topie.huaifang.core.service.IPersonInfoRentService;
import com.topie.huaifang.database.core.model.PersonInfoRent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/core/personInfoRent")
public class PersonInfoRentController {

    @Autowired
    private IPersonInfoRentService iPersonInfoRentService;

    @Autowired
    private ICommonQueryService iCommonQueryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(PersonInfoRent personInfoRent,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<PersonInfoRent> pageInfo = iPersonInfoRentService
                .selectByFilterAndPage(personInfoRent, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/formItems", method = RequestMethod.GET)
    @ResponseBody
    public Result formItems() {
        List<FormItem> list = iCommonQueryService.selectFormItemsByTable("d_person_info_rent");
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(PersonInfoRent personInfoRent) {
        int result = iPersonInfoRentService.saveNotNull(personInfoRent);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(PersonInfoRent personInfoRent) {
        iPersonInfoRentService.updateNotNull(personInfoRent);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result load(@PathVariable(value = "id") Integer id) {
        PersonInfoRent personInfoRent = iPersonInfoRentService.selectByKey(id);
        return ResponseUtil.success(personInfoRent);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iPersonInfoRentService.delete(id);
        return ResponseUtil.success();
    }

}
