package com.mystudy.hibernatevalidation.services;

import com.mystudy.hibernatevalidation.util.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 非Bean传参校验
 */
@Service
public class UserService {

    public String getByName(@NotNull String name) {
        StackTraceElement st = Thread.currentThread().getStackTrace()[1];
        String methodName = st.getMethodName();
        Method method;
        try {
            method = this.getClass().getDeclaredMethod(methodName, String.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        List<String> strings = ValidatorUtil.validForExecute(ValidatorUtil.getSingleEXInstance(), this, method, new Object[]{name});
        System.out.println(strings);
        return "ok";
    }
}
