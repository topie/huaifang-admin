package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.QuestionnaireResult;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IQuestionnaireResultService extends IService<QuestionnaireResult> {

    PageInfo<QuestionnaireResult> selectByFilterAndPage(QuestionnaireResult questionnaireResult, int pageNum,
            int pageSize);

    List<QuestionnaireResult> selectByFilter(QuestionnaireResult questionnaireResult);
}
