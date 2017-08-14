package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.PersonInfo;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IPersonInfoService extends IService<PersonInfo> {

    PageInfo<PersonInfo> selectByFilterAndPage(PersonInfo personInfo, int pageNum, int pageSize);

    List<PersonInfo> selectByFilter(PersonInfo personInfo);
}
