package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IAppTimeLineService;
import com.topie.huaifang.database.core.model.AppTimeLine;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AppTimeLineServiceImpl extends BaseService<AppTimeLine> implements IAppTimeLineService {

    @Override
    public PageInfo<AppTimeLine> selectByFilterAndPage(AppTimeLine appTimeLine, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AppTimeLine> list = selectByFilter(appTimeLine);
        return new PageInfo<>(list);
    }

    @Override
    public List<AppTimeLine> selectByFilter(AppTimeLine appTimeLine) {
        Example example = new Example(AppTimeLine.class);
        Example.Criteria criteria = example.createCriteria();
        if (appTimeLine.getAddUserId() != null) criteria.andEqualTo("addUserId", appTimeLine.getAddUserId());
        if (appTimeLine.getPublishTime() != null)
            criteria.andLessThanOrEqualTo("publishTime", appTimeLine.getPublishTime());
        example.setOrderByClause(" publish_time desc");
        return getMapper().selectByExample(example);
    }

}
