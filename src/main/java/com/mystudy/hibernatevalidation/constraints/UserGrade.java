package com.mystudy.hibernatevalidation.constraints;

import com.mystudy.hibernatevalidation.validators.UserGradeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {UserGradeValidator.class})
@Target({ElementType.FIELD})
@Retention(RUNTIME)
public @interface UserGrade {
    Class<?>[] groups() default {};

    String message() default "用户等级格式错误:green|common";

    Class<? extends Payload>[] payload() default {};
}

