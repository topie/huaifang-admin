package com.topie.huaifang.database.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "d_app_message")
public class AppMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 类型0系统消息1好友消息
     */
    private Integer type;

    /**
     * 分类
     */
    private Integer category;

    /**
     * 标题
     */
    private String title;

    /**
     * 用户ID
     */
    @Column(name = "from_user_id")
    private Integer fromUserId;

    /**
     * 接收消息用户ID
     */
    @Column(name = "to_user_id")
    private Integer toUserId;

    /**
     * 图标
     */
    private String icon;

    /**
     * 添加时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 内容
     */
    private String content;

    /**
     * 是否已读0否1是
     */
    @Column(name = "is_read")
    private Integer isRead;

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
     * 获取类型0系统消息1好友消息
     *
     * @return type - 类型0系统消息1好友消息
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型0系统消息1好友消息
     *
     * @param type 类型0系统消息1好友消息
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取分类
     *
     * @return category - 分类
     */
    public Integer getCategory() {
        return category;
    }

    /**
     * 设置分类
     *
     * @param category 分类
     */
    public void setCategory(Integer category) {
        this.category = category;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取用户ID
     *
     * @return from_user_id - 用户ID
     */
    public Integer getFromUserId() {
        return fromUserId;
    }

    /**
     * 设置用户ID
     *
     * @param fromUserId 用户ID
     */
    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    /**
     * 获取接收消息用户ID
     *
     * @return to_user_id - 接收消息用户ID
     */
    public Integer getToUserId() {
        return toUserId;
    }

    /**
     * 设置接收消息用户ID
     *
     * @param toUserId 接收消息用户ID
     */
    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取添加时间
     *
     * @return create_time - 添加时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置添加时间
     *
     * @param createTime 添加时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取是否已读0否1是
     *
     * @return is_read - 是否已读0否1是
     */
    public Integer getIsRead() {
        return isRead;
    }

    /**
     * 设置是否已读0否1是
     *
     * @param isRead 是否已读0否1是
     */
    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }
}
