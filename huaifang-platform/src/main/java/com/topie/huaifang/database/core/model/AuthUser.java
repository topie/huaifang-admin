package com.topie.huaifang.database.core.model;

import javax.persistence.*;

@Table(name = "d_auth_user")
public class AuthUser {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 人口ID
     */
    @Column(name = "person_id")
    private Integer personId;

    /**
     * 房屋ID
     */
    @Column(name = "house_id")
    private Integer houseId;

    /**
     * 公司ID
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 党员ID
     */
    @Column(name = "party_member_id")
    private Integer partyMemberId;

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取人口ID
     *
     * @return person_id - 人口ID
     */
    public Integer getPersonId() {
        return personId;
    }

    /**
     * 设置人口ID
     *
     * @param personId 人口ID
     */
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    /**
     * 获取房屋ID
     *
     * @return house_id - 房屋ID
     */
    public Integer getHouseId() {
        return houseId;
    }

    /**
     * 设置房屋ID
     *
     * @param houseId 房屋ID
     */
    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    /**
     * 获取公司ID
     *
     * @return company_id - 公司ID
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司ID
     *
     * @param companyId 公司ID
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取党员ID
     *
     * @return party_member_id - 党员ID
     */
    public Integer getPartyMemberId() {
        return partyMemberId;
    }

    /**
     * 设置党员ID
     *
     * @param partyMemberId 党员ID
     */
    public void setPartyMemberId(Integer partyMemberId) {
        this.partyMemberId = partyMemberId;
    }
}