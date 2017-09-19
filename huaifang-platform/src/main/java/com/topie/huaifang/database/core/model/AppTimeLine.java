package com.topie.huaifang.database.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "d_app_time_line")
public class AppTimeLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
     * 添加时间
     */
    @Column(name = "add_time")
    private Date addTime;

    /**
     * 发布时间
     */
    @Column(name = "publish_time")
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
    private Short status;

    /**
     * 是否删除0否1是
     */
    @Column(name = "is_delete")
    private Byte isDelete;

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
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
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
    public Short getStatus() {
        return status;
    }

    /**
     * 设置状态0:草稿1：发布
     *
     * @param status 状态0:草稿1：发布
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取是否删除0否1是
     *
     * @return is_delete - 是否删除0否1是
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除0否1是
     *
     * @param isDelete 是否删除0否1是
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}