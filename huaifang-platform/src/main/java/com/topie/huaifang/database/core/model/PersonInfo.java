package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "d_person_info")
public class PersonInfo {

    /**
     * ID:hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Integer pId;

    /**
     * 人口身份:select:[租户,住户]
     */
    @Column(name = "p_person_type")
    private String pPersonType;

    /**
     * 绑定架构id:hidden
     */
    @Column(name = "p_house_node_id")
    private Integer pHouseNodeId;

    /**
     * 绑定房屋信息
     */
    @Column(name = "p_house_info")
    private String pHouseInfo;

    /**
     * 手机号码
     */
    @Column(name = "p_mobile_phone")
    @NotEmpty(message = "手机号码不能为空")
    private String pMobilePhone;

    /**
     * 姓名
     */
    @Column(name = "p_name")
    @NotEmpty(message = "姓名不能为空")
    private String pName;

    /**
     * 出生年月:date
     */
    @Column(name = "p_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pBirth;

    /**
     * 身份证号
     */
    @Column(name = "p_identify_number")
    @NotEmpty(message = "身份证号不能为空")
    private String pIdentifyNumber;

    /**
     * 入库时间:datetime
     */
    @Column(name = "p_import_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pImportTime;

    public String getpMobilePhone() {
        return pMobilePhone;
    }

    public void setpMobilePhone(String pMobilePhone) {
        this.pMobilePhone = pMobilePhone;
    }

    /**
     * 获取ID:hidden
     *
     * @return p_id - ID:hidden
     */
    public Integer getpId() {
        return pId;
    }

    /**
     * 设置ID:hidden
     *
     * @param pId ID:hidden
     */
    public void setpId(Integer pId) {
        this.pId = pId;
    }

    /**
     * 获取人口身份:select:[租户,住户]
     *
     * @return p_person_type - 人口身份:select:[租户,住户]
     */
    public String getpPersonType() {
        return pPersonType;
    }

    /**
     * 设置人口身份:select:[租户,住户]
     *
     * @param pPersonType 人口身份:select:[租户,住户]
     */
    public void setpPersonType(String pPersonType) {
        this.pPersonType = pPersonType;
    }

    /**
     * 获取绑定架构id:hidden
     *
     * @return p_house_node_id - 绑定架构id:hidden
     */
    public Integer getpHouseNodeId() {
        return pHouseNodeId;
    }

    /**
     * 设置绑定架构id:hidden
     *
     * @param pHouseNodeId 绑定架构id:hidden
     */
    public void setpHouseNodeId(Integer pHouseNodeId) {
        this.pHouseNodeId = pHouseNodeId;
    }

    /**
     * 获取绑定房屋信息
     *
     * @return p_house_info - 绑定房屋信息
     */
    public String getpHouseInfo() {
        return pHouseInfo;
    }

    /**
     * 设置绑定房屋信息
     *
     * @param pHouseInfo 绑定房屋信息
     */
    public void setpHouseInfo(String pHouseInfo) {
        this.pHouseInfo = pHouseInfo;
    }

    /**
     * 获取姓名
     *
     * @return p_name - 姓名
     */
    public String getpName() {
        return pName;
    }

    /**
     * 设置姓名
     *
     * @param pName 姓名
     */
    public void setpName(String pName) {
        this.pName = pName;
    }

    /**
     * 获取出生年月:date
     *
     * @return p_birth - 出生年月:date
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    public Date getpBirth() {
        return pBirth;
    }

    /**
     * 设置出生年月:date
     *
     * @param pBirth 出生年月:date
     */
    public void setpBirth(Date pBirth) {
        this.pBirth = pBirth;
    }

    /**
     * 获取身份证号
     *
     * @return p_identify_number - 身份证号
     */
    public String getpIdentifyNumber() {
        return pIdentifyNumber;
    }

    /**
     * 设置身份证号
     *
     * @param pIdentifyNumber 身份证号
     */
    public void setpIdentifyNumber(String pIdentifyNumber) {
        this.pIdentifyNumber = pIdentifyNumber;
    }

    /**
     * 获取入库时间:datetime
     *
     * @return p_import_time - 入库时间:datetime
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getpImportTime() {
        return pImportTime;
    }

    /**
     * 设置入库时间:datetime
     *
     * @param pImportTime 入库时间:datetime
     */
    public void setpImportTime(Date pImportTime) {
        this.pImportTime = pImportTime;
    }
}
