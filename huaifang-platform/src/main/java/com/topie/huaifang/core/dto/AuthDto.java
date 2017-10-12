package com.topie.huaifang.core.dto;

public class AuthDto {

    private Integer houseId;

    private String pPersonType;

    private String pName;

    private String pIdentifyNumber;

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getpPersonType() {
        return pPersonType;
    }

    public void setpPersonType(String pPersonType) {
        this.pPersonType = pPersonType;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpIdentifyNumber() {
        return pIdentifyNumber;
    }

    public void setpIdentifyNumber(String pIdentifyNumber) {
        this.pIdentifyNumber = pIdentifyNumber;
    }
}
