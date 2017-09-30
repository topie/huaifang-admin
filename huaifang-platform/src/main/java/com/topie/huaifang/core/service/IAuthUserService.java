package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.AuthUser;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IAuthUserService extends IService<AuthUser> {

    PageInfo<AuthUser> selectByFilterAndPage(AuthUser authUser, int pageNum, int pageSize);

    List<AuthUser> selectByFilter(AuthUser authUser);
}
