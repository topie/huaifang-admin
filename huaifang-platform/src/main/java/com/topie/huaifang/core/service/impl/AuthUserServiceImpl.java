package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IAuthUserService;
import com.topie.huaifang.database.core.model.AuthUser;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AuthUserServiceImpl extends BaseService<AuthUser> implements IAuthUserService {

    @Override
    public PageInfo<AuthUser> selectByFilterAndPage(AuthUser authUser, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AuthUser> list = selectByFilter(authUser);
        return new PageInfo<>(list);
    }

    @Override
    public List<AuthUser> selectByFilter(AuthUser authUser) {
        Example example = new Example(AuthUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (authUser.getHouseId() != null) criteria.andEqualTo("personId", authUser.getPersonId());
        if (authUser.getHouseId() != null) criteria.andEqualTo("houseId", authUser.getHouseId());
        if (authUser.getCompanyId() != null) criteria.andEqualTo("companyId", authUser.getCompanyId());
        if (authUser.getPartyMemberId() != null) criteria.andEqualTo("partyMemberId", authUser.getPartyMemberId());
        return getMapper().selectByExample(example);
    }

}
