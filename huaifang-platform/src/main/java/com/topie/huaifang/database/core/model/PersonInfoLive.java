package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "d_person_info_live")
public class PersonInfoLive {

    /**
     * ID:hidden
     */
    @Id
    @Column(name = "l_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lId;

    /**
     * 人口ID:hidden
     */
    @Column(name = "l_person_id")
    private Integer lPersonId;

    /**
     * 姓名
     */
    @Column(name = "l_name")
    private String lName;

    /**
     * 性别:radioGroup:[男,女]
     */
    @Column(name = "l_gender")
    private String lGender;

    /**
     * 出生年月:date
     */
    @Column(name = "l_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lBirth;

    /**
     * 身份证号
     */
    @Column(name = "l_identify_number")
    private String lIdentifyNumber;

    /**
     * 民族
     */
    @Column(name = "l_nation")
    private String lNation;

    /**
     * 政治面貌
     */
    @Column(name = "l_political_status")
    private String lPoliticalStatus;

    /**
     * 户籍类别
     */
    @Column(name = "l_census_type")
    private String lCensusType;

    /**
     * 户籍地址
     */
    @Column(name = "l_census_address")
    private String lCensusAddress;

    /**
     * 出生地
     */
    @Column(name = "l_born_place")
    private String lBornPlace;

    /**
     * 居住地
     */
    @Column(name = "l_residence_place")
    private String lResidencePlace;

    /**
     * 婚姻状况
     */
    @Column(name = "l_marriage_status")
    private String lMarriageStatus;

    /**
     * 联系电话
     */
    @Column(name = "l_contact")
    private String lContact;

    /**
     * 是否户主:radioGroup:[是,否]
     */
    @Column(name = "l_is_owner")
    private String lIsOwner;

    /**
     * 与户主关系
     */
    @Column(name = "l_owner_relate")
    private String lOwnerRelate;

    /**
     * 槐房工作单位
     */
    @Column(name = "l_company_huaifang")
    private String lCompanyHuaifang;

    /**
     * 其它工作单位
     */
    @Column(name = "l_company_other")
    private String lCompanyOther;

    /**
     * 职位
     */
    @Column(name = "l_job_position")
    private String lJobPosition;

    /**
     * 是否槐房村民:radioGroup:[是,否]
     */
    @Column(name = "l_is_huaifang_pepole")
    private String lIsHuaifangPepole;

    /**
     * 人口属性:checkboxGroup:[独生子女,待岗职工,优抚对象,居民代表,村民代表,人大代表,股东代表,党代表,现役军人,复转军人,军属]
     */
    @Column(name = "l_rksx")
    private String lRksx;

    /**
     * 是否残疾人员:select:[正常,是]
     */
    @Column(name = "l_is_canji")
    private String lIsCanji;

    /**
     * 是否死亡人员:select:[否,是]
     */
    @Column(name = "l_is_dead")
    private String lIsDead;

    /**
     * 死亡日期:date
     */
    @Column(name = "l_dead_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lDeadDate;

    /**
     * 备注:textarea
     */
    @Column(name = "l_memo")
    private String lMemo;

    /**
     * 获取ID:hidden
     *
     * @return l_id - ID:hidden
     */
    public Integer getlId() {
        return lId;
    }

    /**
     * 设置ID:hidden
     *
     * @param lId ID:hidden
     */
    public void setlId(Integer lId) {
        this.lId = lId;
    }

    public Integer getlPersonId() {
        return lPersonId;
    }

    public void setlPersonId(Integer lPersonId) {
        this.lPersonId = lPersonId;
    }

    /**
     * 获取姓名
     *
     * @return l_name - 姓名
     */
    public String getlName() {
        return lName;
    }

    /**
     * 设置姓名
     *
     * @param lName 姓名
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * 获取性别:radioGroup:[男,女]
     *
     * @return l_gender - 性别:radioGroup:[男,女]
     */
    public String getlGender() {
        return lGender;
    }

    /**
     * 设置性别:radioGroup:[男,女]
     *
     * @param lGender 性别:radioGroup:[男,女]
     */
    public void setlGender(String lGender) {
        this.lGender = lGender;
    }

    /**
     * 获取出生年月:date
     *
     * @return l_birth - 出生年月:date
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    public Date getlBirth() {
        return lBirth;
    }

    /**
     * 设置出生年月:date
     *
     * @param lBirth 出生年月:date
     */
    public void setlBirth(Date lBirth) {
        this.lBirth = lBirth;
    }

    /**
     * 获取身份证号
     *
     * @return l_identify_number - 身份证号
     */
    public String getlIdentifyNumber() {
        return lIdentifyNumber;
    }

    /**
     * 设置身份证号
     *
     * @param lIdentifyNumber 身份证号
     */
    public void setlIdentifyNumber(String lIdentifyNumber) {
        this.lIdentifyNumber = lIdentifyNumber;
    }

    /**
     * 获取民族
     *
     * @return l_nation - 民族
     */
    public String getlNation() {
        return lNation;
    }

    /**
     * 设置民族
     *
     * @param lNation 民族
     */
    public void setlNation(String lNation) {
        this.lNation = lNation;
    }

    /**
     * 获取政治面貌
     *
     * @return l_political_status - 政治面貌
     */
    public String getlPoliticalStatus() {
        return lPoliticalStatus;
    }

    /**
     * 设置政治面貌
     *
     * @param lPoliticalStatus 政治面貌
     */
    public void setlPoliticalStatus(String lPoliticalStatus) {
        this.lPoliticalStatus = lPoliticalStatus;
    }

    /**
     * 获取户籍类别
     *
     * @return l_census_type - 户籍类别
     */
    public String getlCensusType() {
        return lCensusType;
    }

    /**
     * 设置户籍类别
     *
     * @param lCensusType 户籍类别
     */
    public void setlCensusType(String lCensusType) {
        this.lCensusType = lCensusType;
    }

    /**
     * 获取户籍地址
     *
     * @return l_census_address - 户籍地址
     */
    public String getlCensusAddress() {
        return lCensusAddress;
    }

    /**
     * 设置户籍地址
     *
     * @param lCensusAddress 户籍地址
     */
    public void setlCensusAddress(String lCensusAddress) {
        this.lCensusAddress = lCensusAddress;
    }

    /**
     * 获取出生地
     *
     * @return l_born_place - 出生地
     */
    public String getlBornPlace() {
        return lBornPlace;
    }

    /**
     * 设置出生地
     *
     * @param lBornPlace 出生地
     */
    public void setlBornPlace(String lBornPlace) {
        this.lBornPlace = lBornPlace;
    }

    /**
     * 获取居住地
     *
     * @return l_residence_place - 居住地
     */
    public String getlResidencePlace() {
        return lResidencePlace;
    }

    /**
     * 设置居住地
     *
     * @param lResidencePlace 居住地
     */
    public void setlResidencePlace(String lResidencePlace) {
        this.lResidencePlace = lResidencePlace;
    }

    /**
     * 获取婚姻状况
     *
     * @return l_marriage_status - 婚姻状况
     */
    public String getlMarriageStatus() {
        return lMarriageStatus;
    }

    /**
     * 设置婚姻状况
     *
     * @param lMarriageStatus 婚姻状况
     */
    public void setlMarriageStatus(String lMarriageStatus) {
        this.lMarriageStatus = lMarriageStatus;
    }

    /**
     * 获取联系电话
     *
     * @return l_contact - 联系电话
     */
    public String getlContact() {
        return lContact;
    }

    /**
     * 设置联系电话
     *
     * @param lContact 联系电话
     */
    public void setlContact(String lContact) {
        this.lContact = lContact;
    }

    /**
     * 获取是否户主:radioGroup:[是,否]
     *
     * @return l_is_owner - 是否户主:radioGroup:[是,否]
     */
    public String getlIsOwner() {
        return lIsOwner;
    }

    /**
     * 设置是否户主:radioGroup:[是,否]
     *
     * @param lIsOwner 是否户主:radioGroup:[是,否]
     */
    public void setlIsOwner(String lIsOwner) {
        this.lIsOwner = lIsOwner;
    }

    /**
     * 获取与户主关系
     *
     * @return l_owner_relate - 与户主关系
     */
    public String getlOwnerRelate() {
        return lOwnerRelate;
    }

    /**
     * 设置与户主关系
     *
     * @param lOwnerRelate 与户主关系
     */
    public void setlOwnerRelate(String lOwnerRelate) {
        this.lOwnerRelate = lOwnerRelate;
    }

    /**
     * 获取槐房工作单位
     *
     * @return l_company_huaifang - 槐房工作单位
     */
    public String getlCompanyHuaifang() {
        return lCompanyHuaifang;
    }

    /**
     * 设置槐房工作单位
     *
     * @param lCompanyHuaifang 槐房工作单位
     */
    public void setlCompanyHuaifang(String lCompanyHuaifang) {
        this.lCompanyHuaifang = lCompanyHuaifang;
    }

    /**
     * 获取其它工作单位
     *
     * @return l_company_other - 其它工作单位
     */
    public String getlCompanyOther() {
        return lCompanyOther;
    }

    /**
     * 设置其它工作单位
     *
     * @param lCompanyOther 其它工作单位
     */
    public void setlCompanyOther(String lCompanyOther) {
        this.lCompanyOther = lCompanyOther;
    }

    /**
     * 获取职位
     *
     * @return l_job_position - 职位
     */
    public String getlJobPosition() {
        return lJobPosition;
    }

    /**
     * 设置职位
     *
     * @param lJobPosition 职位
     */
    public void setlJobPosition(String lJobPosition) {
        this.lJobPosition = lJobPosition;
    }

    /**
     * 获取是否槐房村民:radioGroup:[是,否]
     *
     * @return l_is_huaifang_pepole - 是否槐房村民:radioGroup:[是,否]
     */
    public String getlIsHuaifangPepole() {
        return lIsHuaifangPepole;
    }

    /**
     * 设置是否槐房村民:radioGroup:[是,否]
     *
     * @param lIsHuaifangPepole 是否槐房村民:radioGroup:[是,否]
     */
    public void setlIsHuaifangPepole(String lIsHuaifangPepole) {
        this.lIsHuaifangPepole = lIsHuaifangPepole;
    }

    /**
     * 获取人口属性:checkboxGroup:[独生子女,待岗职工,优抚对象,居民代表,村民代表,人大代表,股东代表,党代表,现役军人,复转军人,军属]
     *
     * @return l_rksx - 人口属性:checkboxGroup:[独生子女,待岗职工,优抚对象,居民代表,村民代表,人大代表,股东代表,党代表,现役军人,复转军人,军属]
     */
    public String getlRksx() {
        return lRksx;
    }

    /**
     * 设置人口属性:checkboxGroup:[独生子女,待岗职工,优抚对象,居民代表,村民代表,人大代表,股东代表,党代表,现役军人,复转军人,军属]
     *
     * @param lRksx 人口属性:checkboxGroup:[独生子女,待岗职工,优抚对象,居民代表,村民代表,人大代表,股东代表,党代表,现役军人,复转军人,军属]
     */
    public void setlRksx(String lRksx) {
        this.lRksx = lRksx;
    }

    /**
     * 获取是否残疾人员:select:[正常,是]
     *
     * @return l_is_canji - 是否残疾人员:select:[正常,是]
     */
    public String getlIsCanji() {
        return lIsCanji;
    }

    /**
     * 设置是否残疾人员:select:[正常,是]
     *
     * @param lIsCanji 是否残疾人员:select:[正常,是]
     */
    public void setlIsCanji(String lIsCanji) {
        this.lIsCanji = lIsCanji;
    }

    /**
     * 获取是否死亡人员:select:[否,是]
     *
     * @return l_is_dead - 是否死亡人员:select:[否,是]
     */
    public String getlIsDead() {
        return lIsDead;
    }

    /**
     * 设置是否死亡人员:select:[否,是]
     *
     * @param lIsDead 是否死亡人员:select:[否,是]
     */
    public void setlIsDead(String lIsDead) {
        this.lIsDead = lIsDead;
    }

    /**
     * 获取死亡日期:date
     *
     * @return l_dead_date - 死亡日期:date
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    public Date getlDeadDate() {
        return lDeadDate;
    }

    /**
     * 设置死亡日期:date
     *
     * @param lDeadDate 死亡日期:date
     */
    public void setlDeadDate(Date lDeadDate) {
        this.lDeadDate = lDeadDate;
    }

    /**
     * 获取备注:textarea
     *
     * @return l_memo - 备注:textarea
     */
    public String getlMemo() {
        return lMemo;
    }

    /**
     * 设置备注:textarea
     *
     * @param lMemo 备注:textarea
     */
    public void setlMemo(String lMemo) {
        this.lMemo = lMemo;
    }
}
