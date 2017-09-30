package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "d_app_user")
public class AppUser {

    @Transient
    List<Integer> notInUserIds;

    /**
     * ID:hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 平台ID:hidden
     */
    @Column(name = "platform_id")
    private Integer platformId;

    /**
     * 手机
     */
    @Column(name = "mobile_phone")
    private String mobilePhone;

    /**
     * 密码:password
     */
    @JsonIgnore
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 姓名
     */
    private String realname;

    /**
     * 头像:image
     */
    @Column(name = "head_image")
    private String headImage;

    /**
     * 注册时间:datetime
     */
    @Column(name = "reg_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regTime;

    /**
     * 创建时间:datetime
     */
    @Column(name = "add_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;

    /**
     * 审核状态:select:[0#未认证,1#待审核,2#审核通过,3#审核不通过]
     */
    private Integer status;

    /**
     * 登录状态:select:[0#锁定,1#激活]
     */
    @Column(name = "login_status")
    private Integer loginStatus;

    @Transient
    private List<Integer> userIds;

    public List<Integer> getNotInUserIds() {
        return notInUserIds;
    }

    public void setNotInUserIds(List<Integer> notInUserIds) {
        this.notInUserIds = notInUserIds;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

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
     * 获取平台ID:hidden
     *
     * @return platform_id - 平台ID:hidden
     */
    public Integer getPlatformId() {
        return platformId;
    }

    /**
     * 设置平台ID:hidden
     *
     * @param platformId 平台ID:hidden
     */
    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    /**
     * 获取手机
     *
     * @return mobile_phone - 手机
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置手机
     *
     * @param mobilePhone 手机
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * 获取密码:password
     *
     * @return password - 密码:password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码:password
     *
     * @param password 密码:password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取姓名
     *
     * @return realname - 姓名
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置姓名
     *
     * @param realname 姓名
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * 获取头像:image
     *
     * @return head_image - 头像:image
     */
    public String getHeadImage() {
        return headImage;
    }

    /**
     * 设置头像:image
     *
     * @param headImage 头像:image
     */
    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    /**
     * 获取注册时间:datetime
     *
     * @return reg_time - 注册时间:datetime
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getRegTime() {
        return regTime;
    }

    /**
     * 设置注册时间:datetime
     *
     * @param regTime 注册时间:datetime
     */
    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    /**
     * 获取创建时间:datetime
     *
     * @return add_time - 创建时间:datetime
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置创建时间:datetime
     *
     * @param addTime 创建时间:datetime
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取审核状态:select:[0#未认证,1#待审核,2#审核通过,3#审核不通过]
     *
     * @return status - 审核状态:select:[0#未认证,1#待审核,2#审核通过,3#审核不通过]
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置审核状态:select:[0#未认证,1#待审核,2#审核通过,3#审核不通过]
     *
     * @param status 审核状态:select:[0#未认证,1#待审核,2#审核通过,3#审核不通过]
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取登录状态:select:[0#锁定,1#激活]
     *
     * @return login_status - 登录状态:select:[0#锁定,1#激活]
     */
    public Integer getLoginStatus() {
        return loginStatus;
    }

    /**
     * 设置登录状态:select:[0#锁定,1#激活]
     *
     * @param loginStatus 登录状态:select:[0#锁定,1#激活]
     */
    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }
}
