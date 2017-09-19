package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "d_house_info")
public class HouseInfo {

    /**
     * 房屋id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 架构id
     */
    @Column(name = "house_node_id")
    private Integer houseNodeId;

    /**
     * 房屋编号
     */
    @Column(name = "house_no")
    private String houseNo;

    /**
     * 房屋地址
     */
    private String address;

    /**
     * 房产证号
     */
    private String fczh;

    /**
     * 房屋类型
     */
    @Column(name = "house_type")
    private String houseType;

    /**
     * 群租房类型
     */
    @Column(name = "qzf_type")
    private String qzfType;

    /**
     * 建筑性质
     */
    private String jzxz;

    /**
     * 建筑类型
     */
    @Column(name = "jz_type")
    private String jzType;

    /**
     * 所属派出所
     */
    @Column(name = "police_station")
    private String policeStation;

    /**
     * 社区民警
     */
    private String police;

    /**
     * 所有权类型:radio:[个人,单位,违法建设]
     */
    @Column(name = "owner_type")
    private String ownerType;

    /**
     * 有无安全隐患
     */
    @Column(name = "house_has_danger")
    private String houseHasDanger;

    /**
     * 房主名称
     */
    @Column(name = "owner_name")
    private String ownerName;

    /**
     * 房主性别
     */
    @Column(name = "owner_gender")
    private String ownerGender;

    /**
     * 房主证件类型:select:[身份证,护照,港澳通行证]
     */
    @Column(name = "owner_zhenjian_type")
    private String ownerZhenjianType;

    /**
     * 房主证件号码
     */
    @Column(name = "owner_zhengjian_no")
    private String ownerZhengjianNo;

    /**
     * 房主户籍地
     */
    @Column(name = "owner_huji_type")
    private String ownerHujiType;

    /**
     * 房主户籍地址
     */
    @Column(name = "owner_huji_address")
    private String ownerHujiAddress;

    /**
     * 房主现住地址
     */
    @Column(name = "owner_live_address")
    private String ownerLiveAddress;

    /**
     * 房主联系电话
     */
    @Column(name = "owner_phone")
    private String ownerPhone;

    /**
     * 房主国籍
     */
    @Column(name = "owner_country")
    private String ownerCountry;

    /**
     * 单位名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 单位所在地址
     */
    @Column(name = "company_address")
    private String companyAddress;

    /**
     * 单位负责人名称
     */
    @Column(name = "company_manager_name")
    private String companyManagerName;

    /**
     * 单位负责人联系电话
     */
    @Column(name = "company_manager_phone")
    private String companyManagerPhone;

    /**
     * 中介名称
     */
    @Column(name = "zhongjie_name")
    private String zhongjieName;

    /**
     * 中介负责人名称
     */
    @Column(name = "zhongjie_manager_name")
    private String zhongjieManagerName;

    /**
     * 中介负责人联系电话
     */
    @Column(name = "zhongjie_manager_phone")
    private String zhongjieManagerPhone;

    /**
     * 中介负责人证件号码
     */
    @Column(name = "zhongjie_manager_id_no")
    private String zhongjieManagerIdNo;

    /**
     * 转租人名称
     */
    @Column(name = "zhuanzu_name")
    private String zhuanzuName;

    /**
     * 转租人现住地址
     */
    @Column(name = "zhuanzu_live_address")
    private String zhuanzuLiveAddress;

    /**
     * 转租人联系电话
     */
    @Column(name = "zhuanzu_phone")
    private String zhuanzuPhone;

    /**
     * 转租人证件类型:select:[身份证,护照,港澳通行证]
     */
    @Column(name = "zhuanzu_id_type")
    private String zhuanzuIdType;

    /**
     * 转租人证件号码
     */
    @Column(name = "zhuanzu_id_no")
    private String zhuanzuIdNo;

    /**
     * 出租人类型
     */
    @Column(name = "rent_type")
    private String rentType;

    /**
     * 出租间数
     */
    @Column(name = "rent_number")
    private Integer rentNumber;

    /**
     * 出租面积(m2)
     */
    @Column(name = "rent_area")
    private BigDecimal rentArea;

    /**
     * 出租用途
     */
    @Column(name = "rent_useage")
    private String rentUseage;

    /**
     * 现住人数
     */
    @Column(name = "rent_live_number")
    private Integer rentLiveNumber;

    /**
     * 租金支付方式:radio:[月租,年租]
     */
    @Column(name = "rent_pay_type")
    private String rentPayType;

    /**
     * 租金（元）
     */
    @Column(name = "rent_money")
    private BigDecimal rentMoney;

    /**
     * 登记备案:radio:[已办,未办]
     */
    private String dengjibeian;

    /**
     * 登记备案:radio:[已缴,未缴]
     */
    private String nashui;

    /**
     * 责任书:checkbox:[治安,消防,婚育]
     */
    private String zerenbook;

    /**
     * 租赁合同:radio:[有,无]
     */
    private String hetong;

    /**
     * 出租起始日期
     */
    @Column(name = "rent_begin")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date rentBegin;

    /**
     * 出租截止日期
     */
    @Column(name = "rent_end")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date rentEnd;

    /**
     * 安全隐患描述
     */
    @Column(name = "danger_detail")
    private String dangerDetail;

    /**
     * 获取房屋id
     *
     * @return id - 房屋id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置房屋id
     *
     * @param id 房屋id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取架构id
     *
     * @return house_node_id - 架构id
     */
    public Integer getHouseNodeId() {
        return houseNodeId;
    }

    /**
     * 设置架构id
     *
     * @param houseNodeId 架构id
     */
    public void setHouseNodeId(Integer houseNodeId) {
        this.houseNodeId = houseNodeId;
    }

    /**
     * 获取房屋编号
     *
     * @return house_no - 房屋编号
     */
    public String getHouseNo() {
        return houseNo;
    }

    /**
     * 设置房屋编号
     *
     * @param houseNo 房屋编号
     */
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    /**
     * 获取房屋地址
     *
     * @return address - 房屋地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置房屋地址
     *
     * @param address 房屋地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取房产证号
     *
     * @return fczh - 房产证号
     */
    public String getFczh() {
        return fczh;
    }

    /**
     * 设置房产证号
     *
     * @param fczh 房产证号
     */
    public void setFczh(String fczh) {
        this.fczh = fczh;
    }

    /**
     * 获取房屋类型
     *
     * @return house_type - 房屋类型
     */
    public String getHouseType() {
        return houseType;
    }

    /**
     * 设置房屋类型
     *
     * @param houseType 房屋类型
     */
    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    /**
     * 获取群租房类型
     *
     * @return qzf_type - 群租房类型
     */
    public String getQzfType() {
        return qzfType;
    }

    /**
     * 设置群租房类型
     *
     * @param qzfType 群租房类型
     */
    public void setQzfType(String qzfType) {
        this.qzfType = qzfType;
    }

    /**
     * 获取建筑性质
     *
     * @return jzxz - 建筑性质
     */
    public String getJzxz() {
        return jzxz;
    }

    /**
     * 设置建筑性质
     *
     * @param jzxz 建筑性质
     */
    public void setJzxz(String jzxz) {
        this.jzxz = jzxz;
    }

    /**
     * 获取建筑类型
     *
     * @return jz_type - 建筑类型
     */
    public String getJzType() {
        return jzType;
    }

    /**
     * 设置建筑类型
     *
     * @param jzType 建筑类型
     */
    public void setJzType(String jzType) {
        this.jzType = jzType;
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
     * 获取社区民警
     *
     * @return police - 社区民警
     */
    public String getPolice() {
        return police;
    }

    /**
     * 设置社区民警
     *
     * @param police 社区民警
     */
    public void setPolice(String police) {
        this.police = police;
    }

    /**
     * 获取所有权类型:radio:[个人,单位,违法建设]
     *
     * @return owner_type - 所有权类型:radio:[个人,单位,违法建设]
     */
    public String getOwnerType() {
        return ownerType;
    }

    /**
     * 设置所有权类型:radio:[个人,单位,违法建设]
     *
     * @param ownerType 所有权类型:radio:[个人,单位,违法建设]
     */
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    /**
     * 获取有无安全隐患
     *
     * @return house_has_danger - 有无安全隐患
     */
    public String getHouseHasDanger() {
        return houseHasDanger;
    }

    /**
     * 设置有无安全隐患
     *
     * @param houseHasDanger 有无安全隐患
     */
    public void setHouseHasDanger(String houseHasDanger) {
        this.houseHasDanger = houseHasDanger;
    }

    /**
     * 获取房主名称
     *
     * @return owner_name - 房主名称
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * 设置房主名称
     *
     * @param ownerName 房主名称
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * 获取房主性别
     *
     * @return owner_gender - 房主性别
     */
    public String getOwnerGender() {
        return ownerGender;
    }

    /**
     * 设置房主性别
     *
     * @param ownerGender 房主性别
     */
    public void setOwnerGender(String ownerGender) {
        this.ownerGender = ownerGender;
    }

    /**
     * 获取房主证件类型:select:[身份证,护照,港澳通行证]
     *
     * @return owner_zhenjian_type - 房主证件类型:select:[身份证,护照,港澳通行证]
     */
    public String getOwnerZhenjianType() {
        return ownerZhenjianType;
    }

    /**
     * 设置房主证件类型:select:[身份证,护照,港澳通行证]
     *
     * @param ownerZhenjianType 房主证件类型:select:[身份证,护照,港澳通行证]
     */
    public void setOwnerZhenjianType(String ownerZhenjianType) {
        this.ownerZhenjianType = ownerZhenjianType;
    }

    /**
     * 获取房主证件号码
     *
     * @return owner_zhengjian_no - 房主证件号码
     */
    public String getOwnerZhengjianNo() {
        return ownerZhengjianNo;
    }

    /**
     * 设置房主证件号码
     *
     * @param ownerZhengjianNo 房主证件号码
     */
    public void setOwnerZhengjianNo(String ownerZhengjianNo) {
        this.ownerZhengjianNo = ownerZhengjianNo;
    }

    /**
     * 获取房主户籍地
     *
     * @return owner_huji_type - 房主户籍地
     */
    public String getOwnerHujiType() {
        return ownerHujiType;
    }

    /**
     * 设置房主户籍地
     *
     * @param ownerHujiType 房主户籍地
     */
    public void setOwnerHujiType(String ownerHujiType) {
        this.ownerHujiType = ownerHujiType;
    }

    /**
     * 获取房主户籍地址
     *
     * @return owner_huji_address - 房主户籍地址
     */
    public String getOwnerHujiAddress() {
        return ownerHujiAddress;
    }

    /**
     * 设置房主户籍地址
     *
     * @param ownerHujiAddress 房主户籍地址
     */
    public void setOwnerHujiAddress(String ownerHujiAddress) {
        this.ownerHujiAddress = ownerHujiAddress;
    }

    /**
     * 获取房主现住地址
     *
     * @return owner_live_address - 房主现住地址
     */
    public String getOwnerLiveAddress() {
        return ownerLiveAddress;
    }

    /**
     * 设置房主现住地址
     *
     * @param ownerLiveAddress 房主现住地址
     */
    public void setOwnerLiveAddress(String ownerLiveAddress) {
        this.ownerLiveAddress = ownerLiveAddress;
    }

    /**
     * 获取房主联系电话
     *
     * @return owner_phone - 房主联系电话
     */
    public String getOwnerPhone() {
        return ownerPhone;
    }

    /**
     * 设置房主联系电话
     *
     * @param ownerPhone 房主联系电话
     */
    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    /**
     * 获取房主国籍
     *
     * @return owner_country - 房主国籍
     */
    public String getOwnerCountry() {
        return ownerCountry;
    }

    /**
     * 设置房主国籍
     *
     * @param ownerCountry 房主国籍
     */
    public void setOwnerCountry(String ownerCountry) {
        this.ownerCountry = ownerCountry;
    }

    /**
     * 获取单位名称
     *
     * @return company_name - 单位名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置单位名称
     *
     * @param companyName 单位名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取单位所在地址
     *
     * @return company_address - 单位所在地址
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * 设置单位所在地址
     *
     * @param companyAddress 单位所在地址
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    /**
     * 获取单位负责人名称
     *
     * @return company_manager_name - 单位负责人名称
     */
    public String getCompanyManagerName() {
        return companyManagerName;
    }

    /**
     * 设置单位负责人名称
     *
     * @param companyManagerName 单位负责人名称
     */
    public void setCompanyManagerName(String companyManagerName) {
        this.companyManagerName = companyManagerName;
    }

    /**
     * 获取单位负责人联系电话
     *
     * @return company_manager_phone - 单位负责人联系电话
     */
    public String getCompanyManagerPhone() {
        return companyManagerPhone;
    }

    /**
     * 设置单位负责人联系电话
     *
     * @param companyManagerPhone 单位负责人联系电话
     */
    public void setCompanyManagerPhone(String companyManagerPhone) {
        this.companyManagerPhone = companyManagerPhone;
    }

    /**
     * 获取中介名称
     *
     * @return zhongjie_name - 中介名称
     */
    public String getZhongjieName() {
        return zhongjieName;
    }

    /**
     * 设置中介名称
     *
     * @param zhongjieName 中介名称
     */
    public void setZhongjieName(String zhongjieName) {
        this.zhongjieName = zhongjieName;
    }

    /**
     * 获取中介负责人名称
     *
     * @return zhongjie_manager_name - 中介负责人名称
     */
    public String getZhongjieManagerName() {
        return zhongjieManagerName;
    }

    /**
     * 设置中介负责人名称
     *
     * @param zhongjieManagerName 中介负责人名称
     */
    public void setZhongjieManagerName(String zhongjieManagerName) {
        this.zhongjieManagerName = zhongjieManagerName;
    }

    /**
     * 获取中介负责人联系电话
     *
     * @return zhongjie_manager_phone - 中介负责人联系电话
     */
    public String getZhongjieManagerPhone() {
        return zhongjieManagerPhone;
    }

    /**
     * 设置中介负责人联系电话
     *
     * @param zhongjieManagerPhone 中介负责人联系电话
     */
    public void setZhongjieManagerPhone(String zhongjieManagerPhone) {
        this.zhongjieManagerPhone = zhongjieManagerPhone;
    }

    /**
     * 获取中介负责人证件号码
     *
     * @return zhongjie_manager_id_no - 中介负责人证件号码
     */
    public String getZhongjieManagerIdNo() {
        return zhongjieManagerIdNo;
    }

    /**
     * 设置中介负责人证件号码
     *
     * @param zhongjieManagerIdNo 中介负责人证件号码
     */
    public void setZhongjieManagerIdNo(String zhongjieManagerIdNo) {
        this.zhongjieManagerIdNo = zhongjieManagerIdNo;
    }

    /**
     * 获取转租人名称
     *
     * @return zhuanzu_name - 转租人名称
     */
    public String getZhuanzuName() {
        return zhuanzuName;
    }

    /**
     * 设置转租人名称
     *
     * @param zhuanzuName 转租人名称
     */
    public void setZhuanzuName(String zhuanzuName) {
        this.zhuanzuName = zhuanzuName;
    }

    /**
     * 获取转租人现住地址
     *
     * @return zhuanzu_live_address - 转租人现住地址
     */
    public String getZhuanzuLiveAddress() {
        return zhuanzuLiveAddress;
    }

    /**
     * 设置转租人现住地址
     *
     * @param zhuanzuLiveAddress 转租人现住地址
     */
    public void setZhuanzuLiveAddress(String zhuanzuLiveAddress) {
        this.zhuanzuLiveAddress = zhuanzuLiveAddress;
    }

    /**
     * 获取转租人联系电话
     *
     * @return zhuanzu_phone - 转租人联系电话
     */
    public String getZhuanzuPhone() {
        return zhuanzuPhone;
    }

    /**
     * 设置转租人联系电话
     *
     * @param zhuanzuPhone 转租人联系电话
     */
    public void setZhuanzuPhone(String zhuanzuPhone) {
        this.zhuanzuPhone = zhuanzuPhone;
    }

    /**
     * 获取转租人证件类型:select:[身份证,护照,港澳通行证]
     *
     * @return zhuanzu_id_type - 转租人证件类型:select:[身份证,护照,港澳通行证]
     */
    public String getZhuanzuIdType() {
        return zhuanzuIdType;
    }

    /**
     * 设置转租人证件类型:select:[身份证,护照,港澳通行证]
     *
     * @param zhuanzuIdType 转租人证件类型:select:[身份证,护照,港澳通行证]
     */
    public void setZhuanzuIdType(String zhuanzuIdType) {
        this.zhuanzuIdType = zhuanzuIdType;
    }

    /**
     * 获取转租人证件号码
     *
     * @return zhuanzu_id_no - 转租人证件号码
     */
    public String getZhuanzuIdNo() {
        return zhuanzuIdNo;
    }

    /**
     * 设置转租人证件号码
     *
     * @param zhuanzuIdNo 转租人证件号码
     */
    public void setZhuanzuIdNo(String zhuanzuIdNo) {
        this.zhuanzuIdNo = zhuanzuIdNo;
    }

    /**
     * 获取出租人类型
     *
     * @return rent_type - 出租人类型
     */
    public String getRentType() {
        return rentType;
    }

    /**
     * 设置出租人类型
     *
     * @param rentType 出租人类型
     */
    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    /**
     * 获取出租间数
     *
     * @return rent_number - 出租间数
     */
    public Integer getRentNumber() {
        return rentNumber;
    }

    /**
     * 设置出租间数
     *
     * @param rentNumber 出租间数
     */
    public void setRentNumber(Integer rentNumber) {
        this.rentNumber = rentNumber;
    }

    /**
     * 获取出租面积(m2)
     *
     * @return rent_area - 出租面积(m2)
     */
    public BigDecimal getRentArea() {
        return rentArea;
    }

    /**
     * 设置出租面积(m2)
     *
     * @param rentArea 出租面积(m2)
     */
    public void setRentArea(BigDecimal rentArea) {
        this.rentArea = rentArea;
    }

    /**
     * 获取出租用途
     *
     * @return rent_useage - 出租用途
     */
    public String getRentUseage() {
        return rentUseage;
    }

    /**
     * 设置出租用途
     *
     * @param rentUseage 出租用途
     */
    public void setRentUseage(String rentUseage) {
        this.rentUseage = rentUseage;
    }

    /**
     * 获取现住人数
     *
     * @return rent_live_number - 现住人数
     */
    public Integer getRentLiveNumber() {
        return rentLiveNumber;
    }

    /**
     * 设置现住人数
     *
     * @param rentLiveNumber 现住人数
     */
    public void setRentLiveNumber(Integer rentLiveNumber) {
        this.rentLiveNumber = rentLiveNumber;
    }

    /**
     * 获取租金支付方式:radio:[月租,年租]
     *
     * @return rent_pay_type - 租金支付方式:radio:[月租,年租]
     */
    public String getRentPayType() {
        return rentPayType;
    }

    /**
     * 设置租金支付方式:radio:[月租,年租]
     *
     * @param rentPayType 租金支付方式:radio:[月租,年租]
     */
    public void setRentPayType(String rentPayType) {
        this.rentPayType = rentPayType;
    }

    /**
     * 获取租金（元）
     *
     * @return rent_money - 租金（元）
     */
    public BigDecimal getRentMoney() {
        return rentMoney;
    }

    /**
     * 设置租金（元）
     *
     * @param rentMoney 租金（元）
     */
    public void setRentMoney(BigDecimal rentMoney) {
        this.rentMoney = rentMoney;
    }

    /**
     * 获取登记备案:radio:[已办,未办]
     *
     * @return dengjibeian - 登记备案:radio:[已办,未办]
     */
    public String getDengjibeian() {
        return dengjibeian;
    }

    /**
     * 设置登记备案:radio:[已办,未办]
     *
     * @param dengjibeian 登记备案:radio:[已办,未办]
     */
    public void setDengjibeian(String dengjibeian) {
        this.dengjibeian = dengjibeian;
    }

    /**
     * 获取登记备案:radio:[已缴,未缴]
     *
     * @return nashui - 登记备案:radio:[已缴,未缴]
     */
    public String getNashui() {
        return nashui;
    }

    /**
     * 设置登记备案:radio:[已缴,未缴]
     *
     * @param nashui 登记备案:radio:[已缴,未缴]
     */
    public void setNashui(String nashui) {
        this.nashui = nashui;
    }

    /**
     * 获取责任书:checkbox:[治安,消防,婚育]
     *
     * @return zerenbook - 责任书:checkbox:[治安,消防,婚育]
     */
    public String getZerenbook() {
        return zerenbook;
    }

    /**
     * 设置责任书:checkbox:[治安,消防,婚育]
     *
     * @param zerenbook 责任书:checkbox:[治安,消防,婚育]
     */
    public void setZerenbook(String zerenbook) {
        this.zerenbook = zerenbook;
    }

    /**
     * 获取租赁合同:radio:[有,无]
     *
     * @return hetong - 租赁合同:radio:[有,无]
     */
    public String getHetong() {
        return hetong;
    }

    /**
     * 设置租赁合同:radio:[有,无]
     *
     * @param hetong 租赁合同:radio:[有,无]
     */
    public void setHetong(String hetong) {
        this.hetong = hetong;
    }

    /**
     * 获取出租起始日期
     *
     * @return rent_begin - 出租起始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getRentBegin() {
        return rentBegin;
    }

    /**
     * 设置出租起始日期
     *
     * @param rentBegin 出租起始日期
     */
    public void setRentBegin(Date rentBegin) {
        this.rentBegin = rentBegin;
    }

    /**
     * 获取出租截止日期
     *
     * @return rent_end - 出租截止日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getRentEnd() {
        return rentEnd;
    }

    /**
     * 设置出租截止日期
     *
     * @param rentEnd 出租截止日期
     */
    public void setRentEnd(Date rentEnd) {
        this.rentEnd = rentEnd;
    }

    /**
     * 获取安全隐患描述
     *
     * @return danger_detail - 安全隐患描述
     */
    public String getDangerDetail() {
        return dangerDetail;
    }

    /**
     * 设置安全隐患描述
     *
     * @param dangerDetail 安全隐患描述
     */
    public void setDangerDetail(String dangerDetail) {
        this.dangerDetail = dangerDetail;
    }
}
