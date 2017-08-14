package com.topie.huaifang.database.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "d_person_info_rent")
public class PersonInfoRent {
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
     * 是否家庭流入:radioGroup:[是,否]
     */
    @Column(name = "is_family_in")
    private String isFamilyIn;

    /**
     * 流入人数
     */
    @Column(name = "family_in_num")
    private Short familyInNum;

    /**
     * 16岁以下男性人数
     */
    @Column(name = "family_in_lt_sixteen_male")
    private Short familyInLtSixteenMale;

    /**
     * 16岁以下女性人数
     */
    @Column(name = "family_in_lt_sixteen_female")
    private Short familyInLtSixteenFemale;

    /**
     * 是否户主:radioGroup:[是,否]
     */
    @Column(name = "is_owner")
    private String isOwner;

    /**
     * 户主名称
     */
    @Column(name = "owner_name")
    private String ownerName;

    /**
     * 与户主关系
     */
    @Column(name = "owner_relate")
    private String ownerRelate;

    /**
     * 离开原籍日期:date
     */
    @Column(name = "leave_hometown_date")
    private Date leaveHometownDate;

    /**
     * 来京日期:date
     */
    @Column(name = "enter_beijing_date")
    private Date enterBeijingDate;

    /**
     * 来居住地日期:date
     */
    @Column(name = "enter_residence_date")
    private Date enterResidenceDate;

    /**
     * 来京原因
     */
    @Column(name = "enter_beijing_resion")
    private String enterBeijingResion;

    /**
     * 居住类型
     */
    @Column(name = "residence_type")
    private String residenceType;

    /**
     * 所属派出所
     */
    @Column(name = "police_station")
    private String policeStation;

    /**
     * 民警
     */
    private String police;

    /**
     * 房东名称
     */
    @Column(name = "household_name")
    private String householdName;

    /**
     * 房东电话
     */
    @Column(name = "household_phone")
    private String householdPhone;

    /**
     * 目前状况
     */
    private String situation;

    /**
     * 就业单位/学校
     */
    @Column(name = "firm_or_school")
    private String firmOrSchool;

    /**
     * 单位地址
     */
    @Column(name = "firm_address")
    private String firmAddress;

    @Column(name = "firm_industry")
    private String firmIndustry;

    /**
     * 主要从事工作
     */
    @Column(name = "main_job")
    private String mainJob;

    /**
     * 职业
     */
    private String profession;

    @Column(name = "social_security")
    private String socialSecurity;

    @Column(name = "has_contract")
    private String hasContract;

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
     * 获取是否家庭流入:radioGroup:[是,否]
     *
     * @return is_family_in - 是否家庭流入:radioGroup:[是,否]
     */
    public String getIsFamilyIn() {
        return isFamilyIn;
    }

    /**
     * 设置是否家庭流入:radioGroup:[是,否]
     *
     * @param isFamilyIn 是否家庭流入:radioGroup:[是,否]
     */
    public void setIsFamilyIn(String isFamilyIn) {
        this.isFamilyIn = isFamilyIn;
    }

    /**
     * 获取流入人数
     *
     * @return family_in_num - 流入人数
     */
    public Short getFamilyInNum() {
        return familyInNum;
    }

    /**
     * 设置流入人数
     *
     * @param familyInNum 流入人数
     */
    public void setFamilyInNum(Short familyInNum) {
        this.familyInNum = familyInNum;
    }

    /**
     * 获取16岁以下男性人数
     *
     * @return family_in_lt_sixteen_male - 16岁以下男性人数
     */
    public Short getFamilyInLtSixteenMale() {
        return familyInLtSixteenMale;
    }

    /**
     * 设置16岁以下男性人数
     *
     * @param familyInLtSixteenMale 16岁以下男性人数
     */
    public void setFamilyInLtSixteenMale(Short familyInLtSixteenMale) {
        this.familyInLtSixteenMale = familyInLtSixteenMale;
    }

    /**
     * 获取16岁以下女性人数
     *
     * @return family_in_lt_sixteen_female - 16岁以下女性人数
     */
    public Short getFamilyInLtSixteenFemale() {
        return familyInLtSixteenFemale;
    }

    /**
     * 设置16岁以下女性人数
     *
     * @param familyInLtSixteenFemale 16岁以下女性人数
     */
    public void setFamilyInLtSixteenFemale(Short familyInLtSixteenFemale) {
        this.familyInLtSixteenFemale = familyInLtSixteenFemale;
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
     * 获取户主名称
     *
     * @return owner_name - 户主名称
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * 设置户主名称
     *
     * @param ownerName 户主名称
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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
     * 获取离开原籍日期:date
     *
     * @return leave_hometown_date - 离开原籍日期:date
     */
    public Date getLeaveHometownDate() {
        return leaveHometownDate;
    }

    /**
     * 设置离开原籍日期:date
     *
     * @param leaveHometownDate 离开原籍日期:date
     */
    public void setLeaveHometownDate(Date leaveHometownDate) {
        this.leaveHometownDate = leaveHometownDate;
    }

    /**
     * 获取来京日期:date
     *
     * @return enter_beijing_date - 来京日期:date
     */
    public Date getEnterBeijingDate() {
        return enterBeijingDate;
    }

    /**
     * 设置来京日期:date
     *
     * @param enterBeijingDate 来京日期:date
     */
    public void setEnterBeijingDate(Date enterBeijingDate) {
        this.enterBeijingDate = enterBeijingDate;
    }

    /**
     * 获取来居住地日期:date
     *
     * @return enter_residence_date - 来居住地日期:date
     */
    public Date getEnterResidenceDate() {
        return enterResidenceDate;
    }

    /**
     * 设置来居住地日期:date
     *
     * @param enterResidenceDate 来居住地日期:date
     */
    public void setEnterResidenceDate(Date enterResidenceDate) {
        this.enterResidenceDate = enterResidenceDate;
    }

    /**
     * 获取来京原因
     *
     * @return enter_beijing_resion - 来京原因
     */
    public String getEnterBeijingResion() {
        return enterBeijingResion;
    }

    /**
     * 设置来京原因
     *
     * @param enterBeijingResion 来京原因
     */
    public void setEnterBeijingResion(String enterBeijingResion) {
        this.enterBeijingResion = enterBeijingResion;
    }

    /**
     * 获取居住类型
     *
     * @return residence_type - 居住类型
     */
    public String getResidenceType() {
        return residenceType;
    }

    /**
     * 设置居住类型
     *
     * @param residenceType 居住类型
     */
    public void setResidenceType(String residenceType) {
        this.residenceType = residenceType;
    }

    /**
     * 获取所属派出所
     *
     * @return police_station - 所属派出所
     */
    public String getPoliceStation() {
        return policeStation;
    }

    /**
     * 设置所属派出所
     *
     * @param policeStation 所属派出所
     */
    public void setPoliceStation(String policeStation) {
        this.policeStation = policeStation;
    }

    /**
     * 获取民警
     *
     * @return police - 民警
     */
    public String getPolice() {
        return police;
    }

    /**
     * 设置民警
     *
     * @param police 民警
     */
    public void setPolice(String police) {
        this.police = police;
    }

    /**
     * 获取房东名称
     *
     * @return household_name - 房东名称
     */
    public String getHouseholdName() {
        return householdName;
    }

    /**
     * 设置房东名称
     *
     * @param householdName 房东名称
     */
    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }

    /**
     * 获取房东电话
     *
     * @return household_phone - 房东电话
     */
    public String getHouseholdPhone() {
        return householdPhone;
    }

    /**
     * 设置房东电话
     *
     * @param householdPhone 房东电话
     */
    public void setHouseholdPhone(String householdPhone) {
        this.householdPhone = householdPhone;
    }

    /**
     * 获取目前状况
     *
     * @return situation - 目前状况
     */
    public String getSituation() {
        return situation;
    }

    /**
     * 设置目前状况
     *
     * @param situation 目前状况
     */
    public void setSituation(String situation) {
        this.situation = situation;
    }

    /**
     * 获取就业单位/学校
     *
     * @return firm_or_school - 就业单位/学校
     */
    public String getFirmOrSchool() {
        return firmOrSchool;
    }

    /**
     * 设置就业单位/学校
     *
     * @param firmOrSchool 就业单位/学校
     */
    public void setFirmOrSchool(String firmOrSchool) {
        this.firmOrSchool = firmOrSchool;
    }

    /**
     * 获取单位地址
     *
     * @return firm_address - 单位地址
     */
    public String getFirmAddress() {
        return firmAddress;
    }

    /**
     * 设置单位地址
     *
     * @param firmAddress 单位地址
     */
    public void setFirmAddress(String firmAddress) {
        this.firmAddress = firmAddress;
    }

    /**
     * @return firm_industry
     */
    public String getFirmIndustry() {
        return firmIndustry;
    }

    /**
     * @param firmIndustry
     */
    public void setFirmIndustry(String firmIndustry) {
        this.firmIndustry = firmIndustry;
    }

    /**
     * 获取主要从事工作
     *
     * @return main_job - 主要从事工作
     */
    public String getMainJob() {
        return mainJob;
    }

    /**
     * 设置主要从事工作
     *
     * @param mainJob 主要从事工作
     */
    public void setMainJob(String mainJob) {
        this.mainJob = mainJob;
    }

    /**
     * 获取职业
     *
     * @return profession - 职业
     */
    public String getProfession() {
        return profession;
    }

    /**
     * 设置职业
     *
     * @param profession 职业
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    /**
     * @return social_security
     */
    public String getSocialSecurity() {
        return socialSecurity;
    }

    /**
     * @param socialSecurity
     */
    public void setSocialSecurity(String socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    /**
     * @return has_contract
     */
    public String getHasContract() {
        return hasContract;
    }

    /**
     * @param hasContract
     */
    public void setHasContract(String hasContract) {
        this.hasContract = hasContract;
    }
}