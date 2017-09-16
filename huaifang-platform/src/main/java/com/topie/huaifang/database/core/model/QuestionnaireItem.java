package com.topie.huaifang.database.core.model;

import com.topie.huaifang.common.handler.Sortable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Table(name = "d_questionnaire_item")
public class QuestionnaireItem extends Sortable {

    private static final long serialVersionUID = -7945177931953553516L;

    /**
     * ID:hidden
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 问卷信息ID:hidden
     */
    @Column(name = "info_id")
    private Integer infoId;

    /**
     * 问题题目
     */
    private String question;

    /**
     * 序号
     */
    @Column(name = "question_index")
    private Integer questionIndex;

    @Transient
    private List<Map> options = new ArrayList<>();

    public List<Map> getOptions() {
        return options;
    }

    public void setOptions(List<Map> options) {
        this.options = options;
    }

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
     * 获取问卷信息ID:hidden
     *
     * @return info_id - 问卷信息ID:hidden
     */
    public Integer getInfoId() {
        return infoId;
    }

    /**
     * 设置问卷信息ID:hidden
     *
     * @param infoId 问卷信息ID:hidden
     */
    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    /**
     * 获取问题题目
     *
     * @return question - 问题题目
     */
    public String getQuestion() {
        return question;
    }

    /**
     * 设置问题题目
     *
     * @param question 问题题目
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * 获取序号
     *
     * @return question_index - 序号
     */
    public Integer getQuestionIndex() {
        return questionIndex;
    }

    /**
     * 设置序号
     *
     * @param questionIndex 序号
     */
    public void setQuestionIndex(Integer questionIndex) {
        this.questionIndex = questionIndex;
    }
}
