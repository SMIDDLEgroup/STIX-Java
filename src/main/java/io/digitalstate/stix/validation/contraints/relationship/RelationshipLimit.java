package io.digitalstate.stix.validation.contraints.relationship;

import io.digitalstate.stix.sdo.DomainObject;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;

@Documented
@Constraint(validatedBy = {StixRelationshipLimitValidator.class})
@Target({ANNOTATION_TYPE, TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(RelationshipLimit.List.class)
public @interface RelationshipLimit {
    String message() default "{io.digitalstate.stix.validation.contraints.relationship.RelationshipLimit}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<? extends DomainObject> source();

    String relationshipType();

    Class<? extends DomainObject>[] target();

    boolean classEquality() default false;

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ANNOTATION_TYPE, TYPE})
    @interface List {
        RelationshipLimit[] value();
    }

}