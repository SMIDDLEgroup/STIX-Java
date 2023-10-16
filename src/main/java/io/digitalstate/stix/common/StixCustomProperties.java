package io.digitalstate.stix.common;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.Map;

/**
 * Stix Custom Properties
 */
public interface StixCustomProperties {

    /**
     * Custom Properties for STIX Objects.
     * Any object that supports custom properties will have a validation of the custom property prefix (typically "x_").
     * If the additional property in the JSON does not meet the StartsWith condition, then the JSON will be rejected.
     * @return Map of custom properties {@code Map<String, Object>}
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonUnwrapped @JsonAnyGetter
    Map<String, Object> getCustomProperties();

}
