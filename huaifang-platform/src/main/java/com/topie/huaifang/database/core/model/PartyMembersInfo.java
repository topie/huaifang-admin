package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "d_party_members_info")
public class PartyMembersInfo {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 节点ID
     */
    @Column(name = "node_id")
    private Integer nodeId;

    /**
     * 党员名称
     */
    private String name;

    /**
     * 党员编号
     */
    private String code;

    /**
     * 党员标示:select:[入党申请人,入党积极分子,发展对象,预备党员,正式党员]
     */
    private String flag;

    /**
     * 入党时间:date
     */
    @Column(name = "enter_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date enterDate;

    /**
     * 党员标签:checkboxGroup:[在职党员,离退休党员,大学生党员,流动党员,下岗失业、无业、个体党员,非公党员,社区工作者党员]
     */
    private String tag;

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
     * 获取节点ID
     *
     * @return node_id - 节点ID
     */
    public Integer getNodeId() {
        return nodeId;
    }

    /**
     * 设置节点ID
     *
     * @param nodeId 节点ID
     */
    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * 获取党员名称
     *
     * @return name - 党员名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置党员名称
     *
     * @param name 党员名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取党员编号
     *
     * @return code - 党员编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置党员编号
     *
     * @param code 党员编号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取党员标示:select:[入党申请人,入党积极分子,发展对象,预备党员,正式党员]
     *
     * @return flag - 党员标示:select:[入党申请人,入党积极分子,发展对象,预备党员,正式党员]
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 设置党员标示:select:[入党申请人,入党积极分子,发展对象,预备党员,正式党员]
     *
     * @param flag 党员标示:select:[入党申请人,入党积极分子,发展对象,预备党员,正式党员]
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * 获取入党时间:date
     *
     * @return enter_date - 入党时间:date
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    public Date getEnterDate() {
        return enterDate;
    }

    /**
     * 设置入党时间:date
     *
     * @param enterDate 入党时间:date
     */
    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    /**
     * 获取党员标签:checkboxGroup:[在职党员,离退休党员,大学生党员,流动党员,下岗失业、无业、个体党员,非公党员,社区工作者党员]
     *
     * @return tag - 党员标签:checkboxGroup:[在职党员,离退休党员,大学生党员,流动党员,下岗失业、无业、个体党员,非公党员,社区工作者党员]
     */
    public String getTag() {
        return tag;
    }

    /**
     * 设置党员标签:checkboxGroup:[在职党员,离退休党员,大学生党员,流动党员,下岗失业、无业、个体党员,非公党员,社区工作者党员]
     *
     * @param tag 党员标签:checkboxGroup:[在职党员,离退休党员,大学生党员,流动党员,下岗失业、无业、个体党员,非公党员,社区工作者党员]
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
}
