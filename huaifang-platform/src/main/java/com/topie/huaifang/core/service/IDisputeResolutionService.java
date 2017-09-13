package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.DisputeResolution;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IDisputeResolutionService extends IService<DisputeResolution> {

    PageInfo<DisputeResolution> selectByFilterAndPage(DisputeResolution disputeResolution, int pageNum, int pageSize);

    List<DisputeResolution> selectByFilter(DisputeResolution disputeResolution);
}
