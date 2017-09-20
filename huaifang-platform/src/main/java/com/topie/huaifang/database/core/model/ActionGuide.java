package com.topie.huaifang.database.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "d_action_guide")
public class ActionGuide {

    /**
     * ID:hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 栏目:tree
     */
    @Column(name = "cat_id")
    private String catId;

    /**
     * 办事指南标题
     */
    private String title;

    /**
     * 封面:image
     */
    private String image;

    /**
     * 办事条件:textarea
     */
    @Column(name = "action_condition")
    private String actionCondition;

    /**
     * 办事材料:textarea
     */
    @Column(name = "action_material")
    private String actionMaterial;

    /**
     * 办事地址:textarea
     */
    @Column(name = "action_address")
    private String actionAddress;

    /**
     * 流程:textarea
     */
    @Column(name = "action_flow")
    private String actionFlow;

    /**
     * 开始时间:datetime
     */
    @Column(name = "action_begin")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date actionBegin;

    /**
     * 结束时间:datetime
     */
    @Column(name = "action_end")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date actionEnd;

    /**
     * 办事费用:textarea
     */
    @Column(name = "action_fee")
    private String actionFee;

    /**
     * 办事依据:textarea
     */
    @Column(name = "action_yiju")
    private String actionYiju;

    /**
     * 办事备注:textarea
     */
    @Column(name = "action_note")
    private String actionNote;

    /**
     * 附件
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
     * 阅读数:skip
     */
    @Column(name = "read_count")
    private Integer readCount;

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
     * 获取栏目:tree
     *
     * @return cat_id - 栏目:tree
     */
    public String getCatId() {
        return catId;
    }

    /**
     * 设置栏目:tree
     *
     * @param catId 栏目:tree
     */
    public void setCatId(String catId) {
        this.catId = catId;
    }

    /**
     * 获取办事指南标题
     *
     * @return title - 办事指南标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置办事指南标题
     *
     * @param title 办事指南标题
     */
    public void setTitle(String title) {
        this.title = title;
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
     * 获取办事条件:textarea
     *
     * @return action_condition - 办事条件:textarea
     */
    public String getActionCondition() {
        return actionCondition;
    }

    /**
     * 设置办事条件:textarea
     *
     * @param actionCondition 办事条件:textarea
     */
    public void setActionCondition(String actionCondition) {
        this.actionCondition = actionCondition;
    }

    /**
     * 获取办事材料:textarea
     *
     * @return action_material - 办事材料:textarea
     */
    public String getActionMaterial() {
        return actionMaterial;
    }

    /**
     * 设置办事材料:textarea
     *
     * @param actionMaterial 办事材料:textarea
     */
    public void setActionMaterial(String actionMaterial) {
        this.actionMaterial = actionMaterial;
    }

    /**
     * 获取办事材料:textarea
     *
     * @return action_address - 办事材料:textarea
     */
    public String getActionAddress() {
        return actionAddress;
    }

    /**
     * 设置办事材料:textarea
     *
     * @param actionAddress 办事材料:textarea
     */
    public void setActionAddress(String actionAddress) {
        this.actionAddress = actionAddress;
    }

    /**
     * 获取流程:textarea
     *
     * @return action_flow - 流程:textarea
     */
    public String getActionFlow() {
        return actionFlow;
    }

    /**
     * 设置流程:textarea
     *
     * @param actionFlow 流程:textarea
     */
    public void setActionFlow(String actionFlow) {
        this.actionFlow = actionFlow;
    }

    /**
     * 获取开始时间:datetime
     *
     * @return action_begin - 开始时间:datetime
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getActionBegin() {
        return actionBegin;
    }

    /**
     * 设置开始时间:datetime
     *
     * @param actionBegin 开始时间:datetime
     */
    public void setActionBegin(Date actionBegin) {
        this.actionBegin = actionBegin;
    }

    /**
     * 获取结束时间:datetime
     *
     * @return action_end - 结束时间:datetime
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getActionEnd() {
        return actionEnd;
    }

    /**
     * 设置结束时间:datetime
     *
     * @param actionEnd 结束时间:datetime
     */
    public void setActionEnd(Date actionEnd) {
        this.actionEnd = actionEnd;
    }

    /**
     * 获取办事费用:textarea
     *
     * @return action_fee - 办事费用:textarea
     */
    public String getActionFee() {
        return actionFee;
    }

    /**
     * 设置办事费用:textarea
     *
     * @param actionFee 办事费用:textarea
     */
    public void setActionFee(String actionFee) {
        this.actionFee = actionFee;
    }

    /**
     * 获取办事依据:textarea
     *
     * @return action_yiju - 办事依据:textarea
     */
    public String getActionYiju() {
        return actionYiju;
    }

    /**
     * 设置办事依据:textarea
     *
     * @param actionYiju 办事依据:textarea
     */
    public void setActionYiju(String actionYiju) {
        this.actionYiju = actionYiju;
    }

    /**
     * 获取办事备注:textarea
     *
     * @return action_note - 办事备注:textarea
     */
    public String getActionNote() {
        return actionNote;
    }

    /**
     * 设置办事备注:textarea
     *
     * @param actionNote 办事备注:textarea
     */
    public void setActionNote(String actionNote) {
        this.actionNote = actionNote;
    }

    /**
     * 获取附件
     *
     * @return file - 附件
     */
    public String getFile() {
        return file;
    }

    /**
     * 设置附件
     *
     * @param file 附件
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
     * 获取阅读数:skip
     *
     * @return read_count - 阅读数:skip
     */
    public Integer getReadCount() {
        return readCount;
    }

    /**
     * 设置阅读数:skip
     *
     * @param readCount 阅读数:skip
     */
    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }
}
