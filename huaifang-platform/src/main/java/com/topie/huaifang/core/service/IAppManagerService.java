package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.AppManager;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IAppManagerService extends IService<AppManager> {

    PageInfo<AppManager> selectByFilterAndPage(AppManager appManager, int pageNum, int pageSize);

    List<AppManager> selectByFilter(AppManager appManager);
}
