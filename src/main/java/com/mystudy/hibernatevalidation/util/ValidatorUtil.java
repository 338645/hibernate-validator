package com.mystudy.hibernatevalidation.util;

import com.mystudy.hibernatevalidation.entity.User;
import com.mystudy.hibernatevalidation.entity.VipUser;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Configuration;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class ValidatorUtil {
    private static volatile Validator validator;

    //快速失败的验证器
    private static volatile Validator failFastValidator;

    //校验入参或返回值的
    private static volatile ExecutableValidator executableValidator;

    public static ExecutableValidator getSingleEXInstance() {
        if (executableValidator == null) {
            synchronized (Validator.class) {
                if (executableValidator == null) {
                    executableValidator = Validation.buildDefaultValidatorFactory().getValidator().forExecutables();
                }
            }
        }
        return executableValidator;
    }

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

    public static Validator getSingleFailFastInstance() {
        if (failFastValidator == null) {
            synchronized (Validator.class) {
                if (failFastValidator == null) {
                    failFastValidator = Validation.byProvider(HibernateValidator.class)
                            .configure().failFast(true)
                            .buildValidatorFactory().getValidator();
                }
            }
        }
        return failFastValidator;
    }

    public static List<String> valid(User user, Class<?>... groups) {
        //返回不通过验证的属性的信息的集合，全通过为空集合
        Set<ConstraintViolation<User>> set = getSingleInstance().validate(user, groups);
        List<String> invalids = set.stream().map(v -> "属性：" + v.getPropertyPath() + "," + "属性的值：" + v.getInvalidValue() + "," + "提示信息："
                + v.getMessage()).collect(Collectors.toList());
        return invalids;
    }

    public static List<String> valid(VipUser VipUser, Class<?>... groups) {
        //返回不通过验证的属性的信息的集合，全通过为空集合
        Set<ConstraintViolation<User>> set = getSingleInstance().validate(VipUser, groups);
        List<String> invalids = set.stream().map(v -> "属性：" + v.getPropertyPath() + "," + "属性的值：" + v.getInvalidValue() + "," + "提示信息："
                + v.getMessage()).collect(Collectors.toList());
        return invalids;
    }

    /**
     * 快速失败原则(failFast校验)
     */
    public static List<String> validFailFast(User user, Class<?>... groups) {
        //返回不通过验证的属性的信息的集合，全通过为空集合
        Set<ConstraintViolation<User>> set = getSingleFailFastInstance().validate(user, groups);
        List<String> invalids = set.stream().map(v -> "属性：" + v.getPropertyPath() + "," + "属性的值：" + v.getInvalidValue() + "," + "提示信息："
                + v.getMessage()).collect(Collectors.toList());
        return invalids;
    }

    public static <T> List<String> validForExecute(ExecutableValidator validator,
                                                   T object,
                                                   Method method,
                                                   Object[] parameterValue,
                                                   Class<?>... groups) {
        //返回不通过验证的属性的信息的集合，全通过为空集合
        Set<ConstraintViolation<T>> set = validator.validateParameters(object, method, parameterValue, groups);
        List<String> invalids = set.stream().map(v -> "属性：" + v.getPropertyPath() + "," + "属性的值：" + v.getInvalidValue() + "," + "提示信息："
                + v.getMessage()).collect(Collectors.toList());
        return invalids;
    }

}
