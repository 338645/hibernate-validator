package com.mystudy.hibernatevalidation.test;

import com.mystudy.hibernatevalidation.entity.User;
import com.mystudy.hibernatevalidation.util.ValidatorUtil;

import java.util.List;

public class ValidationTest {
    public static void main(String[] args) {
        User user = new User();
        user.setName("    ");
        user.setAge(801);
        user.setPhone("13229031081");
        List<String> invalids = ValidatorUtil.valid(user);
        for(String message:invalids){
            System.out.println(message);
        }
    }
}
