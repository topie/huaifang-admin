package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IRepairReportProcessService;
import com.topie.huaifang.database.core.model.RepairReportProcess;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class RepairReportProcessServiceImpl extends BaseService<RepairReportProcess>
        implements IRepairReportProcessService {

    @Override
    public PageInfo<RepairReportProcess> selectByFilterAndPage(RepairReportProcess repairReportProcess, int pageNum,
            int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<RepairReportProcess> list = selectByFilter(repairReportProcess);
        return new PageInfo<>(list);
    }

    @Override
    public List<RepairReportProcess> selectByFilter(RepairReportProcess repairReportProcess) {
        Example example = new Example(RepairReportProcess.class);
        Example.Criteria criteria = example.createCriteria();
        if (repairReportProcess.getContactUserId() != null)
            criteria.andEqualTo("contactUserId", repairReportProcess.getContactUserId());
        if (StringUtils.isNotEmpty(repairReportProcess.getContactPerson()))
            criteria.andLike("contactPerson", "%" + repairReportProcess.getContactPerson() + "%");
        if (StringUtils.isNotEmpty(repairReportProcess.getContactPhone()))
            criteria.andLike("contactPhone", "%" + repairReportProcess.getContactPhone() + "%");
        example.setOrderByClause("process_time desc");
        return getMapper().selectByExample(example);
    }

}
