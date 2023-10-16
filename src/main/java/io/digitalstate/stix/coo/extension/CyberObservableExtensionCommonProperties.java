package io.digitalstate.stix.coo.extension;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;

@Value.Style(validationMethod = Value.Style.ValidationMethod.NONE)
public interface CyberObservableExtensionCommonProperties {

    /**
     * This property is used for generation of the dictionary during serialization, and used as the "Type" mapping value for polymorphic when deserializing.
     * @return
     */
    @JsonIgnore
    @JsonProperty("type")
    String getType();

}
