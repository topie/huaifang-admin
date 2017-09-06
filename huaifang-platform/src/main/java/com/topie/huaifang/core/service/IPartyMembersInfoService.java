package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.PartyMembersInfo;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IPartyMembersInfoService extends IService<PartyMembersInfo> {

    PageInfo<PartyMembersInfo> selectByFilterAndPage(PartyMembersInfo partyMembersInfo, int pageNum, int pageSize);

    List<PartyMembersInfo> selectByFilter(PartyMembersInfo partyMembersInfo);
}
