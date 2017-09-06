package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IPartyMembersBusinessService;
import com.topie.huaifang.database.core.model.PartyMembersBusiness;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class PartyMembersBusinessServiceImpl extends BaseService<PartyMembersBusiness>
        implements IPartyMembersBusinessService {

    @Override
    public PageInfo<PartyMembersBusiness> selectByFilterAndPage(PartyMembersBusiness partyMembersBusiness, int pageNum,
            int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PartyMembersBusiness> list = selectByFilter(partyMembersBusiness);
        return new PageInfo<>(list);
    }

    @Override
    public List<PartyMembersBusiness> selectByFilter(PartyMembersBusiness partyMembersBusiness) {
        Example example = new Example(PartyMembersBusiness.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(partyMembersBusiness.getTitle()))
            criteria.andLike("title", "%" + partyMembersBusiness.getTitle() + "%");
        if (partyMembersBusiness.getType() != null) criteria.andEqualTo("type", partyMembersBusiness.getType());
        return getMapper().selectByExample(example);
    }

}
