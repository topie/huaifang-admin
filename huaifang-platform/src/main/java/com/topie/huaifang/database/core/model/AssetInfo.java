package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "d_asset_info")
public class AssetInfo {
    /**
     * ID:hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 资产编号
     */
    @Column(name = "asset_no")
    private String assetNo;

    /**
     * 资产类型:select:[打印机,个人电脑,其他]
     */
    @Column(name = "asset_type")
    private String assetType;

    /**
     * 资产名称
     */
    @Column(name = "asset_name")
    private String assetName;

    /**
     * 规格型号
     */
    private String guigexinghao;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 原值
     */
    private String yuanzhi;

    /**
     * 残值
     */
    private String canzhi;

    /**
     * 价值
     */
    private String jiazhi;

    /**
     * 取得方式:select:[自购,政府采购]
     */
    @Column(name = "get_way")
    private String getWay;

    /**
     * 获得日期:date
     */
    @Column(name = "get_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date getDate;

    /**
     * 使用状况:select:[在用,不在用]
     */
    @Column(name = "use_situation")
    private String useSituation;

    /**
     * 财务入账日期:date
     */
    @Column(name = "caiwuruzhang_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date caiwuruzhangDate;

    /**
     * 使用方式:select:[自用,公用]
     */
    @Column(name = "use_type")
    private String useType;

    /**
     * 使用人
     */
    @Column(name = "use_person")
    private String usePerson;

    /**
     * 使用部门
     */
    @Column(name = "use_department")
    private String useDepartment;

    /**
     * 管理部门
     */
    @Column(name = "manager_department")
    private String managerDepartment;

    /**
     * 备注:textarea
     */
    private String memo;

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
     * 获取资产编号
     *
     * @return asset_no - 资产编号
     */
    public String getAssetNo() {
        return assetNo;
    }

    /**
     * 设置资产编号
     *
     * @param assetNo 资产编号
     */
    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo;
    }

    /**
     * 获取资产类型:select:[打印机,个人电脑,其他]
     *
     * @return asset_type - 资产类型:select:[打印机,个人电脑,其他]
     */
    public String getAssetType() {
        return assetType;
    }

    /**
     * 设置资产类型:select:[打印机,个人电脑,其他]
     *
     * @param assetType 资产类型:select:[打印机,个人电脑,其他]
     */
    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    /**
     * 获取资产名称
     *
     * @return asset_name - 资产名称
     */
    public String getAssetName() {
        return assetName;
    }

    /**
     * 设置资产名称
     *
     * @param assetName 资产名称
     */
    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    /**
     * 获取规格型号
     *
     * @return guigexinghao - 规格型号
     */
    public String getGuigexinghao() {
        return guigexinghao;
    }

    /**
     * 设置规格型号
     *
     * @param guigexinghao 规格型号
     */
    public void setGuigexinghao(String guigexinghao) {
        this.guigexinghao = guigexinghao;
    }

    /**
     * 获取品牌
     *
     * @return brand - 品牌
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置品牌
     *
     * @param brand 品牌
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 获取原值
     *
     * @return yuanzhi - 原值
     */
    public String getYuanzhi() {
        return yuanzhi;
    }

    /**
     * 设置原值
     *
     * @param yuanzhi 原值
     */
    public void setYuanzhi(String yuanzhi) {
        this.yuanzhi = yuanzhi;
    }

    /**
     * 获取残值
     *
     * @return canzhi - 残值
     */
    public String getCanzhi() {
        return canzhi;
    }

    /**
     * 设置残值
     *
     * @param canzhi 残值
     */
    public void setCanzhi(String canzhi) {
        this.canzhi = canzhi;
    }

    /**
     * 获取价值
     *
     * @return jiazhi - 价值
     */
    public String getJiazhi() {
        return jiazhi;
    }

    /**
     * 设置价值
     *
     * @param jiazhi 价值
     */
    public void setJiazhi(String jiazhi) {
        this.jiazhi = jiazhi;
    }

    /**
     * 获取取得方式:select:[自购,政府采购]
     *
     * @return get_way - 取得方式:select:[自购,政府采购]
     */
    public String getGetWay() {
        return getWay;
    }

    /**
     * 设置取得方式:select:[自购,政府采购]
     *
     * @param getWay 取得方式:select:[自购,政府采购]
     */
    public void setGetWay(String getWay) {
        this.getWay = getWay;
    }

    /**
     * 获取获得日期:date
     *
     * @return get_date - 获得日期:date
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    public Date getGetDate() {
        return getDate;
    }

    /**
     * 设置获得日期:date
     *
     * @param getDate 获得日期:date
     */
    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    /**
     * 获取使用状况:select:[在用,不在用]
     *
     * @return use_situation - 使用状况:select:[在用,不在用]
     */
    public String getUseSituation() {
        return useSituation;
    }

    /**
     * 设置使用状况:select:[在用,不在用]
     *
     * @param useSituation 使用状况:select:[在用,不在用]
     */
    public void setUseSituation(String useSituation) {
        this.useSituation = useSituation;
    }

    /**
     * 获取财务入账日期:date
     *
     * @return caiwuruzhang_date - 财务入账日期:date
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    public Date getCaiwuruzhangDate() {
        return caiwuruzhangDate;
    }

    /**
     * 设置财务入账日期:date
     *
     * @param caiwuruzhangDate 财务入账日期:date
     */
    public void setCaiwuruzhangDate(Date caiwuruzhangDate) {
        this.caiwuruzhangDate = caiwuruzhangDate;
    }

    /**
     * 获取使用方式:select:[自用,公用]
     *
     * @return use_type - 使用方式:select:[自用,公用]
     */
    public String getUseType() {
        return useType;
    }

    /**
     * 设置使用方式:select:[自用,公用]
     *
     * @param useType 使用方式:select:[自用,公用]
     */
    public void setUseType(String useType) {
        this.useType = useType;
    }

    /**
     * 获取使用人
     *
     * @return use_person - 使用人
     */
    public String getUsePerson() {
        return usePerson;
    }

    /**
     * 设置使用人
     *
     * @param usePerson 使用人
     */
    public void setUsePerson(String usePerson) {
        this.usePerson = usePerson;
    }

    /**
     * 获取使用部门
     *
     * @return use_department - 使用部门
     */
    public String getUseDepartment() {
        return useDepartment;
    }

    /**
     * 设置使用部门
     *
     * @param useDepartment 使用部门
     */
    public void setUseDepartment(String useDepartment) {
        this.useDepartment = useDepartment;
    }

    /**
     * 获取管理部门
     *
     * @return manager_department - 管理部门
     */
    public String getManagerDepartment() {
        return managerDepartment;
    }

    /**
     * 设置管理部门
     *
     * @param managerDepartment 管理部门
     */
    public void setManagerDepartment(String managerDepartment) {
        this.managerDepartment = managerDepartment;
    }

    /**
     * 获取备注:textarea
     *
     * @return memo - 备注:textarea
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注:textarea
     *
     * @param memo 备注:textarea
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }
}
