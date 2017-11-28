package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IPersonInfoLiveService;
import com.topie.huaifang.database.core.model.PersonInfoLive;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class PersonInfoLiveServiceImpl extends BaseService<PersonInfoLive> implements IPersonInfoLiveService {

    @Override
    public PageInfo<PersonInfoLive> selectByFilterAndPage(PersonInfoLive personInfoLive, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PersonInfoLive> list = selectByFilter(personInfoLive);
        return new PageInfo<>(list);
    }

    @Override
    public List<PersonInfoLive> selectByFilter(PersonInfoLive personInfoLive) {
        Example example = new Example(PersonInfoLive.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(personInfoLive.getlIdentifyNumber()))
            criteria.andEqualTo("lIdentifyNumber", personInfoLive.getlIdentifyNumber());
        if (StringUtils.isNotEmpty(personInfoLive.getlName())) criteria.andEqualTo("lName", personInfoLive.getlName());
        return getMapper().selectByExample(example);
    }

    @Override
    public PersonInfoLive selectByPersonId(Integer lId) {
        PersonInfoLive personInfoLive = new PersonInfoLive();
        personInfoLive.setlPersonId(lId);
        List<PersonInfoLive> list = getMapper().select(personInfoLive);
        if (list.size() > 0) return list.get(0);
        return null;
    }

}
