package io.digitalstate.stix.validation.contraints.defaulttypevalue;

import io.digitalstate.stix.bundle.BundleObject;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * This is used solely for a STIX Bundle.
 */
public class StixDefaultTypeValueBundleObjectValidator implements ConstraintValidator<DefaultTypeValue, BundleObject> {

    private String defaultTypeValue;

    @Override
    public void initialize(DefaultTypeValue relationshipTypeLimitConstraint) {
        defaultTypeValue = relationshipTypeLimitConstraint.value();
    }

    @Override
    public boolean isValid(BundleObject bundleObject, ConstraintValidatorContext cxt) {
        return true;
    }
}

