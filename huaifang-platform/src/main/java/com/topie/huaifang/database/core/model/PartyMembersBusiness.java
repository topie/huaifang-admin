package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "d_party_members_business")
public class PartyMembersBusiness {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 分类:select:[学习交流,党务公开]
     */
    private String type;

    /**
     * 标题:textarea
     */
    private String title;

    /**
     * 附件:file
     */
    private String file;

    /**
     * 发布者
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
     * 内容:editor
     */
    private String content;

    @Column(name = "read_count")
    private Integer readCount;

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
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
     * 获取分类:select:[学习交流,党务公开]
     *
     * @return type - 分类:select:[学习交流,党务公开]
     */
    public String getType() {
        return type;
    }

    /**
     * 设置分类:select:[学习交流,党务公开]
     *
     * @param type 分类:select:[学习交流,党务公开]
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取标题:textarea
     *
     * @return title - 标题:textarea
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题:textarea
     *
     * @param title 标题:textarea
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取附件:file
     *
     * @return file - 附件:file
     */
    public String getFile() {
        return file;
    }

    /**
     * 设置附件:file
     *
     * @param file 附件:file
     */
    public void setFile(String file) {
        this.file = file;
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
     * 获取内容:editor
     *
     * @return content - 内容:editor
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容:editor
     *
     * @param content 内容:editor
     */
    public void setContent(String content) {
        this.content = content;
    }
}
