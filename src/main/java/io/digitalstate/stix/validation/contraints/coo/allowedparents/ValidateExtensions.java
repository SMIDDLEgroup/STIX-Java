package io.digitalstate.stix.validation.contraints.coo.allowedparents;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Used to Validation Cyber Observable Extensions
 * Should only be placed on Cyber Observable Object classes.
 */
@Documented
@Constraint(validatedBy = {StixValidateParentCooValidator.class})
@Target({ANNOTATION_TYPE, TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateExtensions {
    String message() default "{io.digitalstate.stix.validation.contraints.coo.allowedparents.ValidateReferences}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
