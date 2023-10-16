package io.digitalstate.stix.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.digitalstate.stix.validation.contraints.startswith.StartsWith;
import org.immutables.value.Value;

/**
 *
 */
@Value.Style(validationMethod = Value.Style.ValidationMethod.NONE)
public interface StixCustomObjectId {

    @JsonProperty("id")
    @JsonPropertyDescription("Represents identifiers across the CTI specifications. The format consists of the name of the top-level object being identified, followed by two dashes (--), followed by a UUIDv4.")
    @StartsWith("x-")
    String getId();

}
