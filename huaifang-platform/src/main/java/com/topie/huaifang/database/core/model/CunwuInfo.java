package com.topie.huaifang.database.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "d_cunwu_info")
public class CunwuInfo {
    /**
     * ID:hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 栏目名称
     */
    private String title;

    /**
     * 更新时间:datetime
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 状态:skip
     */
    private String status;

    /**
     * 内容:kindEditor
     */
    private String content;

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
     * @return title - 栏目名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置栏目名称
     *
     * @param title 栏目名称
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取更新时间:datetime
     *
     * @return update_time - 更新时间:datetime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间:datetime
     *
     * @param updateTime 更新时间:datetime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取状态:skip
     *
     * @return status - 状态:skip
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态:skip
     *
     * @param status 状态:skip
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取内容:kindEditor
     *
     * @return content - 内容:kindEditor
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容:kindEditor
     *
     * @param content 内容:kindEditor
     */
    public void setContent(String content) {
        this.content = content;
    }
}