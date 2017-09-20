package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "d_app_time_line_like")
public class AppTimeLineLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 圈ID
     */
    @Column(name = "line_id")
    private Integer lineId;

    /**
     * 点赞用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 点赞用户
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 评论时间
     */
    @Column(name = "like_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date likeTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取圈ID
     *
     * @return line_id - 圈ID
     */
    public Integer getLineId() {
        return lineId;
    }

    /**
     * 设置圈ID
     *
     * @param lineId 圈ID
     */
    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    /**
     * 获取点赞用户ID
     *
     * @return user_id - 点赞用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置点赞用户ID
     *
     * @param userId 点赞用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取点赞用户
     *
     * @return user_name - 点赞用户
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置点赞用户
     *
     * @param userName 点赞用户
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取评论时间
     *
     * @return like_time - 评论时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getLikeTime() {
        return likeTime;
    }

    /**
     * 设置评论时间
     *
     * @param likeTime 评论时间
     */
    public void setLikeTime(Date likeTime) {
        this.likeTime = likeTime;
    }
}
