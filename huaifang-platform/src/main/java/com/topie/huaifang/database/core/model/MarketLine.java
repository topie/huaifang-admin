package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "d_market_line")
public class MarketLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 类型0跳蚤市场1车位共享
     */
    private Integer type;

    /**
     * 添加用户ID
     */
    @Column(name = "add_user_id")
    private Integer addUserId;

    /**
     * 添加用户
     */
    @Column(name = "add_user_name")
    private String addUserName;

    /**
     * 用户头像
     */
    @Column(name = "head_image")
    private String headImage;

    /**
     * 联系电话
     */
    @Column(name = "contact_phone")
    private String contactPhone;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;

    /**
     * 发布时间
     */
    @Column(name = "publish_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishTime;

    /**
     * 发送内容
     */
    private String content;

    /**
     * 图片
     */
    private String images;

    /**
     * 状态0:草稿1：发布
     */
    private Integer status;

    /**
     * 感兴趣人数
     */
    @Column(name = "i_count")
    private Integer iCount;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取类型0跳蚤市场1车位共享
     *
     * @return type - 类型0跳蚤市场1车位共享
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型0跳蚤市场1车位共享
     *
     * @param type 类型0跳蚤市场1车位共享
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取添加用户ID
     *
     * @return add_user_id - 添加用户ID
     */
    public Integer getAddUserId() {
        return addUserId;
    }

    /**
     * 设置添加用户ID
     *
     * @param addUserId 添加用户ID
     */
    public void setAddUserId(Integer addUserId) {
        this.addUserId = addUserId;
    }

    /**
     * 获取添加用户
     *
     * @return add_user_name - 添加用户
     */
    public String getAddUserName() {
        return addUserName;
    }

    /**
     * 设置添加用户
     *
     * @param addUserName 添加用户
     */
    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName;
    }

    /**
     * 获取用户头像
     *
     * @return head_image - 用户头像
     */
    public String getHeadImage() {
        return headImage;
    }

    /**
     * 设置用户头像
     *
     * @param headImage 用户头像
     */
    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    /**
     * 获取联系电话
     *
     * @return contact_phone - 联系电话
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * 设置联系电话
     *
     * @param contactPhone 联系电话
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
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
     * 获取发布时间
     *
     * @return publish_time - 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * 设置发布时间
     *
     * @param publishTime 发布时间
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * 获取发送内容
     *
     * @return content - 发送内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置发送内容
     *
     * @param content 发送内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取图片
     *
     * @return images - 图片
     */
    public String getImages() {
        return images;
    }

    /**
     * 设置图片
     *
     * @param images 图片
     */
    public void setImages(String images) {
        this.images = images;
    }

    /**
     * 获取状态0:草稿1：发布
     *
     * @return status - 状态0:草稿1：发布
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态0:草稿1：发布
     *
     * @param status 状态0:草稿1：发布
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取感兴趣人数
     *
     * @return i_count - 感兴趣人数
     */
    public Integer getiCount() {
        return iCount;
    }

    /**
     * 设置感兴趣人数
     *
     * @param iCount 感兴趣人数
     */
    public void setiCount(Integer iCount) {
        this.iCount = iCount;
    }
}
