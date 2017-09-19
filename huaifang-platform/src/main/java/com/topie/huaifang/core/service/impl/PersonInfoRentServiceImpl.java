package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IPersonInfoRentService;
import com.topie.huaifang.database.core.model.PersonInfoRent;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class PersonInfoRentServiceImpl extends BaseService<PersonInfoRent> implements IPersonInfoRentService {

    @Override
    public PageInfo<PersonInfoRent> selectByFilterAndPage(PersonInfoRent personInfoRent, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PersonInfoRent> list = selectByFilter(personInfoRent);
        return new PageInfo<>(list);
    }

    @Override
    public List<PersonInfoRent> selectByFilter(PersonInfoRent personInfoRent) {
        Example example = new Example(PersonInfoRent.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(personInfoRent.getIdentifyNumber()))
            criteria.andEqualTo("identifyNumber", personInfoRent.getIdentifyNumber());
        if (StringUtils.isNotEmpty(personInfoRent.getName()))
            criteria.andEqualTo("name", personInfoRent.getName());
        return getMapper().selectByExample(example);
    }

}
