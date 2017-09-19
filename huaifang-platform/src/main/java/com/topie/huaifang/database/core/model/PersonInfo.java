package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Integer id;

    /**
     * 人口身份:select:[租户,住户]
     */
    @Column(name = "person_type")
    private String personType;

    /**
     * 绑定架构id:hidden
     */
    @Column(name = "house_node_id")
    private Integer houseNodeId;

    /**
     * 绑定房屋信息:skip
     */
    @Column(name = "house_info")
    private String houseInfo;

    /**
     * 姓名
     */
    private String name;

    /**
     * 出生年月:date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    /**
     * 身份证号
     */
    @Column(name = "identify_number")
    private String identifyNumber;

    /**
     * 入库时间
     */
    @Column(name = "import_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date importTime;

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
     * 获取人口身份:select:[租户,住户]
     *
     * @return person_type - 人口身份:select:[租户,住户]
     */
    public String getPersonType() {
        return personType;
    }

    /**
     * 设置人口身份:select:[租户,住户]
     *
     * @param personType 人口身份:select:[租户,住户]
     */
    public void setPersonType(String personType) {
        this.personType = personType;
    }

    /**
     * 获取绑定架构id:hidden
     *
     * @return house_node_id - 绑定架构id:hidden
     */
    public Integer getHouseNodeId() {
        return houseNodeId;
    }

    /**
     * 设置绑定架构id:hidden
     *
     * @param houseNodeId 绑定架构id:hidden
     */
    public void setHouseNodeId(Integer houseNodeId) {
        this.houseNodeId = houseNodeId;
    }

    /**
     * 获取绑定房屋信息:skip
     *
     * @return house_info - 绑定房屋信息:skip
     */
    public String getHouseInfo() {
        return houseInfo;
    }

    /**
     * 设置绑定房屋信息:skip
     *
     * @param houseInfo 绑定房屋信息:skip
     */
    public void setHouseInfo(String houseInfo) {
        this.houseInfo = houseInfo;
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
     * 获取出生年月:date
     *
     * @return birth - 出生年月:date
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
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
     * 获取入库时间
     *
     * @return import_time - 入库时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getImportTime() {
        return importTime;
    }

    /**
     * 设置入库时间
     *
     * @param importTime 入库时间
     */
    public void setImportTime(Date importTime) {
        this.importTime = importTime;
    }
}
