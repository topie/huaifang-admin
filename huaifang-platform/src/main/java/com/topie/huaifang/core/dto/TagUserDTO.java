package com.topie.huaifang.core.dto;

import java.io.Serializable;

/**
 * Created by chenguojun on 9/3/16.
 */
public class TagUserDTO implements Serializable {

    private static final long serialVersionUID = -8877646388589415875L;

    private Integer userId;

    private Integer tagId;

    private String nickname;

    private Boolean selected = false;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getSelected() {
        return (tagId != null && tagId > 0) ? true : false;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

}
