package com.topie.huaifang.core.service;

import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.core.dto.CommonQueryDto;
import com.topie.huaifang.database.core.model.CommonQuery;
import com.github.pagehelper.PageInfo;

import java.io.IOException;
import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
public interface ICommonQueryService extends IService<CommonQuery> {

    PageInfo<CommonQuery> selectByFilterAndPage(CommonQuery commonQuery, int pageNum, int pageSize);

    List<CommonQuery> selectByFilter(CommonQuery commonQuery);

    void export(CommonQueryDto commonQueryDto, String path) throws IOException;

}
