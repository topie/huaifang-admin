package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IAppMessageService;
import com.topie.huaifang.database.core.model.AppMessage;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AppMessageServiceImpl extends BaseService<AppMessage> implements IAppMessageService {

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
        if (appMessage.getFromUserId() != null) criteria.andEqualTo("fromUserId", appMessage.getFromUserId());
        if (appMessage.getToUserId() != null) criteria.andEqualTo("toUserId", appMessage.getToUserId());
        if (appMessage.getCreateTime() != null)
            criteria.andGreaterThanOrEqualTo("createTime", appMessage.getCreateTime());
        return getMapper().selectByExample(example);
    }

}
