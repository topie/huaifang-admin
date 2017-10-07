package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.PersonInfoLive;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IPersonInfoLiveService extends IService<PersonInfoLive> {

    PageInfo<PersonInfoLive> selectByFilterAndPage(PersonInfoLive personInfoLive, int pageNum, int pageSize);

    List<PersonInfoLive> selectByFilter(PersonInfoLive personInfoLive);

    PersonInfoLive selectByPersonId(Integer lId);
}
