package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.PartyMembersActivity;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IPartyMembersActivityService extends IService<PartyMembersActivity> {

    PageInfo<PartyMembersActivity> selectByFilterAndPage(PartyMembersActivity partyMembersActivity, int pageNum,
            int pageSize);

    List<PartyMembersActivity> selectByFilter(PartyMembersActivity partyMembersActivity);
}
