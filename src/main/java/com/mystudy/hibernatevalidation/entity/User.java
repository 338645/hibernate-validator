package com.mystudy.hibernatevalidation.entity;

import com.mystudy.hibernatevalidation.constraints.UserGrade;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class User {
    //分组二更新检查
    public interface modified {
    }

    //分组一插入检查
    public interface insert {
    }

    @GroupSequence(value = {insert.class,modified.class})
    public interface orderCheck{

    }

    //属性为对象，要校验属性对象的属性，要加valid注解
    @NotNull
    @Valid
    private VipInfo vipInfo;

    @Null(groups = insert.class,message = "id必须为空")
    @NotNull(groups = modified.class)
    private Long id;
    /**
     * 不能为null," ",""
     */
    @NotBlank(message = "姓名不能为空",groups = modified.class)
    private String name;
    /**
     * 正整数,1-800
     */
    @NotNull(message = "年龄不能为空")
    @Max(message = "年龄不能大于800", value = 800)
    @Min(message = "FBI_WARNING：18岁以下请在家长陪同下观看", value = 18)
    private Integer age;

    /**
     * 玩家等级：
     *  分为 绿色玩家和非绿色玩家
     *  等级：1-100
     */
    @UserGrade
    private String grade;

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
    @Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$", message = "手机号格式不正确")
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

    public VipInfo getVipInfo() {
        return vipInfo;
    }

    public void setVipInfo(VipInfo vipInfo) {
        this.vipInfo = vipInfo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
