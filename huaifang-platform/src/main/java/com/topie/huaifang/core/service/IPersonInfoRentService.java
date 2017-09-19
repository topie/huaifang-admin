package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.PersonInfoRent;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IPersonInfoRentService extends IService<PersonInfoRent> {

    PageInfo<PersonInfoRent> selectByFilterAndPage(PersonInfoRent personInfoRent, int pageNum, int pageSize);

    List<PersonInfoRent> selectByFilter(PersonInfoRent personInfoRent);
}
