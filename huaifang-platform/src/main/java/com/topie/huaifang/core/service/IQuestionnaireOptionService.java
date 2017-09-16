package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.QuestionnaireOption;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IQuestionnaireOptionService extends IService<QuestionnaireOption> {

    PageInfo<QuestionnaireOption> selectByFilterAndPage(QuestionnaireOption questionnaireOption, int pageNum,
            int pageSize);

    List<QuestionnaireOption> selectByFilter(QuestionnaireOption questionnaireOption);
}
