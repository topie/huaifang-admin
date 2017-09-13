package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IRepairReportService;
import com.topie.huaifang.database.core.model.RepairReport;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class RepairReportServiceImpl extends BaseService<RepairReport> implements IRepairReportService {

    @Override
    public PageInfo<RepairReport> selectByFilterAndPage(RepairReport repairReport, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<RepairReport> list = selectByFilter(repairReport);
        return new PageInfo<>(list);
    }

    @Override
    public List<RepairReport> selectByFilter(RepairReport repairReport) {
        Example example = new Example(RepairReport.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(repairReport.getContactPerson()))
            criteria.andLike("contactPerson", "%" + repairReport.getContactPerson() + "%");
        if (StringUtils.isNotEmpty(repairReport.getContactPhone()))
            criteria.andLike("contactPhone", "%" + repairReport.getContactPhone() + "%");
        return getMapper().selectByExample(example);
    }

}
