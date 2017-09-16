package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "d_questionnaire_info")
public class QuestionnaireInfo {

    /**
     * ID:hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 问卷调查名称
     */
    private String name;

    /**
     * 问卷调查详细
     */
    private String detail;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date begin;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date end;

    /**
     * 添加用户
     */
    @Column(name = "add_user")
    private String addUser;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;

    /**
     * 状态:select:[未发布,已发布,已回收]
     */
    private String status;

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
     * 获取问卷调查名称
     *
     * @return name - 问卷调查名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置问卷调查名称
     *
     * @param name 问卷调查名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取问卷调查详细
     *
     * @return detail - 问卷调查详细
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置问卷调查详细
     *
     * @param detail 问卷调查详细
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * 获取开始时间
     *
     * @return begin - 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getBegin() {
        return begin;
    }

    /**
     * 设置开始时间
     *
     * @param begin 开始时间
     */
    public void setBegin(Date begin) {
        this.begin = begin;
    }

    /**
     * 获取结束时间
     *
     * @return end - 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getEnd() {
        return end;
    }

    /**
     * 设置结束时间
     *
     * @param end 结束时间
     */
    public void setEnd(Date end) {
        this.end = end;
    }

    /**
     * 获取添加用户
     *
     * @return add_user - 添加用户
     */
    public String getAddUser() {
        return addUser;
    }

    /**
     * 设置添加用户
     *
     * @param addUser 添加用户
     */
    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置添加时间
     *
     * @param addTime 添加时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取状态:select:[未发布,已发布,已回收]
     *
     * @return status - 状态:select:[未发布,已发布,已回收]
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态:select:[未发布,已发布,已回收]
     *
     * @param status 状态:select:[未发布,已发布,已回收]
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
