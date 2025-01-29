package io.digitalstate.stix.validation.sequences;

import io.digitalstate.stix.validation.groups.DefaultValuesProcessor;
import io.digitalstate.stix.validation.groups.ValidateIdOnly;

import jakarta.validation.GroupSequence;

@GroupSequence({DefaultValuesProcessor.class, ValidateIdOnly.class})
public interface SequenceValidationIdOnly {
}
