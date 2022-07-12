package com.example.exam_module4.utils.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegexEmailValidator implements ConstraintValidator<RegexEmailConstraint, String> {
    @Override
    public void initialize(RegexEmailConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
