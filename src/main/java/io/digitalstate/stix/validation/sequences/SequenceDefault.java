package io.digitalstate.stix.validation.sequences;

import io.digitalstate.stix.validation.groups.DefaultValuesProcessor;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

@GroupSequence({DefaultValuesProcessor.class, Default.class})
public interface SequenceDefault {
}
