package com.mystudy.hibernatevalidation.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class User {

    private Long id;
    /**
     * 不能为null," ",""
     */
    @NotBlank(message = "姓名不能为空")
    private String name;
    /**
     * 正整数,1-800
     */
    @NotNull(message = "年龄不能为空")
    @Max(message = "年龄不能大于800" ,value = 800)
    @Min(message = "年龄必须大于1",value = 1)
    private Integer age;

    /**
     * email格式
     */
    @NotNull(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    /**
     * 在当前日期之前
     */
    @Past(message = "必须小于当前的时间")
    private LocalDateTime birthday;

    /**
     * 符合中国大陆手机号格式
     */
    @NotNull
    @Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$",message = "手机号格式不正确")
    private String phone;

    /**
     * 符合url规范
     */
    @URL(message = "网站格式错误")
    private String personalPage;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public String getPersonalPage() {
        return personalPage;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public void setPersonalPage(String personalPage) {
        this.personalPage = personalPage;
    }
}
