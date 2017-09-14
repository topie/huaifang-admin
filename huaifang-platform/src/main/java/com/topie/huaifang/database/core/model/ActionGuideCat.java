package com.topie.huaifang.database.core.model;

import javax.persistence.*;

@Table(name = "d_action_guide_cat")
public class ActionGuideCat {
    /**
     * ID:hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 栏目名称
     */
    private String name;

    /**
     * 办事事项
     */
    private String title;

    /**
     * 地址:textarea
     */
    private String address;

    /**
     * 联系人员
     */
    @Column(name = "contact_person")
    private String contactPerson;

    /**
     * 联系号码
     */
    private String phone;

    /**
     * 备注
     */
    private String note;

    /**
     * 状态:select:[未上线,已上线]
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
     * 获取栏目名称
     *
     * @return name - 栏目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置栏目名称
     *
     * @param name 栏目名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取办事事项
     *
     * @return title - 办事事项
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置办事事项
     *
     * @param title 办事事项
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取地址:textarea
     *
     * @return address - 地址:textarea
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址:textarea
     *
     * @param address 地址:textarea
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取联系人员
     *
     * @return contact_person - 联系人员
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * 设置联系人员
     *
     * @param contactPerson 联系人员
     */
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    /**
     * 获取联系号码
     *
     * @return phone - 联系号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系号码
     *
     * @param phone 联系号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取备注
     *
     * @return note - 备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置备注
     *
     * @param note 备注
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 获取状态:select:[未上线,已上线]
     *
     * @return status - 状态:select:[未上线,已上线]
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态:select:[未上线,已上线]
     *
     * @param status 状态:select:[未上线,已上线]
     */
    public void setStatus(String status) {
        this.status = status;
    }
}