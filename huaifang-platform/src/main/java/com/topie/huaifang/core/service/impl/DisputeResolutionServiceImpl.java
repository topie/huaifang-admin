package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IDisputeResolutionService;
import com.topie.huaifang.database.core.model.DisputeResolution;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class DisputeResolutionServiceImpl extends BaseService<DisputeResolution> implements IDisputeResolutionService {

    @Override
    public PageInfo<DisputeResolution> selectByFilterAndPage(DisputeResolution disputeResolution, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<DisputeResolution> list = selectByFilter(disputeResolution);
        return new PageInfo<>(list);
    }

    @Override
    public List<DisputeResolution> selectByFilter(DisputeResolution disputeResolution) {
        Example example = new Example(DisputeResolution.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(disputeResolution.getContactPerson()))
            criteria.andLike("contactPerson", "%" + disputeResolution.getContactPerson() + "%");
        if (StringUtils.isNotEmpty(disputeResolution.getContactPhone()))
            criteria.andLike("contactPhone", "%" + disputeResolution.getContactPhone() + "%");
        return getMapper().selectByExample(example);
    }

}
