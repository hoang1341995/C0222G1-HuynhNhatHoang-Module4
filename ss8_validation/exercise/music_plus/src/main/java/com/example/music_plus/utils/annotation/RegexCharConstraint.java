package com.example.music_plus.utils.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = RegexCharValidator.class)
public @interface RegexCharConstraint {
String message()default"Không đúng định dạng";
Class<?>[] groups() default{};
Class<? extends Payload> [] payload() default {};
}
