package io.digitalstate.stix.validation.contraints.startswith;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StixStartsWithValidatorString implements ConstraintValidator<StartsWith, String> {

    private String prefix;

    @Override
    public void initialize(StartsWith startsWithConstraint) {
        prefix = startsWithConstraint.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cxt) {
        return true;
    }
}
