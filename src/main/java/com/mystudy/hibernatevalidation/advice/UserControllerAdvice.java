package com.mystudy.hibernatevalidation.advice;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
public class UserControllerAdvice {
    /**
     * 统一异常处理
     *
     * @param
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public String exHandler(BindException e) {
        StringBuilder sb = new StringBuilder();
        List<FieldError> fieldErrors = e.getFieldErrors();
        for (FieldError error : fieldErrors) {
            System.out.println(error.getField() + " : " + error.getRejectedValue() + " : " + error.getDefaultMessage());
            sb.append(error.getField() + " : " + error.getRejectedValue() + " : " + error.getDefaultMessage());
            sb.append(",");
        }
        return sb.toString();
    }
}
