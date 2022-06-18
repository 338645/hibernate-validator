package com.mystudy.hibernatevalidation.entity;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

public class VipUser extends User{
    //增强分组，不但是user且具有授权，才是合法vip
    //分组顺序，首先是默认判断是否正确的普通用户后，才会判断是否为vip用户
    public interface VipToken extends Default {

    }

    @GroupSequence(value = {Default.class,VipToken.class})
    public interface VipCheck{

    }

    @NotNull(groups = {VipToken.class,modified.class},message = "非法会员")
    private String vip_token;

    public String getVip_token() {
        return vip_token;
    }

    public void setVip_token(String vip_token) {
        this.vip_token = vip_token;
    }
}
