package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "d_around_activity")
public class AroundActivity {

    /**
     * ID:hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 活动主题:textarea
     */
    private String title;

    /**
     * 活动类型:select:[社团活动,商业推广,亲子活动,自发活动]
     */
    private String type;

    /**
     * 开始时间:datetime
     */
    @Column(name = "begin_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;

    /**
     * 结束时间:datetime
     */
    @Column(name = "end_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 报名截止日期:datetime
     */
    @Column(name = "limit_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date limitTime;

    /**
     * 创建时间:skip
     */
    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 人数上限:text
     */
    @Column(name = "join_limit")
    private Integer joinLimit;

    /**
     * 活动地址:textarea
     */
    private String address;

    /**
     * 封面:image
     */
    private String image;

    /**
     * 发布者:text
     */
    @Column(name = "publish_user")
    private String publishUser;

    /**
     * 发布时间:datetime
     */
    @Column(name = "publish_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishTime;

    /**
     * 状态:select:[未开始,已开始,已结束]
     */
    private String status;

    /**
     * 活动内容:kindEditor
     */
    private String content;

    private Integer total;

    private Integer publishUserId;

    @Transient
    private Boolean hasJoin;

    public Boolean getHasJoin() {
        return hasJoin;
    }

    public void setHasJoin(Boolean hasJoin) {
        this.hasJoin = hasJoin;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(Integer publishUserId) {
        this.publishUserId = publishUserId;
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
     * 获取活动主题:textarea
     *
     * @return title - 活动主题:textarea
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置活动主题:textarea
     *
     * @param title 活动主题:textarea
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取活动类型:select:[社团活动,商业推广,亲子活动,自发活动]
     *
     * @return type - 活动类型:select:[社团活动,商业推广,亲子活动,自发活动]
     */
    public String getType() {
        return type;
    }

    /**
     * 设置活动类型:select:[社团活动,商业推广,亲子活动,自发活动]
     *
     * @param type 活动类型:select:[社团活动,商业推广,亲子活动,自发活动]
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取开始时间:datetime
     *
     * @return begin_time - 开始时间:datetime
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * 设置开始时间:datetime
     *
     * @param beginTime 开始时间:datetime
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * 获取结束时间:datetime
     *
     * @return end_time - 结束时间:datetime
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间:datetime
     *
     * @param endTime 结束时间:datetime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取报名截止日期:datetime
     *
     * @return limit_time - 报名截止日期:datetime
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getLimitTime() {
        return limitTime;
    }

    /**
     * 设置报名截止日期:datetime
     *
     * @param limitTime 报名截止日期:datetime
     */
    public void setLimitTime(Date limitTime) {
        this.limitTime = limitTime;
    }

    /**
     * 获取创建时间:skip
     *
     * @return create_time - 创建时间:skip
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间:skip
     *
     * @param createTime 创建时间:skip
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取人数上限:text
     *
     * @return join_limit - 人数上限:text
     */
    public Integer getJoinLimit() {
        return joinLimit;
    }

    /**
     * 设置人数上限:text
     *
     * @param joinLimit 人数上限:text
     */
    public void setJoinLimit(Integer joinLimit) {
        this.joinLimit = joinLimit;
    }

    /**
     * 获取活动地址:textarea
     *
     * @return address - 活动地址:textarea
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置活动地址:textarea
     *
     * @param address 活动地址:textarea
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取封面:image
     *
     * @return image - 封面:image
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置封面:image
     *
     * @param image 封面:image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取发布者:text
     *
     * @return publish_user - 发布者:text
     */
    public String getPublishUser() {
        return publishUser;
    }

    /**
     * 设置发布者:text
     *
     * @param publishUser 发布者:text
     */
    public void setPublishUser(String publishUser) {
        this.publishUser = publishUser;
    }

    /**
     * 获取发布时间:datetime
     *
     * @return publish_time - 发布时间:datetime
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * 设置发布时间:datetime
     *
     * @param publishTime 发布时间:datetime
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * 获取状态:select:[未开始,已开始,已结束]
     *
     * @return status - 状态:select:[未开始,已开始,已结束]
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态:select:[未开始,已开始,已结束]
     *
     * @param status 状态:select:[未开始,已开始,已结束]
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取活动内容:kindEditor
     *
     * @return content - 活动内容:kindEditor
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置活动内容:kindEditor
     *
     * @param content 活动内容:kindEditor
     */
    public void setContent(String content) {
        this.content = content;
    }
}
