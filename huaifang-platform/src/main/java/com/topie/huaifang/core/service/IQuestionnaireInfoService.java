package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.QuestionnaireInfo;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IQuestionnaireInfoService extends IService<QuestionnaireInfo> {

    PageInfo<QuestionnaireInfo> selectByFilterAndPage(QuestionnaireInfo questionnaireInfo, int pageNum, int pageSize);

    List<QuestionnaireInfo> selectByFilter(QuestionnaireInfo questionnaireInfo);
}
