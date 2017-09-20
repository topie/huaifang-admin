package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.AppTimeLine;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IAppTimeLineService extends IService<AppTimeLine> {

    PageInfo<AppTimeLine> selectByFilterAndPage(AppTimeLine appTimeLine, int pageNum, int pageSize);

    List<AppTimeLine> selectByFilter(AppTimeLine appTimeLine);
}
