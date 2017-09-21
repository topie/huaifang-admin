package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "d_repair_report_process")
public class RepairReportProcess {

    /**
     * ID:hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 报修ID:hidden
     */
    @Column(name = "report_id")
    private Integer reportId;

    @Column(name = "contact_user_id")
    private Integer contactUserId;

    /**
     * 联系人
     */
    @Column(name = "contact_person")
    private String contactPerson;

    /**
     * 联系人电话
     */
    @Column(name = "contact_phone")
    private String contactPhone;

    /**
     * 报修时间:datetime
     */
    @Column(name = "process_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date processTime;

    /**
     * 进度内容:textarea
     */
    @Column(name = "process_content")
    private String processContent;

    /**
     * 进度情况简介
     */
    @Column(name = "process_status")
    private String processStatus;

    /**
     * 状态:select:[维修中,已完成]
     */
    private String status;

    public Integer getContactUserId() {
        return contactUserId;
    }

    public void setContactUserId(Integer contactUserId) {
        this.contactUserId = contactUserId;
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
     * 获取报修ID:hidden
     *
     * @return report_id - 报修ID:hidden
     */
    public Integer getReportId() {
        return reportId;
    }

    /**
     * 设置报修ID:hidden
     *
     * @param reportId 报修ID:hidden
     */
    public void setReportId(Integer reportId) {
        this.reportId = reportId;
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
     * 获取联系人电话
     *
     * @return contact_phone - 联系人电话
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * 设置联系人电话
     *
     * @param contactPhone 联系人电话
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    /**
     * 获取报修时间:datetime
     *
     * @return process_time - 报修时间:datetime
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getProcessTime() {
        return processTime;
    }

    /**
     * 设置报修时间:datetime
     *
     * @param processTime 报修时间:datetime
     */
    public void setProcessTime(Date processTime) {
        this.processTime = processTime;
    }

    /**
     * 获取进度内容:textarea
     *
     * @return process_content - 进度内容:textarea
     */
    public String getProcessContent() {
        return processContent;
    }

    /**
     * 设置进度内容:textarea
     *
     * @param processContent 进度内容:textarea
     */
    public void setProcessContent(String processContent) {
        this.processContent = processContent;
    }

    /**
     * 获取进度情况简介
     *
     * @return process_status - 进度情况简介
     */
    public String getProcessStatus() {
        return processStatus;
    }

    /**
     * 设置进度情况简介
     *
     * @param processStatus 进度情况简介
     */
    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    /**
     * 获取状态:select:[维修中,已完成]
     *
     * @return status - 状态:select:[维修中,已完成]
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态:select:[维修中,已完成]
     *
     * @param status 状态:select:[维修中,已完成]
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
