package com.example.music_plus.utils.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegexCharValidator implements ConstraintValidator<RegexCharConstraint,String> {
    @Override
    public void initialize(RegexCharConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("^[a-zA-Z0-9]*$");
    }
}
