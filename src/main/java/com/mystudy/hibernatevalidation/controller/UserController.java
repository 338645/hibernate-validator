package com.mystudy.hibernatevalidation.controller;

import com.mystudy.hibernatevalidation.entity.User;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/getByName")
    public String getByName(String name) {

        return name + "ok";
    }
    /**
     * 统一异常处理
     *
     * @param
     * @return
     */
    /*@ExceptionHandler(BindException.class)
    public String exHandler(BindException e) {
        StringBuilder sb = new StringBuilder();
        List<FieldError> fieldErrors = e.getFieldErrors();
        for (FieldError error : fieldErrors) {
            System.out.println(error.getField() + " : " + error.getRejectedValue() + " : " + error.getDefaultMessage());
            sb.append(error.getField() + " : " + error.getRejectedValue() + " : " + error.getDefaultMessage());
            sb.append(",");
        }
        return sb.toString();
    }*/

    /**
     * 注解式
     *
     * @param user
     * @return
     */
    @GetMapping("/add")
    public String addUser(@Validated(value = User.modified.class) User user, BindingResult bindingResult, HttpServletRequest request, Model model, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            //尝试请求转发
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors) {
                System.out.println(error.getField() + " : " + error.getRejectedValue() + " : " + error.getDefaultMessage());
            }
            return "添加失败";
        }
        return "add添加成功";
    }

    @GetMapping("/add2")
    public String addUser2(@Validated(value = User.modified.class) User user, HttpServletRequest request, Model model, HttpServletResponse response) {
        String url = response.getHeader("Refresh");
        System.out.println(url);
        return "add2添加成功";
    }
}
