package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IQuestionnaireOptionService;
import com.topie.huaifang.database.core.model.QuestionnaireOption;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class QuestionnaireOptionServiceImpl extends BaseService<QuestionnaireOption>
        implements IQuestionnaireOptionService {

    @Override
    public PageInfo<QuestionnaireOption> selectByFilterAndPage(QuestionnaireOption adviceBox, int pageNum,
            int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<QuestionnaireOption> list = selectByFilter(adviceBox);
        return new PageInfo<>(list);
    }

    @Override
    public List<QuestionnaireOption> selectByFilter(QuestionnaireOption adviceBox) {
        Example example = new Example(QuestionnaireOption.class);
        Example.Criteria criteria = example.createCriteria();
        if (adviceBox.getItemId() != null) criteria.andEqualTo("itemId", adviceBox.getItemId());
        example.setOrderByClause(" option_index asc");
        return getMapper().selectByExample(example);
    }

}
