package com.employee.management.demo.annotation;

import com.employee.management.demo.validation.EmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmail {
    String message() default "The email address is invalid.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}