package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IAppUserService;
import com.topie.huaifang.database.core.dao.AppUserMapper;
import com.topie.huaifang.database.core.model.AppUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AppUserServiceImpl extends BaseService<AppUser> implements IAppUserService {
    @Autowired
    private AppUserMapper appUserMapper;
    @Override
    public PageInfo<AppUser> selectByFilterAndPage(AppUser appUser, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AppUser> list = selectByFilter(appUser);
        return new PageInfo<>(list);
    }

    @Override
    public List<AppUser> selectByFilter(AppUser appUser) {
        Example example = new Example(AppUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(appUser.getNickname()))
            criteria.andLike("nickname", "%" + appUser.getNickname() + "%");
        if (StringUtils.isNotEmpty(appUser.getRealname()))
            criteria.andLike("realname", "%" + appUser.getRealname() + "%");
        return getMapper().selectByExample(example);
    }

    @Override
    public AppUser selectByPlatformId(Integer currentUserId) {
        AppUser appUser = new AppUser();
        appUser.setPlatformId(currentUserId);
        return getMapper().selectOne(appUser);
    }

    @Override
    public PageInfo<AppUser> selectAppUserFriends(Integer userId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AppUser> list = appUserMapper.selectAppUserFriends(userId);
        return new PageInfo<>(list);
    }

    @Override
    public void insertToAddFriend(Integer userId, Integer addUserId) {
        appUserMapper.insertToAddFriend(userId,addUserId);
    }

}
