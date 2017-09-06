package com.topie.huaifang.database.core.model;

import javax.persistence.*;

@Table(name = "d_party_members_node")
public class PartyMembersNode {
    /**
     * 节点ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父节点ID
     */
    private Integer pid;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 获取节点ID
     *
     * @return id - 节点ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置节点ID
     *
     * @param id 节点ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取父节点ID
     *
     * @return pid - 父节点ID
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置父节点ID
     *
     * @param pid 父节点ID
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取节点名称
     *
     * @return name - 节点名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置节点名称
     *
     * @param name 节点名称
     */
    public void setName(String name) {
        this.name = name;
    }
}