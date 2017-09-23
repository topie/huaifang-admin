package com.topie.huaifang.database.core.dao;

import com.topie.huaifang.database.core.model.AppUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AppUserMapper extends Mapper<AppUser> {

    List<AppUser> selectAppUserFriends(@Param("userId") Integer userId);

    int insertToAddFriend(@Param("userId") Integer userId, @Param("addUserId") Integer addUserId);
}
