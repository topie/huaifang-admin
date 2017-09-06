package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.PartyMembersBusiness;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IPartyMembersBusinessService extends IService<PartyMembersBusiness> {

    PageInfo<PartyMembersBusiness> selectByFilterAndPage(PartyMembersBusiness partyMembersBusiness, int pageNum,
            int pageSize);

    List<PartyMembersBusiness> selectByFilter(PartyMembersBusiness partyMembersBusiness);
}
