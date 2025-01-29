package io.digitalstate.stix.validation.contraints.markingdefinitiontype;

import io.digitalstate.stix.datamarkings.MarkingDefinitionDm;
import io.digitalstate.stix.datamarkings.StixMarkingObject;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StixMarkingDefinitionTypeLimitValidator implements ConstraintValidator<MarkingDefinitionTypeLimit, MarkingDefinitionDm> {

    private Class<? extends StixMarkingObject> markingObject;
    private String markingDefinitionType;

    @Override
    public void initialize(MarkingDefinitionTypeLimit markingDefinitionTypeLimitConstraint) {
        markingObject = markingDefinitionTypeLimitConstraint.markingObject();
        markingDefinitionType = markingDefinitionTypeLimitConstraint.markingDefinitionType();
    }

    @Override
    public boolean isValid(MarkingDefinitionDm markingDefinitionDm, ConstraintValidatorContext cxt) {
        return true;
    }
}
