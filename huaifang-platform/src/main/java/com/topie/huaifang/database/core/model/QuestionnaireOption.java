package com.topie.huaifang.database.core.model;

import javax.persistence.*;

@Table(name = "d_questionnaire_option")
public class QuestionnaireOption {
    /**
     * ID:hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 题目ID
     */
    @Column(name = "item_id")
    private Integer itemId;

    /**
     * 序号
     */
    @Column(name = "option_index")
    private Integer optionIndex;

    /**
     * 选型内容
     */
    private String text;

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
     * 获取序号
     *
     * @return option_index - 序号
     */
    public Integer getOptionIndex() {
        return optionIndex;
    }

    /**
     * 设置序号
     *
     * @param optionIndex 序号
     */
    public void setOptionIndex(Integer optionIndex) {
        this.optionIndex = optionIndex;
    }

    /**
     * 获取选型内容
     *
     * @return text - 选型内容
     */
    public String getText() {
        return text;
    }

    /**
     * 设置选型内容
     *
     * @param text 选型内容
     */
    public void setText(String text) {
        this.text = text;
    }
}