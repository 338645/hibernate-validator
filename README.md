# hibernate-validator

### 一、概述

Bean Validation源于JSR-303 ，而JSR303是 Java EE 6 中的一项子规范。JSR349、JSR380是其升级版，添加了一些新的特性。Oracle公司传统艺能，一流公司定标准，它们只定义了一些校验注解（Constraint），如@Null@NotNull@Pattern]，位于javax.validation.constraints包下，只提供规范不提供实现。

Hibernate Validator是对这个规范的实现（不要和数据库ORM框架Hibernate联系在一起），并增加了一些自定义校验注解，如`@Email`、`@Length`、`@Range`，位于org.hibernate.validator.constraints包下。

这里贴上常用的注解和解释

| 注解                        | 释义                                                         |
| :-------------------------- | ------------------------------------------------------------ |
| @Null                       | 被注释的元素必须为 null                                      |
| @NotNull                    | 被注释的元素必须不为 null                                    |
| @AssertTrue                 | 被注释的元素必须为 true                                      |
| @AssertFalse                | 被注释的元素必须为 false                                     |
| @Min(value)                 | 被注释的元素必须是一个数字，其值必须大于等于指定的最小值     |
| @Max(value)                 | 被注释的元素必须是一个数字，其值必须小于等于指定的最大值     |
| @DecimalMin(value)          | 被注释的元素必须是一个数字，其值必须大于等于指定的最小值     |
| @DecimalMax(value)          | 被注释的元素必须是一个数字，其值必须小于等于指定的最大值     |
| @Size(max, min)             | 被注释的元素的大小必须在指定的范围内，元素必须为集合，代表集合个数 |
| @Digits (integer, fraction) | 被注释的元素必须是一个数字，其值必须在可接受的范围内         |
| @Past                       | 被注释的元素必须是一个过去的日期                             |
| @Future                     | 被注释的元素必须是一个将来的日期                             |
| @Email                      | 被注释的元素必须是电子邮箱地址                               |
| @Length(min=, max=)         | 被注释的字符串的大小必须在指定的范围内，必须为数组或者字符串，若微数组则表示为数组长度，字符串则表示为字符串长度 |
| @NotEmpty                   | 被注释的字符串的必须非空，**可以为空格，空字符串，null**     |
| @Range(min=, max=)          | 被注释的元素必须在合适的范围内                               |
| @NotBlank                   | 被注释的字符串的必须非空，**不可以为空格，可以为空字符串，null** |
| @Pattern(regexp = )         | 正则表达式校验                                               |

### 正则表达式
[正则表达式](https://www.runoob.com/regexp/regexp-tutorial.html)
[java正则表达式](https://www.runoob.com/java/java-regular-expressions.html)
[正则表达式在线测试工具](https://c.runoob.com/front-end/854/)


# 延伸阅读
[hibernate-validator官网](https://hibernate.org/validator/)

[validator中文实例](https://blog.csdn.net/qq_45745964/article/details/122516345)

[参考Gitee开源](https://gitee.com/jujungfoxmail/hibernate-validator)
