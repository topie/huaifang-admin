package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.AppUser;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IAppUserService extends IService<AppUser> {

    PageInfo<AppUser> selectByFilterAndPage(AppUser appUser, int pageNum, int pageSize);

    List<AppUser> selectByFilter(AppUser appUser);

    AppUser selectByPlatformId(Integer currentUserId);

    PageInfo<AppUser> selectAppUserFriends(Integer userId, Integer pageNum, Integer pageSize);

    void insertToAddFriend(Integer userId, Integer id);

}
