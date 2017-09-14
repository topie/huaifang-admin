package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IWuyeFeeService;
import com.topie.huaifang.database.core.model.WuyeFee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class WuyeFeeServiceImpl extends BaseService<WuyeFee> implements IWuyeFeeService {

    @Override
    public PageInfo<WuyeFee> selectByFilterAndPage(WuyeFee wuyeFee, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<WuyeFee> list = selectByFilter(wuyeFee);
        return new PageInfo<>(list);
    }

    @Override
    public List<WuyeFee> selectByFilter(WuyeFee wuyeFee) {
        Example example = new Example(WuyeFee.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(wuyeFee.getAccountDate()))
            criteria.andEqualTo("accountDate", wuyeFee.getAccountDate());
        if (StringUtils.isNotEmpty(wuyeFee.getAccount())) criteria.andLike("account", "%" + wuyeFee.getAccount() + "%");
        return getMapper().selectByExample(example);
    }

}
