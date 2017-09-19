package com.topie.huaifang.database.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "d_app_user_message")
public class AppUserMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 发送用户ID
     */
    @Column(name = "from_user_id")
    private Integer fromUserId;

    /**
     * 接收用户ID
     */
    @Column(name = "to_user_id")
    private Integer toUserId;

    /**
     * 发送时间
     */
    @Column(name = "send_time")
    private Date sendTime;

    /**
     * 发送内容
     */
    private String content;

    /**
     * 是否已读0未读1已读
     */
    @Column(name = "is_read")
    private Byte isRead;

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
     * 获取发送用户ID
     *
     * @return from_user_id - 发送用户ID
     */
    public Integer getFromUserId() {
        return fromUserId;
    }

    /**
     * 设置发送用户ID
     *
     * @param fromUserId 发送用户ID
     */
    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    /**
     * 获取接收用户ID
     *
     * @return to_user_id - 接收用户ID
     */
    public Integer getToUserId() {
        return toUserId;
    }

    /**
     * 设置接收用户ID
     *
     * @param toUserId 接收用户ID
     */
    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    /**
     * 获取发送时间
     *
     * @return send_time - 发送时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 设置发送时间
     *
     * @param sendTime 发送时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
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
     * 获取是否已读0未读1已读
     *
     * @return is_read - 是否已读0未读1已读
     */
    public Byte getIsRead() {
        return isRead;
    }

    /**
     * 设置是否已读0未读1已读
     *
     * @param isRead 是否已读0未读1已读
     */
    public void setIsRead(Byte isRead) {
        this.isRead = isRead;
    }
}