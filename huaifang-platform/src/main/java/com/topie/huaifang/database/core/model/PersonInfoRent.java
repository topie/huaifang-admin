package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "d_person_info_rent")
public class PersonInfoRent {

    /**
     * ID:hidden
     */
    @Id
    @Column(name = "r_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rId;

    /**
     * 人口ID:hidden
     */
    @Column(name = "r_person_id")
    private Integer rPersonId;

    /**
     * 姓名
     */
    @Column(name = "r_name")
    private String rName;

    /**
     * 性别:radioGroup:[男,女]
     */
    @Column(name = "r_gender")
    private String rGender;

    /**
     * 出生年月:date
     */
    @Column(name = "r_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rBirth;

    /**
     * 身份证号
     */
    @Column(name = "r_identify_number")
    private String rIdentifyNumber;

    /**
     * 民族
     */
    @Column(name = "r_nation")
    private String rNation;

    /**
     * 政治面貌
     */
    @Column(name = "r_political_status")
    private String rPoliticalStatus;

    /**
     * 户籍类别
     */
    @Column(name = "r_census_type")
    private String rCensusType;

    /**
     * 户籍地址
     */
    @Column(name = "r_census_address")
    private String rCensusAddress;

    /**
     * 出生地
     */
    @Column(name = "r_born_place")
    private String rBornPlace;

    /**
     * 居住地
     */
    @Column(name = "r_residence_place")
    private String rResidencePlace;

    /**
     * 婚姻状况
     */
    @Column(name = "r_marriage_status")
    private String rMarriageStatus;

    /**
     * 联系电话
     */
    @Column(name = "r_contact")
    private String rContact;

    /**
     * 是否家庭流入:radioGroup:[是,否]
     */
    @Column(name = "r_is_family_in")
    private String rIsFamilyIn;

    /**
     * 流入人数
     */
    @Column(name = "r_family_in_num")
    private Short rFamilyInNum;

    /**
     * 16岁以下男性人数
     */
    @Column(name = "r_family_in_lt_sixteen_male")
    private Short rFamilyInLtSixteenMale;

    /**
     * 16岁以下女性人数
     */
    @Column(name = "r_family_in_lt_sixteen_female")
    private Short rFamilyInLtSixteenFemale;

    /**
     * 是否户主:radioGroup:[是,否]
     */
    @Column(name = "r_is_owner")
    private String rIsOwner;

    /**
     * 户主名称
     */
    @Column(name = "r_owner_name")
    private String rOwnerName;

    /**
     * 与户主关系
     */
    @Column(name = "r_owner_relate")
    private String rOwnerRelate;

    /**
     * 离开原籍日期:date
     */
    @Column(name = "r_leave_hometown_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rLeaveHometownDate;

    /**
     * 来京日期:date
     */
    @Column(name = "r_enter_beijing_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rEnterBeijingDate;

    /**
     * 来居住地日期:date
     */
    @Column(name = "r_enter_residence_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rEnterResidenceDate;

    /**
     * 来京原因
     */
    @Column(name = "r_enter_beijing_resion")
    private String rEnterBeijingResion;

    /**
     * 居住类型
     */
    @Column(name = "r_residence_type")
    private String rResidenceType;

    /**
     * 所属派出所
     */
    @Column(name = "r_police_station")
    private String rPoliceStation;

    /**
     * 民警
     */
    @Column(name = "r_police")
    private String rPolice;

    /**
     * 房东名称
     */
    @Column(name = "r_household_name")
    private String rHouseholdName;

    /**
     * 房东电话
     */
    @Column(name = "r_household_phone")
    private String rHouseholdPhone;

    /**
     * 目前状况
     */
    @Column(name = "r_situation")
    private String rSituation;

    /**
     * 就业单位/学校
     */
    @Column(name = "r_firm_or_school")
    private String rFirmOrSchool;

    /**
     * 单位地址
     */
    @Column(name = "r_firm_address")
    private String rFirmAddress;

    /**
     * 单位所属行业:select:
     */
    @Column(name = "r_firm_industry")
    private String rFirmIndustry;

    /**
     * 主要从事工作
     */
    @Column(name = "r_main_job")
    private String rMainJob;

    /**
     * 职业
     */
    @Column(name = "r_profession")
    private String rProfession;

    /**
     * 社保:radioGroup:[无,工伤,医疗,失业,养老,生育]
     */
    @Column(name = "r_social_security")
    private String rSocialSecurity;

    /**
     * 是否签订劳动合同:radioGroup:[无,有]
     */
    @Column(name = "r_has_contract")
    private String rHasContract;

    /**
     * 获取ID:hidden
     *
     * @return r_id - ID:hidden
     */
    public Integer getrId() {
        return rId;
    }

    /**
     * 设置ID:hidden
     *
     * @param rId ID:hidden
     */
    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getrPersonId() {
        return rPersonId;
    }

    public void setrPersonId(Integer rPersonId) {
        this.rPersonId = rPersonId;
    }

    /**
     * 获取姓名
     *
     * @return r_name - 姓名
     */
    public String getrName() {
        return rName;
    }

    /**
     * 设置姓名
     *
     * @param rName 姓名
     */
    public void setrName(String rName) {
        this.rName = rName;
    }

    /**
     * 获取性别:radioGroup:[男,女]
     *
     * @return r_gender - 性别:radioGroup:[男,女]
     */
    public String getrGender() {
        return rGender;
    }

    /**
     * 设置性别:radioGroup:[男,女]
     *
     * @param rGender 性别:radioGroup:[男,女]
     */
    public void setrGender(String rGender) {
        this.rGender = rGender;
    }

    /**
     * 获取出生年月:date
     *
     * @return r_birth - 出生年月:date
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    public Date getrBirth() {
        return rBirth;
    }

    /**
     * 设置出生年月:date
     *
     * @param rBirth 出生年月:date
     */
    public void setrBirth(Date rBirth) {
        this.rBirth = rBirth;
    }

    /**
     * 获取身份证号
     *
     * @return r_identify_number - 身份证号
     */
    public String getrIdentifyNumber() {
        return rIdentifyNumber;
    }

    /**
     * 设置身份证号
     *
     * @param rIdentifyNumber 身份证号
     */
    public void setrIdentifyNumber(String rIdentifyNumber) {
        this.rIdentifyNumber = rIdentifyNumber;
    }

    /**
     * 获取民族
     *
     * @return r_nation - 民族
     */
    public String getrNation() {
        return rNation;
    }

    /**
     * 设置民族
     *
     * @param rNation 民族
     */
    public void setrNation(String rNation) {
        this.rNation = rNation;
    }

    /**
     * 获取政治面貌
     *
     * @return r_political_status - 政治面貌
     */
    public String getrPoliticalStatus() {
        return rPoliticalStatus;
    }

    /**
     * 设置政治面貌
     *
     * @param rPoliticalStatus 政治面貌
     */
    public void setrPoliticalStatus(String rPoliticalStatus) {
        this.rPoliticalStatus = rPoliticalStatus;
    }

    /**
     * 获取户籍类别
     *
     * @return r_census_type - 户籍类别
     */
    public String getrCensusType() {
        return rCensusType;
    }

    /**
     * 设置户籍类别
     *
     * @param rCensusType 户籍类别
     */
    public void setrCensusType(String rCensusType) {
        this.rCensusType = rCensusType;
    }

    /**
     * 获取户籍地址
     *
     * @return r_census_address - 户籍地址
     */
    public String getrCensusAddress() {
        return rCensusAddress;
    }

    /**
     * 设置户籍地址
     *
     * @param rCensusAddress 户籍地址
     */
    public void setrCensusAddress(String rCensusAddress) {
        this.rCensusAddress = rCensusAddress;
    }

    /**
     * 获取出生地
     *
     * @return r_born_place - 出生地
     */
    public String getrBornPlace() {
        return rBornPlace;
    }

    /**
     * 设置出生地
     *
     * @param rBornPlace 出生地
     */
    public void setrBornPlace(String rBornPlace) {
        this.rBornPlace = rBornPlace;
    }

    /**
     * 获取居住地
     *
     * @return r_residence_place - 居住地
     */
    public String getrResidencePlace() {
        return rResidencePlace;
    }

    /**
     * 设置居住地
     *
     * @param rResidencePlace 居住地
     */
    public void setrResidencePlace(String rResidencePlace) {
        this.rResidencePlace = rResidencePlace;
    }

    /**
     * 获取婚姻状况
     *
     * @return r_marriage_status - 婚姻状况
     */
    public String getrMarriageStatus() {
        return rMarriageStatus;
    }

    /**
     * 设置婚姻状况
     *
     * @param rMarriageStatus 婚姻状况
     */
    public void setrMarriageStatus(String rMarriageStatus) {
        this.rMarriageStatus = rMarriageStatus;
    }

    /**
     * 获取联系电话
     *
     * @return r_contact - 联系电话
     */
    public String getrContact() {
        return rContact;
    }

    /**
     * 设置联系电话
     *
     * @param rContact 联系电话
     */
    public void setrContact(String rContact) {
        this.rContact = rContact;
    }

    /**
     * 获取是否家庭流入:radioGroup:[是,否]
     *
     * @return r_is_family_in - 是否家庭流入:radioGroup:[是,否]
     */
    public String getrIsFamilyIn() {
        return rIsFamilyIn;
    }

    /**
     * 设置是否家庭流入:radioGroup:[是,否]
     *
     * @param rIsFamilyIn 是否家庭流入:radioGroup:[是,否]
     */
    public void setrIsFamilyIn(String rIsFamilyIn) {
        this.rIsFamilyIn = rIsFamilyIn;
    }

    /**
     * 获取流入人数
     *
     * @return r_family_in_num - 流入人数
     */
    public Short getrFamilyInNum() {
        return rFamilyInNum;
    }

    /**
     * 设置流入人数
     *
     * @param rFamilyInNum 流入人数
     */
    public void setrFamilyInNum(Short rFamilyInNum) {
        this.rFamilyInNum = rFamilyInNum;
    }

    /**
     * 获取16岁以下男性人数
     *
     * @return r_family_in_lt_sixteen_male - 16岁以下男性人数
     */
    public Short getrFamilyInLtSixteenMale() {
        return rFamilyInLtSixteenMale;
    }

    /**
     * 设置16岁以下男性人数
     *
     * @param rFamilyInLtSixteenMale 16岁以下男性人数
     */
    public void setrFamilyInLtSixteenMale(Short rFamilyInLtSixteenMale) {
        this.rFamilyInLtSixteenMale = rFamilyInLtSixteenMale;
    }

    /**
     * 获取16岁以下女性人数
     *
     * @return r_family_in_lt_sixteen_female - 16岁以下女性人数
     */
    public Short getrFamilyInLtSixteenFemale() {
        return rFamilyInLtSixteenFemale;
    }

    /**
     * 设置16岁以下女性人数
     *
     * @param rFamilyInLtSixteenFemale 16岁以下女性人数
     */
    public void setrFamilyInLtSixteenFemale(Short rFamilyInLtSixteenFemale) {
        this.rFamilyInLtSixteenFemale = rFamilyInLtSixteenFemale;
    }

    /**
     * 获取是否户主:radioGroup:[是,否]
     *
     * @return r_is_owner - 是否户主:radioGroup:[是,否]
     */
    public String getrIsOwner() {
        return rIsOwner;
    }

    /**
     * 设置是否户主:radioGroup:[是,否]
     *
     * @param rIsOwner 是否户主:radioGroup:[是,否]
     */
    public void setrIsOwner(String rIsOwner) {
        this.rIsOwner = rIsOwner;
    }

    /**
     * 获取户主名称
     *
     * @return r_owner_name - 户主名称
     */
    public String getrOwnerName() {
        return rOwnerName;
    }

    /**
     * 设置户主名称
     *
     * @param rOwnerName 户主名称
     */
    public void setrOwnerName(String rOwnerName) {
        this.rOwnerName = rOwnerName;
    }

    /**
     * 获取与户主关系
     *
     * @return r_owner_relate - 与户主关系
     */
    public String getrOwnerRelate() {
        return rOwnerRelate;
    }

    /**
     * 设置与户主关系
     *
     * @param rOwnerRelate 与户主关系
     */
    public void setrOwnerRelate(String rOwnerRelate) {
        this.rOwnerRelate = rOwnerRelate;
    }

    /**
     * 获取离开原籍日期:date
     *
     * @return r_leave_hometown_date - 离开原籍日期:date
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    public Date getrLeaveHometownDate() {
        return rLeaveHometownDate;
    }

    /**
     * 设置离开原籍日期:date
     *
     * @param rLeaveHometownDate 离开原籍日期:date
     */
    public void setrLeaveHometownDate(Date rLeaveHometownDate) {
        this.rLeaveHometownDate = rLeaveHometownDate;
    }

    /**
     * 获取来京日期:date
     *
     * @return r_enter_beijing_date - 来京日期:date
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    public Date getrEnterBeijingDate() {
        return rEnterBeijingDate;
    }

    /**
     * 设置来京日期:date
     *
     * @param rEnterBeijingDate 来京日期:date
     */
    public void setrEnterBeijingDate(Date rEnterBeijingDate) {
        this.rEnterBeijingDate = rEnterBeijingDate;
    }

    /**
     * 获取来居住地日期:date
     *
     * @return r_enter_residence_date - 来居住地日期:date
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    public Date getrEnterResidenceDate() {
        return rEnterResidenceDate;
    }

    /**
     * 设置来居住地日期:date
     *
     * @param rEnterResidenceDate 来居住地日期:date
     */
    public void setrEnterResidenceDate(Date rEnterResidenceDate) {
        this.rEnterResidenceDate = rEnterResidenceDate;
    }

    /**
     * 获取来京原因
     *
     * @return r_enter_beijing_resion - 来京原因
     */
    public String getrEnterBeijingResion() {
        return rEnterBeijingResion;
    }

    /**
     * 设置来京原因
     *
     * @param rEnterBeijingResion 来京原因
     */
    public void setrEnterBeijingResion(String rEnterBeijingResion) {
        this.rEnterBeijingResion = rEnterBeijingResion;
    }

    /**
     * 获取居住类型
     *
     * @return r_residence_type - 居住类型
     */
    public String getrResidenceType() {
        return rResidenceType;
    }

    /**
     * 设置居住类型
     *
     * @param rResidenceType 居住类型
     */
    public void setrResidenceType(String rResidenceType) {
        this.rResidenceType = rResidenceType;
    }

    /**
     * 获取所属派出所
     *
     * @return r_police_station - 所属派出所
     */
    public String getrPoliceStation() {
        return rPoliceStation;
    }

    /**
     * 设置所属派出所
     *
     * @param rPoliceStation 所属派出所
     */
    public void setrPoliceStation(String rPoliceStation) {
        this.rPoliceStation = rPoliceStation;
    }

    /**
     * 获取民警
     *
     * @return r_police - 民警
     */
    public String getrPolice() {
        return rPolice;
    }

    /**
     * 设置民警
     *
     * @param rPolice 民警
     */
    public void setrPolice(String rPolice) {
        this.rPolice = rPolice;
    }

    /**
     * 获取房东名称
     *
     * @return r_household_name - 房东名称
     */
    public String getrHouseholdName() {
        return rHouseholdName;
    }

    /**
     * 设置房东名称
     *
     * @param rHouseholdName 房东名称
     */
    public void setrHouseholdName(String rHouseholdName) {
        this.rHouseholdName = rHouseholdName;
    }

    /**
     * 获取房东电话
     *
     * @return r_household_phone - 房东电话
     */
    public String getrHouseholdPhone() {
        return rHouseholdPhone;
    }

    /**
     * 设置房东电话
     *
     * @param rHouseholdPhone 房东电话
     */
    public void setrHouseholdPhone(String rHouseholdPhone) {
        this.rHouseholdPhone = rHouseholdPhone;
    }

    /**
     * 获取目前状况
     *
     * @return r_situation - 目前状况
     */
    public String getrSituation() {
        return rSituation;
    }

    /**
     * 设置目前状况
     *
     * @param rSituation 目前状况
     */
    public void setrSituation(String rSituation) {
        this.rSituation = rSituation;
    }

    /**
     * 获取就业单位/学校
     *
     * @return r_firm_or_school - 就业单位/学校
     */
    public String getrFirmOrSchool() {
        return rFirmOrSchool;
    }

    /**
     * 设置就业单位/学校
     *
     * @param rFirmOrSchool 就业单位/学校
     */
    public void setrFirmOrSchool(String rFirmOrSchool) {
        this.rFirmOrSchool = rFirmOrSchool;
    }

    /**
     * 获取单位地址
     *
     * @return r_firm_address - 单位地址
     */
    public String getrFirmAddress() {
        return rFirmAddress;
    }

    /**
     * 设置单位地址
     *
     * @param rFirmAddress 单位地址
     */
    public void setrFirmAddress(String rFirmAddress) {
        this.rFirmAddress = rFirmAddress;
    }

    /**
     * 获取单位所属行业:select:
     *
     * @return r_firm_industry - 单位所属行业:select:
     */
    public String getrFirmIndustry() {
        return rFirmIndustry;
    }

    /**
     * 设置单位所属行业:select:
     *
     * @param rFirmIndustry 单位所属行业:select:
     */
    public void setrFirmIndustry(String rFirmIndustry) {
        this.rFirmIndustry = rFirmIndustry;
    }

    /**
     * 获取主要从事工作
     *
     * @return r_main_job - 主要从事工作
     */
    public String getrMainJob() {
        return rMainJob;
    }

    /**
     * 设置主要从事工作
     *
     * @param rMainJob 主要从事工作
     */
    public void setrMainJob(String rMainJob) {
        this.rMainJob = rMainJob;
    }

    /**
     * 获取职业
     *
     * @return r_profession - 职业
     */
    public String getrProfession() {
        return rProfession;
    }

    /**
     * 设置职业
     *
     * @param rProfession 职业
     */
    public void setrProfession(String rProfession) {
        this.rProfession = rProfession;
    }

    /**
     * 获取社保:radioGroup:[无,工伤,医疗,失业,养老,生育]
     *
     * @return r_social_security - 社保:radioGroup:[无,工伤,医疗,失业,养老,生育]
     */
    public String getrSocialSecurity() {
        return rSocialSecurity;
    }

    /**
     * 设置社保:radioGroup:[无,工伤,医疗,失业,养老,生育]
     *
     * @param rSocialSecurity 社保:radioGroup:[无,工伤,医疗,失业,养老,生育]
     */
    public void setrSocialSecurity(String rSocialSecurity) {
        this.rSocialSecurity = rSocialSecurity;
    }

    /**
     * 获取是否签订劳动合同:radioGroup:[无,有]
     *
     * @return r_has_contract - 是否签订劳动合同:radioGroup:[无,有]
     */
    public String getrHasContract() {
        return rHasContract;
    }

    /**
     * 设置是否签订劳动合同:radioGroup:[无,有]
     *
     * @param rHasContract 是否签订劳动合同:radioGroup:[无,有]
     */
    public void setrHasContract(String rHasContract) {
        this.rHasContract = rHasContract;
    }
}
