package com.topie.huaifang.core.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cgj on 2015/12/22.
 * 订单来源枚举类
 */
public enum YellowPageType {
    CYDH(0, "常用电话"), WY(1, "物业"), YLWS(2, "卫生医疗"), QT(3, "其它");

    /**
     * 编码
     */
    private Integer code;

    /**
     * 名称
     */
    private String name;

    YellowPageType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(Integer code) {
        for (YellowPageType item : YellowPageType.values()) {
            if (code.intValue() == item.getCode().intValue()) {
                return item.getName();
            }
        }
        return null;
    }

    public static Integer getCode(String name) {
        for (YellowPageType item : YellowPageType.values()) {
            if (name.equals(item.getName())) {
                return item.getCode();
            }
        }
        return null;
    }

    public static List<Object> getCodeList() {
        List<Object> list = new ArrayList<>();
        for (YellowPageType item : YellowPageType.values()) {
            list.add(item.getCode());
        }
        return list;
    }

    public static List<String> getNameList() {
        List<String> list = new ArrayList<>();
        for (YellowPageType item : YellowPageType.values()) {
            list.add(item.getName());
        }
        return list;
    }

    public static List<YellowPageType> getItemList() {
        List<YellowPageType> list = new ArrayList<>();
        for (YellowPageType item : YellowPageType.values()) {
            list.add(item);
        }
        return list;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
