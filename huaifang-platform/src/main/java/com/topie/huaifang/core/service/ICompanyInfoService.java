package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.CompanyInfo;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface ICompanyInfoService extends IService<CompanyInfo> {

    PageInfo<CompanyInfo> selectByFilterAndPage(CompanyInfo companyInfo, int pageNum, int pageSize);

    List<CompanyInfo> selectByFilter(CompanyInfo companyInfo);
}
