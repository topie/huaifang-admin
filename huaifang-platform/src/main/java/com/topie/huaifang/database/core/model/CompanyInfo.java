package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "d_company_info")
public class CompanyInfo {
    /**
     * ID:hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 企业名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 统一社会信用代码
     */
    @Column(name = "company_code")
    private String companyCode;

    /**
     * 营业执照:image
     */
    private String yingyezhizhao;

    /**
     * 企业类型:select:[有限责任公司]
     */
    @Column(name = "company_type")
    private String companyType;

    /**
     * 法人代表
     */
    private String farendaibiao;

    /**
     * 注册资金
     */
    private String zhucezijin;

    /**
     * 注册时间:date
     */
    @Column(name = "reg_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date regDate;

    /**
     * 注册地址:textarea
     */
    private String address;

    /**
     * 注册地址:textarea
     */
    private String gudong;

    /**
     * 股东人数:skip
     */
    @Column(name = "gudong_count")
    private Integer gudongCount;

    /**
     * 获取ID:hidden
     *
     * @return id - ID:hidden
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID:hidden
     *
     * @param id ID:hidden
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取企业名称
     *
     * @return company_name - 企业名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置企业名称
     *
     * @param companyName 企业名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取统一社会信用代码
     *
     * @return company_code - 统一社会信用代码
     */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param companyCode 统一社会信用代码
     */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * 获取营业执照:image
     *
     * @return yingyezhizhao - 营业执照:image
     */
    public String getYingyezhizhao() {
        return yingyezhizhao;
    }

    /**
     * 设置营业执照:image
     *
     * @param yingyezhizhao 营业执照:image
     */
    public void setYingyezhizhao(String yingyezhizhao) {
        this.yingyezhizhao = yingyezhizhao;
    }

    /**
     * 获取企业类型:select:[有限责任公司]
     *
     * @return company_type - 企业类型:select:[有限责任公司]
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * 设置企业类型:select:[有限责任公司]
     *
     * @param companyType 企业类型:select:[有限责任公司]
     */
    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    /**
     * 获取法人代表
     *
     * @return farendaibiao - 法人代表
     */
    public String getFarendaibiao() {
        return farendaibiao;
    }

    /**
     * 设置法人代表
     *
     * @param farendaibiao 法人代表
     */
    public void setFarendaibiao(String farendaibiao) {
        this.farendaibiao = farendaibiao;
    }

    /**
     * 获取注册资金
     *
     * @return zhucezijin - 注册资金
     */
    public String getZhucezijin() {
        return zhucezijin;
    }

    /**
     * 设置注册资金
     *
     * @param zhucezijin 注册资金
     */
    public void setZhucezijin(String zhucezijin) {
        this.zhucezijin = zhucezijin;
    }

    /**
     * 获取注册时间:date
     *
     * @return reg_date - 注册时间:date
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    public Date getRegDate() {
        return regDate;
    }

    /**
     * 设置注册时间:date
     *
     * @param regDate 注册时间:date
     */
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    /**
     * 获取注册地址:textarea
     *
     * @return address - 注册地址:textarea
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置注册地址:textarea
     *
     * @param address 注册地址:textarea
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取注册地址:textarea
     *
     * @return gudong - 注册地址:textarea
     */
    public String getGudong() {
        return gudong;
    }

    /**
     * 设置注册地址:textarea
     *
     * @param gudong 注册地址:textarea
     */
    public void setGudong(String gudong) {
        this.gudong = gudong;
    }

    /**
     * 获取股东人数:skip
     *
     * @return gudong_count - 股东人数:skip
     */
    public Integer getGudongCount() {
        return gudongCount;
    }

    /**
     * 设置股东人数:skip
     *
     * @param gudongCount 股东人数:skip
     */
    public void setGudongCount(Integer gudongCount) {
        this.gudongCount = gudongCount;
    }
}
