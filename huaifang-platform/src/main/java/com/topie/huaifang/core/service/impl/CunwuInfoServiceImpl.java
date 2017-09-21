package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.ICunwuInfoService;
import com.topie.huaifang.database.core.dao.CunwuInfoMapper;
import com.topie.huaifang.database.core.model.CunwuInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CunwuInfoServiceImpl extends BaseService<CunwuInfo> implements ICunwuInfoService {

    @Autowired
    private CunwuInfoMapper cunwuInfoMapper;
    @Override
    public PageInfo<CunwuInfo> selectByFilterAndPage(CunwuInfo cunwuInfo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CunwuInfo> list = selectByFilter(cunwuInfo);
        return new PageInfo<>(list);
    }

    @Override
    public List<CunwuInfo> selectByFilter(CunwuInfo cunwuInfo) {
        Example example = new Example(CunwuInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(cunwuInfo.getTitle())) criteria.andLike("title", "%" + cunwuInfo.getTitle() + "%");
        if (StringUtils.isNotEmpty(cunwuInfo.getStatus())) criteria.andEqualTo("status", cunwuInfo.getStatus());
        return getMapper().selectByExample(example);
    }

    @Override
    public List<CunwuInfo> selectTitles() {
        return cunwuInfoMapper.selectTitles();
    }

}
