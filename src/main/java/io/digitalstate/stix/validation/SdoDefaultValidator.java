package io.digitalstate.stix.validation;

import io.digitalstate.stix.validation.sequences.SequenceDefault;
import io.digitalstate.stix.validation.sequences.SequenceValidationIdOnly;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Set;

public interface SdoDefaultValidator {

    Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    default void validate() throws ConstraintViolationException {
        Set<ConstraintViolation<SdoDefaultValidator>> violations = VALIDATOR.validate(this, SequenceDefault.class);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    default void validateOnlyId() throws ConstraintViolationException {
        Set<ConstraintViolation<SdoDefaultValidator>> violations = VALIDATOR.validate(this, SequenceValidationIdOnly.class);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}




