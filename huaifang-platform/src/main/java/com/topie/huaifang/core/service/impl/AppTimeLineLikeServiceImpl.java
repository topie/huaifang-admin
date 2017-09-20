package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IAppTimeLineLikeService;
import com.topie.huaifang.database.core.model.AppTimeLineLike;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AppTimeLineLikeServiceImpl extends BaseService<AppTimeLineLike> implements IAppTimeLineLikeService {

    @Override
    public PageInfo<AppTimeLineLike> selectByFilterAndPage(AppTimeLineLike appTimeLineLike, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AppTimeLineLike> list = selectByFilter(appTimeLineLike);
        return new PageInfo<>(list);
    }

    @Override
    public List<AppTimeLineLike> selectByFilter(AppTimeLineLike appTimeLineLike) {
        Example example = new Example(AppTimeLineLike.class);
        Example.Criteria criteria = example.createCriteria();
        if (appTimeLineLike.getLineId() != null) criteria.andEqualTo("lineId", appTimeLineLike.getLineId());
        if (appTimeLineLike.getLikeTime() != null) criteria.andGreaterThan("likeTime", appTimeLineLike.getLikeTime());
        example.setOrderByClause(" likeTime asc");
        return getMapper().selectByExample(example);
    }

}
