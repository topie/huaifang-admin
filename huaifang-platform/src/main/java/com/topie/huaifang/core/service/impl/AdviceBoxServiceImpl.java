package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IAdviceBoxService;
import com.topie.huaifang.database.core.model.AdviceBox;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AdviceBoxServiceImpl extends BaseService<AdviceBox> implements IAdviceBoxService {

    @Override
    public PageInfo<AdviceBox> selectByFilterAndPage(AdviceBox adviceBox, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AdviceBox> list = selectByFilter(adviceBox);
        return new PageInfo<>(list);
    }

    @Override
    public List<AdviceBox> selectByFilter(AdviceBox adviceBox) {
        Example example = new Example(AdviceBox.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(adviceBox.getContactPerson()))
            criteria.andLike("contactPerson", "%" + adviceBox.getContactPerson() + "%");
        if (StringUtils.isNotEmpty(adviceBox.getContactPhone()))
            criteria.andLike("contactPhone", "%" + adviceBox.getContactPhone() + "%");
        return getMapper().selectByExample(example);
    }

}
