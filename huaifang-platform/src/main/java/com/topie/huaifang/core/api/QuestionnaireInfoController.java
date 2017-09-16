package com.topie.huaifang.core.api;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.topie.huaifang.common.tools.plugins.FormItem;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.ICommonQueryService;
import com.topie.huaifang.core.service.IQuestionnaireInfoService;
import com.topie.huaifang.database.core.model.QuestionnaireInfo;
import com.topie.huaifang.security.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/core/questionnaireInfo")
public class QuestionnaireInfoController {

    @Autowired
    private IQuestionnaireInfoService iQuestionnaireInfoService;

    @Autowired
    private ICommonQueryService iCommonQueryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(QuestionnaireInfo questionnaireInfo,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<QuestionnaireInfo> pageInfo = iQuestionnaireInfoService
                .selectByFilterAndPage(questionnaireInfo, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/formItems", method = RequestMethod.GET)
    @ResponseBody
    public Result formItems() {
        List<FormItem> list = iCommonQueryService.selectFormItemsByTable("d_questionnaire_info");
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(QuestionnaireInfo questionnaireInfo) {
        if (StringUtil.isEmpty(questionnaireInfo.getAddUser())) {
            questionnaireInfo.setAddUser(SecurityUtil.getCurrentUserName());
        }
        questionnaireInfo.setAddTime(new Date());
        int result = iQuestionnaireInfoService.saveNotNull(questionnaireInfo);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(QuestionnaireInfo questionnaireInfo) {
        if (StringUtil.isEmpty(questionnaireInfo.getAddUser())) {
            questionnaireInfo.setAddUser(SecurityUtil.getCurrentUserName());
        }
        iQuestionnaireInfoService.updateNotNull(questionnaireInfo);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result load(@PathVariable(value = "id") Integer id) {
        QuestionnaireInfo questionnaireInfo = iQuestionnaireInfoService.selectByKey(id);
        return ResponseUtil.success(questionnaireInfo);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iQuestionnaireInfoService.delete(id);
        return ResponseUtil.success();
    }

}
