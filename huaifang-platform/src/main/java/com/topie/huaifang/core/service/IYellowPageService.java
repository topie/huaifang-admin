package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.YellowPage;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IYellowPageService extends IService<YellowPage> {

    PageInfo<YellowPage> selectByFilterAndPage(YellowPage yellowPage, int pageNum, int pageSize);

    List<YellowPage> selectByFilter(YellowPage yellowPage);
}
