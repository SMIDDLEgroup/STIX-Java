package io.digitalstate.stix.validation.contraints.relationship;

import io.digitalstate.stix.sdo.DomainObject;
import io.digitalstate.stix.sro.objects.RelationshipSro;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class StixRelationshipTypeLimitValidator implements ConstraintValidator<RelationshipTypeLimit, RelationshipSro> {

    private Class<? extends DomainObject> source;
    private String[] relationshipTypes;
    private String[] commonRelationshipsTypes;
    private boolean enforceCommonRelationshipTypes;

    @Override
    public void initialize(RelationshipTypeLimit relationshipTypeLimitConstraint) {
        source = relationshipTypeLimitConstraint.source();
        relationshipTypes = relationshipTypeLimitConstraint.relationshipTypes();
        commonRelationshipsTypes = relationshipTypeLimitConstraint.commonRelationshipTypes();
        enforceCommonRelationshipTypes = relationshipTypeLimitConstraint.enforceCommonRelationshipTypes();
    }

    @Override
    public boolean isValid(RelationshipSro relationshipSro, ConstraintValidatorContext cxt) {
        return true;
    }
}
