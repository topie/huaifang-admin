package com.topie.huaifang.database.core.model;

import javax.persistence.*;

@Table(name = "d_tag")
public class Tag {
    /**
     * ID:hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 标签名
     */
    @Column(name = "tag_name")
    private String tagName;

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
     * 获取标签名
     *
     * @return tag_name - 标签名
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * 设置标签名
     *
     * @param tagName 标签名
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}