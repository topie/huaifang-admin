package com.topie.huaifang.database.core.dao;

import com.topie.huaifang.database.core.model.QuestionnaireResult;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

public interface QuestionnaireResultMapper extends Mapper<QuestionnaireResult> {

    Integer countDistinctUser(Map arg);
}
