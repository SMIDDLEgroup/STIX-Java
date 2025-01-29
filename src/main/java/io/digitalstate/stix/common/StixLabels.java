package io.digitalstate.stix.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.digitalstate.stix.redaction.Redactable;
import org.hibernate.validator.constraints.Length;
import org.immutables.value.Value;

import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 *
 */
@Value.Style(validationMethod = Value.Style.ValidationMethod.NONE)
public interface StixLabels {

    @JsonProperty("labels")
    @JsonInclude(NON_EMPTY)
    @JsonPropertyDescription("The labels property specifies a set of classifications.")
    @Redactable
    Set<@Length(min = 1) String> getLabels();@Leng

}
