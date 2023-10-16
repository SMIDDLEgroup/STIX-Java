package io.digitalstate.stix.validation.contraints.defaulttypevalue;

import io.digitalstate.stix.bundle.BundleableObject;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * This is used on any class that implements <strong>BundleableObject</strong>.
 */
public class StixDefaultTypeValueBundleableValidator implements ConstraintValidator<DefaultTypeValue, BundleableObject> {

    private String defaultTypeValue;

    @Override
    public void initialize(DefaultTypeValue relationshipTypeLimitConstraint) {
        defaultTypeValue = relationshipTypeLimitConstraint.value();
    }

    @Override
    public boolean isValid(BundleableObject bundleableObject, ConstraintValidatorContext cxt) {
        return true;
    }
}

