package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.MarketLine;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IMarketLineService extends IService<MarketLine> {

    PageInfo<MarketLine> selectByFilterAndPage(MarketLine marketLine, int pageNum, int pageSize);

    List<MarketLine> selectByFilter(MarketLine marketLine);
}
