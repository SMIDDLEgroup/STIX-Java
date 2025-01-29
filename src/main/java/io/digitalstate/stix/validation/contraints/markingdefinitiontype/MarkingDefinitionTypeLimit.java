package io.digitalstate.stix.validation.contraints.markingdefinitiontype;

import io.digitalstate.stix.datamarkings.StixMarkingObject;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;

/**
 * To only be used on STIX MarkingDefinition class.
 * The annotation provides a Javax Validation that enforces Marking Definition Types based on the actual definition being used.
 * This annotation enforces the STIX Relationship Type restrictions for each SDO.
 */
@Documented
@Constraint(validatedBy = {StixMarkingDefinitionTypeLimitValidator.class})
@Target({ANNOTATION_TYPE, TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MarkingDefinitionTypeLimit.List.class)
public @interface MarkingDefinitionTypeLimit {
    String message() default "{io.digitalstate.stix.validation.contraints.markingdefinitiontype.MarkingDefinitionTypeLimit}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<? extends StixMarkingObject> markingObject();

    String markingDefinitionType();

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ANNOTATION_TYPE, TYPE})
    @interface List {
        MarkingDefinitionTypeLimit[] value();
    }
}
