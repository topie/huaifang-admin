package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.ICompanyInfoService;
import com.topie.huaifang.database.core.model.CompanyInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CompanyInfoServiceImpl extends BaseService<CompanyInfo> implements ICompanyInfoService {

    @Override
    public PageInfo<CompanyInfo> selectByFilterAndPage(CompanyInfo companyInfo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CompanyInfo> list = selectByFilter(companyInfo);
        return new PageInfo<>(list);
    }

    @Override
    public List<CompanyInfo> selectByFilter(CompanyInfo companyInfo) {
        Example example = new Example(CompanyInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(companyInfo.getCompanyName()))
            criteria.andLike("companyName", "%" + companyInfo.getCompanyName() + "%");
        if (StringUtils.isNotEmpty(companyInfo.getCompanyCode()))
            criteria.andEqualTo("companyCode", companyInfo.getCompanyCode());
        return getMapper().selectByExample(example);
    }

}
