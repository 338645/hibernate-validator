package com.mystudy.hibernatevalidation.util;

import com.mystudy.hibernatevalidation.entity.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidatorUtil {
    private static volatile Validator validator;

    public static Validator getSingleInstance() {
        if (validator == null) {
            synchronized (Validator.class) {
                if (validator == null) {
                    validator = Validation.buildDefaultValidatorFactory().getValidator();
                }
            }
        }
        return validator;
    }

    public static List<String> valid(User user) {
        //返回不通过验证的属性的信息的集合，全通过为空集合
        Set<ConstraintViolation<User>> set = getSingleInstance().validate(user);
        List<String> invalids = set.stream().map(v -> "属性：" + v.getPropertyPath() + "," + "属性的值：" + v.getInvalidValue() + "," + "提示信息："
                + v.getMessage()).collect(Collectors.toList());
        return invalids;
    }
}
