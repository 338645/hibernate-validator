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

[java内部使用pattern和matcher实现正则表达式匹配](https://www.cnblogs.com/ggjucheng/p/3423731.html#:~:text=Matcher%E7%B1%BB%E6%8F%90%E4%BE%9B%E4%B8%89%E4%B8%AA%E5%8C%B9%E9%85%8D%E6%93%8D%E4%BD%9C%E6%96%B9%E6%B3%95%2C%E4%B8%89%E4%B8%AA%E6%96%B9%E6%B3%95%E5%9D%87%E8%BF%94%E5%9B%9Eboolean%E7%B1%BB%E5%9E%8B%2C%E5%BD%93%E5%8C%B9%E9%85%8D%E5%88%B0%E6%97%B6%E8%BF%94%E5%9B%9Etrue%2C%E6%B2%A1%E5%8C%B9%E9%85%8D%E5%88%B0%E5%88%99%E8%BF%94%E5%9B%9Efalse.%20matches%20%28%29%E5%AF%B9%E6%95%B4%E4%B8%AA%E5%AD%97%E7%AC%A6%E4%B8%B2%E8%BF%9B%E8%A1%8C%E5%8C%B9%E9%85%8D%2C%E5%8F%AA%E6%9C%89%E6%95%B4%E4%B8%AA%E5%AD%97%E7%AC%A6%E4%B8%B2%E9%83%BD%E5%8C%B9%E9%85%8D%E4%BA%86%E6%89%8D%E8%BF%94%E5%9B%9Etrue.%20Java%E4%BB%A3%E7%A0%81%E7%A4%BA%E4%BE%8B%3A%20Pattern%20p%3DPattern.compile%20%28%22%5Cd%2B%22%20%29%3B,%28%29%3B%2F%2F%E8%BF%94%E5%9B%9Efalse%2C%E5%9B%A0%E4%B8%BAbb%E4%B8%8D%E8%83%BD%E8%A2%ABd%2B%E5%8C%B9%E9%85%8D%2C%E5%AF%BC%E8%87%B4%E6%95%B4%E4%B8%AA%E5%AD%97%E7%AC%A6%E4%B8%B2%E5%8C%B9%E9%85%8D%E6%9C%AA%E6%88%90%E5%8A%9F.%20Matcher%20m2%3Dp.matcher%20%28%222223%22%20%29%3B%20m2.matches%20%28%29%3B%2F%2F%E8%BF%94%E5%9B%9Etrue%2C%E5%9B%A0%E4%B8%BAd%2B%E5%8C%B9%E9%85%8D%E5%88%B0%E4%BA%86%20)


# 延伸阅读
[hibernate-validator官网](https://hibernate.org/validator/)

[validator中文实例](https://blog.csdn.net/qq_45745964/article/details/122516345)

[参考Gitee开源](https://gitee.com/jujungfoxmail/hibernate-validator)
