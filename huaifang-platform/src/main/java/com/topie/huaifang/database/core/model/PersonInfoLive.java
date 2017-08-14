package com.topie.huaifang.database.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "d_person_info_live")
public class PersonInfoLive {
    /**
     * ID:hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 人口ID:hidden
     */
    @Column(name = "person_id")
    private String personId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别:radioGroup:[男,女]
     */
    private String gender;

    /**
     * 出生年月:date
     */
    private Date birth;

    /**
     * 身份证号
     */
    @Column(name = "identify_number")
    private String identifyNumber;

    /**
     * 民族
     */
    private String nation;

    /**
     * 政治面貌
     */
    @Column(name = "political_status")
    private String politicalStatus;

    /**
     * 户籍类别
     */
    @Column(name = "census_type")
    private String censusType;

    /**
     * 户籍地址
     */
    @Column(name = "census_address")
    private String censusAddress;

    /**
     * 出生地
     */
    @Column(name = "born_place")
    private String bornPlace;

    /**
     * 居住地
     */
    @Column(name = "residence_place")
    private String residencePlace;

    /**
     * 婚姻状况
     */
    @Column(name = "marriage_status")
    private String marriageStatus;

    /**
     * 联系电话
     */
    private String contact;

    /**
     * 是否户主:radioGroup:[是,否]
     */
    @Column(name = "is_owner")
    private String isOwner;

    /**
     * 与户主关系
     */
    @Column(name = "owner_relate")
    private String ownerRelate;

    /**
     * 槐房工作单位
     */
    @Column(name = "company_huaifang")
    private String companyHuaifang;

    /**
     * 其它工作单位
     */
    @Column(name = "company_other")
    private String companyOther;

    /**
     * 职位
     */
    @Column(name = "job_position")
    private String jobPosition;

    /**
     * 是否槐房村民:radioGroup:[是,否]
     */
    @Column(name = "is_huaifang_pepole")
    private String isHuaifangPepole;

    /**
     * 人口属性:checkboxGroup:[独生子女,待岗职工,优抚对象,居民代表,村民代表,人大代表,股东代表,党代表,现役军人,复转军人,军属]
     */
    private String rksx;

    /**
     * 是否残疾人员:select:[正常,是]
     */
    @Column(name = "is_canji")
    private String isCanji;

    /**
     * 是否死亡人员:select:[否,是]
     */
    @Column(name = "is_dead")
    private String isDead;

    /**
     * 死亡日期:date
     */
    @Column(name = "dead_date")
    private Date deadDate;

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
     * 获取人口ID:hidden
     *
     * @return person_id - 人口ID:hidden
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * 设置人口ID:hidden
     *
     * @param personId 人口ID:hidden
     */
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取性别:radioGroup:[男,女]
     *
     * @return gender - 性别:radioGroup:[男,女]
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别:radioGroup:[男,女]
     *
     * @param gender 性别:radioGroup:[男,女]
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取出生年月:date
     *
     * @return birth - 出生年月:date
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * 设置出生年月:date
     *
     * @param birth 出生年月:date
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * 获取身份证号
     *
     * @return identify_number - 身份证号
     */
    public String getIdentifyNumber() {
        return identifyNumber;
    }

    /**
     * 设置身份证号
     *
     * @param identifyNumber 身份证号
     */
    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    /**
     * 获取民族
     *
     * @return nation - 民族
     */
    public String getNation() {
        return nation;
    }

    /**
     * 设置民族
     *
     * @param nation 民族
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * 获取政治面貌
     *
     * @return political_status - 政治面貌
     */
    public String getPoliticalStatus() {
        return politicalStatus;
    }

    /**
     * 设置政治面貌
     *
     * @param politicalStatus 政治面貌
     */
    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    /**
     * 获取户籍类别
     *
     * @return census_type - 户籍类别
     */
    public String getCensusType() {
        return censusType;
    }

    /**
     * 设置户籍类别
     *
     * @param censusType 户籍类别
     */
    public void setCensusType(String censusType) {
        this.censusType = censusType;
    }

    /**
     * 获取户籍地址
     *
     * @return census_address - 户籍地址
     */
    public String getCensusAddress() {
        return censusAddress;
    }

    /**
     * 设置户籍地址
     *
     * @param censusAddress 户籍地址
     */
    public void setCensusAddress(String censusAddress) {
        this.censusAddress = censusAddress;
    }

    /**
     * 获取出生地
     *
     * @return born_place - 出生地
     */
    public String getBornPlace() {
        return bornPlace;
    }

    /**
     * 设置出生地
     *
     * @param bornPlace 出生地
     */
    public void setBornPlace(String bornPlace) {
        this.bornPlace = bornPlace;
    }

    /**
     * 获取居住地
     *
     * @return residence_place - 居住地
     */
    public String getResidencePlace() {
        return residencePlace;
    }

    /**
     * 设置居住地
     *
     * @param residencePlace 居住地
     */
    public void setResidencePlace(String residencePlace) {
        this.residencePlace = residencePlace;
    }

    /**
     * 获取婚姻状况
     *
     * @return marriage_status - 婚姻状况
     */
    public String getMarriageStatus() {
        return marriageStatus;
    }

    /**
     * 设置婚姻状况
     *
     * @param marriageStatus 婚姻状况
     */
    public void setMarriageStatus(String marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    /**
     * 获取联系电话
     *
     * @return contact - 联系电话
     */
    public String getContact() {
        return contact;
    }

    /**
     * 设置联系电话
     *
     * @param contact 联系电话
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * 获取是否户主:radioGroup:[是,否]
     *
     * @return is_owner - 是否户主:radioGroup:[是,否]
     */
    public String getIsOwner() {
        return isOwner;
    }

    /**
     * 设置是否户主:radioGroup:[是,否]
     *
     * @param isOwner 是否户主:radioGroup:[是,否]
     */
    public void setIsOwner(String isOwner) {
        this.isOwner = isOwner;
    }

    /**
     * 获取与户主关系
     *
     * @return owner_relate - 与户主关系
     */
    public String getOwnerRelate() {
        return ownerRelate;
    }

    /**
     * 设置与户主关系
     *
     * @param ownerRelate 与户主关系
     */
    public void setOwnerRelate(String ownerRelate) {
        this.ownerRelate = ownerRelate;
    }

    /**
     * 获取槐房工作单位
     *
     * @return company_huaifang - 槐房工作单位
     */
    public String getCompanyHuaifang() {
        return companyHuaifang;
    }

    /**
     * 设置槐房工作单位
     *
     * @param companyHuaifang 槐房工作单位
     */
    public void setCompanyHuaifang(String companyHuaifang) {
        this.companyHuaifang = companyHuaifang;
    }

    /**
     * 获取其它工作单位
     *
     * @return company_other - 其它工作单位
     */
    public String getCompanyOther() {
        return companyOther;
    }

    /**
     * 设置其它工作单位
     *
     * @param companyOther 其它工作单位
     */
    public void setCompanyOther(String companyOther) {
        this.companyOther = companyOther;
    }

    /**
     * 获取职位
     *
     * @return job_position - 职位
     */
    public String getJobPosition() {
        return jobPosition;
    }

    /**
     * 设置职位
     *
     * @param jobPosition 职位
     */
    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    /**
     * 获取是否槐房村民:radioGroup:[是,否]
     *
     * @return is_huaifang_pepole - 是否槐房村民:radioGroup:[是,否]
     */
    public String getIsHuaifangPepole() {
        return isHuaifangPepole;
    }

    /**
     * 设置是否槐房村民:radioGroup:[是,否]
     *
     * @param isHuaifangPepole 是否槐房村民:radioGroup:[是,否]
     */
    public void setIsHuaifangPepole(String isHuaifangPepole) {
        this.isHuaifangPepole = isHuaifangPepole;
    }

    /**
     * 获取人口属性:checkboxGroup:[独生子女,待岗职工,优抚对象,居民代表,村民代表,人大代表,股东代表,党代表,现役军人,复转军人,军属]
     *
     * @return rksx - 人口属性:checkboxGroup:[独生子女,待岗职工,优抚对象,居民代表,村民代表,人大代表,股东代表,党代表,现役军人,复转军人,军属]
     */
    public String getRksx() {
        return rksx;
    }

    /**
     * 设置人口属性:checkboxGroup:[独生子女,待岗职工,优抚对象,居民代表,村民代表,人大代表,股东代表,党代表,现役军人,复转军人,军属]
     *
     * @param rksx 人口属性:checkboxGroup:[独生子女,待岗职工,优抚对象,居民代表,村民代表,人大代表,股东代表,党代表,现役军人,复转军人,军属]
     */
    public void setRksx(String rksx) {
        this.rksx = rksx;
    }

    /**
     * 获取是否残疾人员:select:[正常,是]
     *
     * @return is_canji - 是否残疾人员:select:[正常,是]
     */
    public String getIsCanji() {
        return isCanji;
    }

    /**
     * 设置是否残疾人员:select:[正常,是]
     *
     * @param isCanji 是否残疾人员:select:[正常,是]
     */
    public void setIsCanji(String isCanji) {
        this.isCanji = isCanji;
    }

    /**
     * 获取是否死亡人员:select:[否,是]
     *
     * @return is_dead - 是否死亡人员:select:[否,是]
     */
    public String getIsDead() {
        return isDead;
    }

    /**
     * 设置是否死亡人员:select:[否,是]
     *
     * @param isDead 是否死亡人员:select:[否,是]
     */
    public void setIsDead(String isDead) {
        this.isDead = isDead;
    }

    /**
     * 获取死亡日期:date
     *
     * @return dead_date - 死亡日期:date
     */
    public Date getDeadDate() {
        return deadDate;
    }

    /**
     * 设置死亡日期:date
     *
     * @param deadDate 死亡日期:date
     */
    public void setDeadDate(Date deadDate) {
        this.deadDate = deadDate;
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