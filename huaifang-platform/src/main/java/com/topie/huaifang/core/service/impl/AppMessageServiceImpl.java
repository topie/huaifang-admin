package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IAppMessageService;
import com.topie.huaifang.core.service.IAppUserService;
import com.topie.huaifang.database.core.dao.AppMessageMapper;
import com.topie.huaifang.database.core.model.AppMessage;
import com.topie.huaifang.database.core.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class AppMessageServiceImpl extends BaseService<AppMessage> implements IAppMessageService {

    @Autowired
    private IAppUserService iAppUserService;

    @Autowired
    private AppMessageMapper appMessageMapper;

    @Override
    public PageInfo<AppMessage> selectByFilterAndPage(AppMessage appMessage, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AppMessage> list = selectByFilter(appMessage);
        return new PageInfo<>(list);
    }

    @Override
    public List<AppMessage> selectByFilter(AppMessage appMessage) {
        Example example = new Example(AppMessage.class);
        Example.Criteria criteria = example.createCriteria();
        if (appMessage.getToUserId() != null) criteria.andEqualTo("toUserId", appMessage.getToUserId());
        if (appMessage.getCreateTime() != null)
            criteria.andGreaterThanOrEqualTo("createTime", appMessage.getCreateTime());
        return getMapper().selectByExample(example);
    }

    @Override
    public void sendSystemAppMessage(Integer toUserId, String icon, String title, String content) {
        AppMessage appMessage = new AppMessage();
        appMessage.setType(0);
        appMessage.setFromUserId(0);
        appMessage.setToUserId(toUserId);
        appMessage.setCreateTime(new Date());
        appMessage.setEventTime(new Date());
        appMessage.setContent(content);
        appMessage.setTitle(title);
        appMessage.setIcon(icon);
        appMessage.setIsRead(0);
        saveNotNull(appMessage);
    }

    @Override
    public void sentUserAppMessage(Integer fromUserId, Integer toUserId, String title) {
        AppMessage a = new AppMessage();
        a.setFromUserId(fromUserId);
        AppUser appUser = iAppUserService.selectByKey(fromUserId);
        if (appUser != null) {
            a.setToUserId(toUserId);
            a = appMessageMapper.selectOne(a);
            if (a != null) {
                a.setFromUserName(appUser.getNickname());
                a.setIsRead(0);
                a.setEventTime(new Date());
                a.setTitle(title);
                updateNotNull(a);
            } else {
                a = new AppMessage();
                a.setFromUserName(appUser.getNickname());
                a.setType(1);
                a.setFromUserId(fromUserId);
                a.setIcon(appUser.getHeadImage());
                a.setToUserId(toUserId);
                a.setIsRead(0);
                a.setTitle(title);
                a.setCreateTime(new Date());
                a.setEventTime(new Date());
                saveNotNull(a);
            }
        }
    }

}
