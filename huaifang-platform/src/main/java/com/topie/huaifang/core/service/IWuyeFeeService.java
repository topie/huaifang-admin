package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.WuyeFee;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IWuyeFeeService extends IService<WuyeFee> {

    PageInfo<WuyeFee> selectByFilterAndPage(WuyeFee wuyeFee, int pageNum, int pageSize);

    List<WuyeFee> selectByFilter(WuyeFee wuyeFee);
}
