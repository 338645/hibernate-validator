package com.mystudy.hibernatevalidation.entity;

import javax.validation.constraints.NotNull;

public class VipInfo {

    @NotNull
    private String Vip_token;

    public String getVip_token() {
        return Vip_token;
    }

    public void setVip_token(String vip_token) {
        Vip_token = vip_token;
    }
}
