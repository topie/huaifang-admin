package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IAppUserMessageService;
import com.topie.huaifang.database.core.model.AppUserMessage;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserMessageServiceImpl extends BaseService<AppUserMessage> implements IAppUserMessageService {

    @Override
    public PageInfo<AppUserMessage> selectByFilterAndPage(AppUserMessage appUserMessage, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AppUserMessage> list = selectByFilter(appUserMessage);
        return new PageInfo<>(list);
    }

    @Override
    public List<AppUserMessage> selectByFilter(AppUserMessage appUserMessage) {
        Example example = new Example(AppUserMessage.class);
        Example.Criteria criteria = example.createCriteria();
        List<Integer> userIds = new ArrayList<>();
        if (appUserMessage.getFromUserId() != null && appUserMessage.getToUserId() != null) {
            userIds.add(appUserMessage.getFromUserId());
            userIds.add(appUserMessage.getToUserId());
            criteria.andIn("fromUserId", userIds);
            criteria.andIn("toUserId", userIds);
        }
        if (appUserMessage.getSendTime() != null)
            criteria.andGreaterThanOrEqualTo("sendTime", appUserMessage.getSendTime());
        return getMapper().selectByExample(example);
    }

}
