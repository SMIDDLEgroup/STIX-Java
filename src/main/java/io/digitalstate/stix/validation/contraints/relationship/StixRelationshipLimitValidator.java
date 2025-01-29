package io.digitalstate.stix.validation.contraints.relationship;

import io.digitalstate.stix.sdo.DomainObject;
import io.digitalstate.stix.sro.objects.RelationshipSro;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StixRelationshipLimitValidator implements ConstraintValidator<RelationshipLimit, RelationshipSro> {

    private Class<? extends DomainObject> source;
    private String relationshipType;
    private Class<? extends DomainObject>[] target;
    private boolean classEquality;

    @Override
    public void initialize(RelationshipLimit relationshipLimit) {
        source = relationshipLimit.source();
        target = relationshipLimit.target();
        relationshipType = relationshipLimit.relationshipType();
        classEquality = relationshipLimit.classEquality();
    }

    @Override
    public boolean isValid(RelationshipSro object, ConstraintValidatorContext cxt) {
        return true;
    }
}
