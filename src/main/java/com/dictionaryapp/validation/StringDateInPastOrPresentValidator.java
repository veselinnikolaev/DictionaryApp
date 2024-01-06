package com.dictionaryapp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class StringDateInPastOrPresentValidator implements ConstraintValidator<StringDateInPastOrPresent, String> {


    @Override
    public void initialize(StringDateInPastOrPresent constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value != null && !value.isBlank()) {
            LocalDate parse = LocalDate.parse(value);
            return parse.isBefore(LocalDate.now()) || parse.isEqual(LocalDate.now());
        }
        return false;
    }
}
