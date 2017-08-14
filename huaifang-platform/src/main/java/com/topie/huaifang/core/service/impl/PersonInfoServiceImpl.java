package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IPersonInfoService;
import com.topie.huaifang.database.core.model.PersonInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class PersonInfoServiceImpl extends BaseService<PersonInfo> implements IPersonInfoService {

    @Override
    public PageInfo<PersonInfo> selectByFilterAndPage(PersonInfo personInfo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PersonInfo> list = selectByFilter(personInfo);
        return new PageInfo<>(list);
    }

    @Override
    public List<PersonInfo> selectByFilter(PersonInfo personInfo) {
        Example example = new Example(PersonInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(personInfo.getIdentifyNumber()))
            criteria.andEqualTo("identifyNumber", personInfo.getIdentifyNumber());
        if (StringUtils.isNotEmpty(personInfo.getName()))
            criteria.andEqualTo("name", personInfo.getName());
        if (personInfo.getHouseNodeId() != null) criteria.andEqualTo("houseNodeId", personInfo.getHouseNodeId());
        return getMapper().selectByExample(example);
    }

}
