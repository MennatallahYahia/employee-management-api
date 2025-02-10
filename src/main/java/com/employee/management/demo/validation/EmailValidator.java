package com.employee.management.demo.validation;

import com.employee.management.demo.annotation.ValidEmail;
import com.employee.management.demo.service.EmailValidationService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    private final EmailValidationService emailValidationService;

    public EmailValidator(EmailValidationService emailValidationService) {
        this.emailValidationService = emailValidationService;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return emailValidationService.isValidEmail(email);
    }
}
