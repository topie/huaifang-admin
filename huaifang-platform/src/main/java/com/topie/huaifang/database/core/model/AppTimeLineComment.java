package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "d_app_time_line_comment")
public class AppTimeLineComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 圈ID
     */
    @Column(name = "line_id")
    private Integer lineId;

    /**
     * 回复评论ID
     */
    @Column(name = "re_comment_id")
    private Integer reCommentId;

    /**
     * 评论用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 添加用户
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 评论时间
     */
    @Column(name = "comment_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date commentTime;

    /**
     * 评论内容
     */
    private String content;

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
     * 获取回复评论ID
     *
     * @return re_comment_id - 回复评论ID
     */
    public Integer getReCommentId() {
        return reCommentId;
    }

    /**
     * 设置回复评论ID
     *
     * @param reCommentId 回复评论ID
     */
    public void setReCommentId(Integer reCommentId) {
        this.reCommentId = reCommentId;
    }

    /**
     * 获取评论用户ID
     *
     * @return user_id - 评论用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置评论用户ID
     *
     * @param userId 评论用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取添加用户
     *
     * @return user_name - 添加用户
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置添加用户
     *
     * @param userName 添加用户
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取评论时间
     *
     * @return comment_time - 评论时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getCommentTime() {
        return commentTime;
    }

    /**
     * 设置评论时间
     *
     * @param commentTime 评论时间
     */
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    /**
     * 获取评论内容
     *
     * @return content - 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评论内容
     *
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}
