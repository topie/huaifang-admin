package com.topie.huaifang.database.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "d_dispute_resolution")
public class DisputeResolution {
    /**
     * ID:hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 调解事项
     */
    private String title;

    /**
     * 调解联系人
     */
    @Column(name = "contact_person")
    private String contactPerson;

    /**
     * 调解联系人电话
     */
    @Column(name = "contact_phone")
    private String contactPhone;

    /**
     * 调解地址
     */
    private String address;

    /**
     * 更新时间:datetime
     */
    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取调解事项
     *
     * @return title - 调解事项
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置调解事项
     *
     * @param title 调解事项
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取调解联系人
     *
     * @return contact_person - 调解联系人
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * 设置调解联系人
     *
     * @param contactPerson 调解联系人
     */
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    /**
     * 获取调解联系人电话
     *
     * @return contact_phone - 调解联系人电话
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * 设置调解联系人电话
     *
     * @param contactPhone 调解联系人电话
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    /**
     * 获取调解地址
     *
     * @return address - 调解地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置调解地址
     *
     * @param address 调解地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取更新时间:datetime
     *
     * @return update_time - 更新时间:datetime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间:datetime
     *
     * @param updateTime 更新时间:datetime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}