package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.common.tools.excel.ExcelFileUtil;
import com.topie.huaifang.common.tools.plugins.FormItem;
import com.topie.huaifang.common.utils.CamelUtil;
import com.topie.huaifang.common.utils.Option;
import com.topie.huaifang.core.dto.CommonQueryDto;
import com.topie.huaifang.core.service.ICommonQueryService;
import com.topie.huaifang.core.service.ICommonService;
import com.topie.huaifang.database.core.dao.CommonQueryMapper;
import com.topie.huaifang.database.core.model.CommonQuery;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Service
public class CommonQueryServiceImpl extends BaseService<CommonQuery> implements ICommonQueryService {

    @Autowired
    private ICommonService iCommonService;

    @Autowired
    private CommonQueryMapper commonQueryMapper;

    @Override
    public PageInfo<CommonQuery> selectByFilterAndPage(CommonQuery commonQuery, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CommonQuery> list = selectByFilter(commonQuery);
        return new PageInfo<>(list);
    }

    @Override
    public List<CommonQuery> selectByFilter(CommonQuery commonQuery) {
        Example example = new Example(CommonQuery.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(commonQuery.getTableAlias()))
            criteria.andEqualTo("tableAlias", commonQuery.getTableAlias());
        return getMapper().selectByExample(example);
    }

    @Override
    public void export(CommonQueryDto commonQueryDto, String path) throws IOException {
        CommonQuery c = new CommonQuery();
        c.setTableAlias(commonQueryDto.getTableAlias());
        List<CommonQuery> commonQueries = selectByFilter(c);
        if (CollectionUtils.isNotEmpty(commonQueries)) {
            List<Map> list = iCommonService.selectByCommonTableBySql(commonQueryDto.getSql());
            List<String> headers = new ArrayList();
            List<String> mapHeaders = new ArrayList();
            if (StringUtils.isNotEmpty(commonQueries.get(0).getExportQuery())) {
                String[] exportArr = commonQueries.get(0).getExportQuery().split(",");
                for (String export : exportArr) {
                    String[] exportEle = export.split("::");
                    if (exportEle.length == 2) {
                        headers.add(exportEle[0].trim());
                        mapHeaders.add(exportEle[1].trim());
                    }
                }
            }
            String[] headArr = new String[headers.size()];
            String[] h = headers.toArray(headArr);
            String[] mapHeadArr = new String[mapHeaders.size()];
            String[] m = mapHeaders.toArray(mapHeadArr);
            ExcelFileUtil.exportXlsx(path, list, m, h);
        }

    }

    @Override
    public List<FormItem> selectFormItemsByTable(String table) {
        List<Map> list = commonQueryMapper.selectColumnsByTable(table);
        List<FormItem> items = new ArrayList<>();
        for (Map map : list) {
            String name = (String) map.get("dataColumn");
            String comment = (String) map.get("dataComment");
            FormItem formItem = new FormItem();
            formItem.setName(CamelUtil.underlineToCamel(name));
            String[] cs = comment.split(":");
            formItem.setLabel(cs[0]);
            formItem.setType("text");
            if (cs.length == 2) {
                formItem.setType(cs[1]);
            }
            if (cs.length == 3) {
                formItem.setType(cs[1]);
                List<Option> options = new ArrayList<>();
                String[] arr = cs[2].split("[,\\]\\[]");
                for (String option : arr) {
                    if (StringUtils.isNotEmpty(option)) {
                        options.add(new Option(option, option));
                    }
                }
                formItem.setItems(options);
            }
            items.add(formItem);
        }
        return items;
    }

}
