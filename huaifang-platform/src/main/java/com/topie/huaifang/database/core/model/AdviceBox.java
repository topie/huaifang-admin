package com.topie.huaifang.database.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "d_advice_box")
public class AdviceBox {
    /**
     * ID:hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 联系人
     */
    @Column(name = "contact_person")
    private String contactPerson;

    /**
     * 联系电话
     */
    @Column(name = "contact_phone")
    private String contactPhone;

    /**
     * 联系邮箱
     */
    @Column(name = "concat_email")
    private String concatEmail;

    /**
     * 留言内容:textare
     */
    @Column(name = "message_content")
    private String messageContent;

    /**
     * 留言时间:datetime
     */
    @Column(name = "message_time")
    private Date messageTime;

    /**
     * 处理人
     */
    @Column(name = "handle_person")
    private String handlePerson;

    /**
     * 处理方式:select:[电话回访,直接回复,其它]
     */
    @Column(name = "handle_type")
    private String handleType;

    /**
     * 处理描述:textare
     */
    @Column(name = "handle_desc")
    private String handleDesc;

    /**
     * 状态:skip
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
     * 获取联系人
     *
     * @return contact_person - 联系人
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * 设置联系人
     *
     * @param contactPerson 联系人
     */
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
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
     * 获取联系邮箱
     *
     * @return concat_email - 联系邮箱
     */
    public String getConcatEmail() {
        return concatEmail;
    }

    /**
     * 设置联系邮箱
     *
     * @param concatEmail 联系邮箱
     */
    public void setConcatEmail(String concatEmail) {
        this.concatEmail = concatEmail;
    }

    /**
     * 获取留言内容:textare
     *
     * @return message_content - 留言内容:textare
     */
    public String getMessageContent() {
        return messageContent;
    }

    /**
     * 设置留言内容:textare
     *
     * @param messageContent 留言内容:textare
     */
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    /**
     * 获取留言时间:datetime
     *
     * @return message_time - 留言时间:datetime
     */
    public Date getMessageTime() {
        return messageTime;
    }

    /**
     * 设置留言时间:datetime
     *
     * @param messageTime 留言时间:datetime
     */
    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    /**
     * 获取处理人
     *
     * @return handle_person - 处理人
     */
    public String getHandlePerson() {
        return handlePerson;
    }

    /**
     * 设置处理人
     *
     * @param handlePerson 处理人
     */
    public void setHandlePerson(String handlePerson) {
        this.handlePerson = handlePerson;
    }

    /**
     * 获取处理方式:select:[电话回访,直接回复,其它]
     *
     * @return handle_type - 处理方式:select:[电话回访,直接回复,其它]
     */
    public String getHandleType() {
        return handleType;
    }

    /**
     * 设置处理方式:select:[电话回访,直接回复,其它]
     *
     * @param handleType 处理方式:select:[电话回访,直接回复,其它]
     */
    public void setHandleType(String handleType) {
        this.handleType = handleType;
    }

    /**
     * 获取处理描述:textare
     *
     * @return handle_desc - 处理描述:textare
     */
    public String getHandleDesc() {
        return handleDesc;
    }

    /**
     * 设置处理描述:textare
     *
     * @param handleDesc 处理描述:textare
     */
    public void setHandleDesc(String handleDesc) {
        this.handleDesc = handleDesc;
    }

    /**
     * 获取状态:skip
     *
     * @return status - 状态:skip
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态:skip
     *
     * @param status 状态:skip
     */
    public void setStatus(String status) {
        this.status = status;
    }
}