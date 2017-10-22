package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "d_party_members_activity")
public class PartyMembersActivity {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 活动主题:textarea
     */
    private String topic;

    /**
     * 封面:image
     */
    private String image;

    /**
     * 活动地址:textarea
     */
    private String address;

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
     * 人数上限
     */
    @Column(name = "join_limit")
    private Integer joinLimit;

    /**
     * 活动范围
     */
    @Column(name = "activity_range")
    private String activityRange;

    /**
     * 发布者
     */
    @Column(name = "publish_user")
    private String publishUser;

    @Column(name = "publish_user_id")
    private Integer publishUserId;

    /**
     * 发布时间:datetime
     */
    @Column(name = "publish_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishTime;

    /**
     * 状态0未上线1上线中2已结束:skip
     */
    private Integer status;

    /**
     * 活动内容:editor
     */
    private String content;

    @Transient
    private Integer total;

    @Transient
    private Boolean hasJoin;

    public Boolean getHasJoin() {
        return hasJoin;
    }

    public void setHasJoin(Boolean hasJoin) {
        this.hasJoin = hasJoin;
    }

    public Integer getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(Integer publishUserId) {
        this.publishUserId = publishUserId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取活动主题:textarea
     *
     * @return topic - 活动主题:textarea
     */
    public String getTopic() {
        return topic;
    }

    /**
     * 设置活动主题:textarea
     *
     * @param topic 活动主题:textarea
     */
    public void setTopic(String topic) {
        this.topic = topic;
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
     * 获取人数上限
     *
     * @return join_limit - 人数上限
     */
    public Integer getJoinLimit() {
        return joinLimit;
    }

    /**
     * 设置人数上限
     *
     * @param joinLimit 人数上限
     */
    public void setJoinLimit(Integer joinLimit) {
        this.joinLimit = joinLimit;
    }

    /**
     * 获取活动范围
     *
     * @return activity_range - 活动范围
     */
    public String getActivityRange() {
        return activityRange;
    }

    /**
     * 设置活动范围
     *
     * @param activityRange 活动范围
     */
    public void setActivityRange(String activityRange) {
        this.activityRange = activityRange;
    }

    /**
     * 获取发布者
     *
     * @return publish_user - 发布者
     */
    public String getPublishUser() {
        return publishUser;
    }

    /**
     * 设置发布者
     *
     * @param publishUser 发布者
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
     * 获取状态0未上线1上线中2已结束:skip
     *
     * @return status - 状态0未上线1上线中2已结束:skip
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态0未上线1上线中2已结束:skip
     *
     * @param status 状态0未上线1上线中2已结束:skip
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取活动内容:editor
     *
     * @return content - 活动内容:editor
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置活动内容:editor
     *
     * @param content 活动内容:editor
     */
    public void setContent(String content) {
        this.content = content;
    }
}
