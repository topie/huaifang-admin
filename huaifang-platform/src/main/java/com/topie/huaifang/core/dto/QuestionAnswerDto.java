package com.topie.huaifang.core.dto;

import java.util.List;

public class QuestionAnswerDto {

    private Integer infoId;

    private List<QuestionItemDto> items;

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public List<QuestionItemDto> getItems() {
        return items;
    }

    public void setItems(List<QuestionItemDto> items) {
        this.items = items;
    }

}
