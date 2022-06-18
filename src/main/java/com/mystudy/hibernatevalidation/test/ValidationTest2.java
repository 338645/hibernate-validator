package com.mystudy.hibernatevalidation.test;

import com.mystudy.hibernatevalidation.services.UserService;

public class ValidationTest2 {

    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.getByName(" ");
    }
}
