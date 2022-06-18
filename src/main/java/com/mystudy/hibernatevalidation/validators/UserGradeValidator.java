package com.mystudy.hibernatevalidation.validators;

import ch.qos.logback.core.boolex.EvaluationException;
import ch.qos.logback.core.boolex.Matcher;
import com.mystudy.hibernatevalidation.constraints.UserGrade;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class UserGradeValidator implements ConstraintValidator<UserGrade, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        Pattern pattern = Pattern.compile("^green|common");
        return pattern.matcher(value).matches();
    }

    @Override
    public void initialize(UserGrade constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
