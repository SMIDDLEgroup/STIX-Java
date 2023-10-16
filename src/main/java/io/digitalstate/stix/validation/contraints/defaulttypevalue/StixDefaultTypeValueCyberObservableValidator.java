package io.digitalstate.stix.validation.contraints.defaulttypevalue;

import io.digitalstate.stix.coo.CyberObservableObject;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * This is used on any class that implements <strong>CyberObservableObject</strong>.
 */
public class StixDefaultTypeValueCyberObservableValidator implements ConstraintValidator<DefaultTypeValue, CyberObservableObject> {

    private String defaultTypeValue;

    @Override
    public void initialize(DefaultTypeValue relationshipTypeLimitConstraint) {
        defaultTypeValue = relationshipTypeLimitConstraint.value();
    }

    @Override
    public boolean isValid(CyberObservableObject cyberObservableObject, ConstraintValidatorContext cxt) {
        return true;
    }
}

