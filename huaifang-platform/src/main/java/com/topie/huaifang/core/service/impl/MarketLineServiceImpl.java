package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IMarketLineService;
import com.topie.huaifang.database.core.model.MarketLine;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class MarketLineServiceImpl extends BaseService<MarketLine> implements IMarketLineService {

    @Override
    public PageInfo<MarketLine> selectByFilterAndPage(MarketLine marketLine, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<MarketLine> list = selectByFilter(marketLine);
        return new PageInfo<>(list);
    }

    @Override
    public List<MarketLine> selectByFilter(MarketLine marketLine) {
        Example example = new Example(MarketLine.class);
        Example.Criteria criteria = example.createCriteria();
        if (marketLine.getType() != null) criteria.andEqualTo("type", marketLine.getType());
        example.setOrderByClause(" publish_time desc");
        return getMapper().selectByExample(example);
    }

}
