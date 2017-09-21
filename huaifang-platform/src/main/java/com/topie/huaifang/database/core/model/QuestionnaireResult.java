package com.topie.huaifang.database.core.model;

import javax.persistence.*;

@Table(name = "d_questionnaire_result")
public class QuestionnaireResult {
    /**
     * ID:hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 问卷ID
     */
    @Column(name = "info_id")
    private Integer infoId;

    /**
     * 题目ID
     */
    @Column(name = "item_id")
    private Integer itemId;

    /**
     * 选项ID
     */
    @Column(name = "option_id")
    private Integer optionId;

    /**
     * 用户唯一标示
     */
    @Column(name = "user_id")
    private Integer userId;

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
     * 获取问卷ID
     *
     * @return info_id - 问卷ID
     */
    public Integer getInfoId() {
        return infoId;
    }

    /**
     * 设置问卷ID
     *
     * @param infoId 问卷ID
     */
    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    /**
     * 获取题目ID
     *
     * @return item_id - 题目ID
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * 设置题目ID
     *
     * @param itemId 题目ID
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取选项ID
     *
     * @return option_id - 选项ID
     */
    public Integer getOptionId() {
        return optionId;
    }

    /**
     * 设置选项ID
     *
     * @param optionId 选项ID
     */
    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    /**
     * 获取用户唯一标示
     *
     * @return user_id - 用户唯一标示
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户唯一标示
     *
     * @param userId 用户唯一标示
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}