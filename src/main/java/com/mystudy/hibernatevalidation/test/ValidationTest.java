package com.mystudy.hibernatevalidation.test;

import com.mystudy.hibernatevalidation.entity.User;
import com.mystudy.hibernatevalidation.entity.VipUser;
import com.mystudy.hibernatevalidation.util.ValidatorUtil;

import java.time.LocalDateTime;
import java.util.List;

public class ValidationTest {
    public static void main(String[] args) {
        User user = new User();

        //user.setId(1l);
        user.setName("  ");
        user.setPhone("13229031081");
        user.setAge(19);
        user.setEmail("1642228@qq.com");
        user.setPersonalPage("https://github.com");
        user.setGrade("commn");
        user.setBirthday(LocalDateTime.now().minusDays(1));
        List<String> invalids = ValidatorUtil.valid(user);
        for (String message : invalids) {
            System.out.println(message);
        }

        System.out.println();

        VipUser vipUser = new VipUser();
        vipUser.setAge(17);
        invalids = ValidatorUtil.valid(vipUser, VipUser.VipToken.class);
        for (String message : invalids) {
            System.out.println(message);
        }

        System.out.println();

        //invalids = ValidatorUtil.validFailFast(user);
        for (String message : invalids) {
            System.out.println(message);
        }

    }
}
