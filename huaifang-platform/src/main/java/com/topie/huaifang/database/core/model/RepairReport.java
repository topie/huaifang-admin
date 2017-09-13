package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "d_repair_report")
public class RepairReport {

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
     * 联系人电话
     */
    @Column(name = "contact_phone")
    private String contactPhone;

    /**
     * 房间号
     */
    @Column(name = "room_number")
    private String roomNumber;

    /**
     * 报修:datetime
     */
    @Column(name = "report_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reportTime;

    /**
     * 报修事项:textarea
     */
    @Column(name = "report_title")
    private String reportTitle;

    /**
     * 报修内容:textarea
     */
    @Column(name = "report_content")
    private String reportContent;

    /**
     * 图片1:image
     */
    @Column(name = "image_one")
    private String imageOne;

    /**
     * 图片2:image
     */
    @Column(name = "image_two")
    private String imageTwo;

    /**
     * 处理状态:skip
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
     * 获取房间号
     *
     * @return room_number - 房间号
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * 设置房间号
     *
     * @param roomNumber 房间号
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * 获取报修:datetime
     *
     * @return report_time - 报修:datetime
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getReportTime() {
        return reportTime;
    }

    /**
     * 设置报修:datetime
     *
     * @param reportTime 报修:datetime
     */
    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    /**
     * 获取报修事项:textarea
     *
     * @return report_title - 报修事项:textarea
     */
    public String getReportTitle() {
        return reportTitle;
    }

    /**
     * 设置报修事项:textarea
     *
     * @param reportTitle 报修事项:textarea
     */
    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    /**
     * 获取报修内容:textarea
     *
     * @return report_content - 报修内容:textarea
     */
    public String getReportContent() {
        return reportContent;
    }

    /**
     * 设置报修内容:textarea
     *
     * @param reportContent 报修内容:textarea
     */
    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    /**
     * 获取图片1:image
     *
     * @return image_one - 图片1:image
     */
    public String getImageOne() {
        return imageOne;
    }

    /**
     * 设置图片1:image
     *
     * @param imageOne 图片1:image
     */
    public void setImageOne(String imageOne) {
        this.imageOne = imageOne;
    }

    /**
     * 获取图片2:image
     *
     * @return image_two - 图片2:image
     */
    public String getImageTwo() {
        return imageTwo;
    }

    /**
     * 设置图片2:image
     *
     * @param imageTwo 图片2:image
     */
    public void setImageTwo(String imageTwo) {
        this.imageTwo = imageTwo;
    }

    /**
     * 获取处理状态:skip
     *
     * @return status - 处理状态:skip
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置处理状态:skip
     *
     * @param status 处理状态:skip
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
