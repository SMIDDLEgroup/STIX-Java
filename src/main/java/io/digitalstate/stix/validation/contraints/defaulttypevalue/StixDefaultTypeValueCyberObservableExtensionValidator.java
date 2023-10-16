package io.digitalstate.stix.validation.contraints.defaulttypevalue;

import io.digitalstate.stix.coo.extension.CyberObservableExtension;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * This is used on any class that implements <strong>CyberObservableObject</strong>.
 */
public class StixDefaultTypeValueCyberObservableExtensionValidator implements ConstraintValidator<DefaultTypeValue, CyberObservableExtension> {

    private String defaultTypeValue;

    @Override
    public void initialize(DefaultTypeValue relationshipTypeLimitConstraint) {
        defaultTypeValue = relationshipTypeLimitConstraint.value();
    }

    @Override
    public boolean isValid(CyberObservableExtension cyberObservableExtension, ConstraintValidatorContext cxt) {
        return true;
    }
}

