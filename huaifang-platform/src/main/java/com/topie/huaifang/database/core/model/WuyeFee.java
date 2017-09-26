package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "d_wuye_fee")
public class WuyeFee {

    /**
     * ID:hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 账期
     */
    @Column(name = "account_date")
    private String accountDate;

    /**
     * 账号
     */
    private String account;

    private BigDecimal money;

    /**
     * 缴费房间
     */
    @Column(name = "room_number")
    private String roomNumber;

    /**
     * 缴费状态:select:[未缴费,已缴费]
     */
    private String status;

    /**
     * 缴费时间
     */
    @Column(name = "pay_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date payTime;

    /**
     * 缴费人
     */
    @Column(name = "pay_user")
    private String payUser;

    /**
     * 收费人
     */
    @Column(name = "action_user")
    private String actionUser;

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
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
     * 获取账期
     *
     * @return account_date - 账期
     */
    public String getAccountDate() {
        return accountDate;
    }

    /**
     * 设置账期
     *
     * @param accountDate 账期
     */
    public void setAccountDate(String accountDate) {
        this.accountDate = accountDate;
    }

    /**
     * 获取账号
     *
     * @return account - 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置账号
     *
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取缴费房间
     *
     * @return room_number - 缴费房间
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * 设置缴费房间
     *
     * @param roomNumber 缴费房间
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * 获取缴费状态:select:[未缴费,已缴费]
     *
     * @return status - 缴费状态:select:[未缴费,已缴费]
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置缴费状态:select:[未缴费,已缴费]
     *
     * @param status 缴费状态:select:[未缴费,已缴费]
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取缴费时间
     *
     * @return pay_time - 缴费时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 设置缴费时间
     *
     * @param payTime 缴费时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取缴费人
     *
     * @return pay_user - 缴费人
     */
    public String getPayUser() {
        return payUser;
    }

    /**
     * 设置缴费人
     *
     * @param payUser 缴费人
     */
    public void setPayUser(String payUser) {
        this.payUser = payUser;
    }

    /**
     * 获取收费人
     *
     * @return action_user - 收费人
     */
    public String getActionUser() {
        return actionUser;
    }

    /**
     * 设置收费人
     *
     * @param actionUser 收费人
     */
    public void setActionUser(String actionUser) {
        this.actionUser = actionUser;
    }
}
