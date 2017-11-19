package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IJuwuInfoService;
import com.topie.huaifang.database.core.dao.JuwuInfoMapper;
import com.topie.huaifang.database.core.model.JuwuInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class JuwuInfoServiceImpl extends BaseService<JuwuInfo> implements IJuwuInfoService {

    @Autowired
    private JuwuInfoMapper juwuInfoMapper;
    @Override
    public PageInfo<JuwuInfo> selectByFilterAndPage(JuwuInfo juwuInfo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<JuwuInfo> list = selectByFilter(juwuInfo);
        return new PageInfo<>(list);
    }

    @Override
    public List<JuwuInfo> selectByFilter(JuwuInfo juwuInfo) {
        Example example = new Example(JuwuInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(juwuInfo.getTitle())) criteria.andLike("title", "%" + juwuInfo.getTitle() + "%");
        if (StringUtils.isNotEmpty(juwuInfo.getStatus())) criteria.andEqualTo("status", juwuInfo.getStatus());
        return getMapper().selectByExample(example);
    }

    @Override
    public List<JuwuInfo> selectTitles() {
        return juwuInfoMapper.selectTitles();
    }

}
