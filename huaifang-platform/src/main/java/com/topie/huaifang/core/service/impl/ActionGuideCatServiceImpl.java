package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IActionGuideCatService;
import com.topie.huaifang.database.core.model.ActionGuideCat;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ActionGuideCatServiceImpl extends BaseService<ActionGuideCat> implements IActionGuideCatService {

    @Override
    public PageInfo<ActionGuideCat> selectByFilterAndPage(ActionGuideCat actionGuideCat, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ActionGuideCat> list = selectByFilter(actionGuideCat);
        return new PageInfo<>(list);
    }

    @Override
    public List<ActionGuideCat> selectByFilter(ActionGuideCat actionGuideCat) {
        Example example = new Example(ActionGuideCat.class);
        Example.Criteria criteria = example.createCriteria();
        if (actionGuideCat != null) {
            if (StringUtils.isNotEmpty(actionGuideCat.getTitle()))
                criteria.andLike("title", "%" + actionGuideCat.getTitle() + "%");
            if (StringUtils.isNotEmpty(actionGuideCat.getName()))
                criteria.andLike("name", "%" + actionGuideCat.getName() + "%");
        }
        return getMapper().selectByExample(example);
    }

}
