package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "d_app_manager")
public class AppManager {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 系统类型
     */
    @Column(name = "system_type")
    private String systemType;

    /**
     * 版本
     */
    private String version;

    /**
     * 下载地址
     */
    @Column(name = "download_url")
    private String downloadUrl;

    private Integer current;

    @Column(name = "force_update")
    private Integer forceUpdate;

    /**
     * 发布时间
     */
    @Column(name = "publish_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishTime;

    public Integer getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(Integer forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
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
     * 获取系统类型
     *
     * @return system_type - 系统类型
     */
    public String getSystemType() {
        return systemType;
    }

    /**
     * 设置系统类型
     *
     * @param systemType 系统类型
     */
    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    /**
     * 获取版本
     *
     * @return version - 版本
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本
     *
     * @param version 版本
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取下载地址
     *
     * @return download_url - 下载地址
     */
    public String getDownloadUrl() {
        return downloadUrl;
    }

    /**
     * 设置下载地址
     *
     * @param downloadUrl 下载地址
     */
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    /**
     * 获取发布时间
     *
     * @return publish_time - 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * 设置发布时间
     *
     * @param publishTime 发布时间
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}
