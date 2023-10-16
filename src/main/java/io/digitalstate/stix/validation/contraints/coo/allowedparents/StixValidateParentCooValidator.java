package io.digitalstate.stix.validation.contraints.coo.allowedparents;

import io.digitalstate.stix.coo.CyberObservableObject;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StixValidateParentCooValidator implements ConstraintValidator<ValidateExtensions, CyberObservableObject> {

    //@TODO ADD LOGGING!!!
    @Override
    public boolean isValid(CyberObservableObject cyberObservableObject, ConstraintValidatorContext cxt) {
        return true;
    }
}
