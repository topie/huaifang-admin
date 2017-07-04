package com.topie.huaifang.database.core.model;

import com.topie.huaifang.common.handler.Sortable;
import com.topie.huaifang.core.enums.YellowPageType;

import javax.persistence.*;

@Table(name = "d_yellow_page")
public class YellowPage extends Sortable {

    private static final long serialVersionUID = -2327728087717749023L;

    /**
     * 公告ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 类型 0:常用电话 1：物业 2:卫生医疗 3：其它
     */
    private Integer type;

    /**
     * 名称
     */
    private String name;

    /**
     * 联系电话
     */
    @Column(name = "mobile_phone")
    private String mobilePhone;

    /**
     * 备注
     */
    private String note;

    private String getTypeStr() {
        if (type == null) return "";
        return YellowPageType.getName(type);
    }

    /**
     * 获取公告ID
     *
     * @return id - 公告ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置公告ID
     *
     * @param id 公告ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取类型 0:常用电话 1：物业 2:卫生医疗 3：其它
     *
     * @return type - 类型 0:常用电话 1：物业 2:卫生医疗 3：其它
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型 0:常用电话 1：物业 2:卫生医疗 3：其它
     *
     * @param type 类型 0:常用电话 1：物业 2:卫生医疗 3：其它
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取联系电话
     *
     * @return mobile_phone - 联系电话
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置联系电话
     *
     * @param mobilePhone 联系电话
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
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
}
