package com.example.exam_module4.utils.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegexPhoneNumberValidator implements ConstraintValidator<RegexPhoneNumberConstraint, String> {
    @Override
    public void initialize(RegexPhoneNumberConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("^(84|0[3|5|7|8|9])+([0-9]{8})$");
    }
}
