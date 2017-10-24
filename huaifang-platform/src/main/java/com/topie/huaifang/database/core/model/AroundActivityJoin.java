package com.topie.huaifang.database.core.model;

import javax.persistence.*;

@Table(name = "d_around_activity_join")
public class AroundActivityJoin {
    /**
     * 活动ID
     */
    @Id
    @Column(name = "activity_id")
    private Integer activityId;

    /**
     * 用户ID
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 获取活动ID
     *
     * @return activity_id - 活动ID
     */
    public Integer getActivityId() {
        return activityId;
    }

    /**
     * 设置活动ID
     *
     * @param activityId 活动ID
     */
    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

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
}