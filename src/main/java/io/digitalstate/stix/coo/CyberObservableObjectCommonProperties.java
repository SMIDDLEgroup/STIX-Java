package io.digitalstate.stix.coo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.digitalstate.stix.coo.extension.CyberObservableExtension;
import io.digitalstate.stix.coo.json.extension.CyberObservableExtensionsFieldDeserializer;
import io.digitalstate.stix.coo.json.extension.CyberObservableExtensionsFieldSerializer;
import io.digitalstate.stix.sdo.objects.ObservedDataSdo;
import io.digitalstate.stix.validation.GenericValidation;
import org.immutables.value.Value;

import java.util.Set;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

public interface CyberObservableObjectCommonProperties extends GenericValidation {

    @JsonProperty("type")
    @JsonPropertyDescription("Indicates that this object is an Observable Object. The value of this property MUST be a valid Observable Object type name, but to allow for custom objects this has been removed from the schema.")
    String getType();

    /**
     * Multiple extensions can be added, but only 1 instance of a specific extension can be added.
     *
     * @return
     */
    // @TODO Add validation to ensure that only 1 instance of each extension is applied as per the spec
    @JsonProperty("extensions")
    @JsonInclude(value = NON_EMPTY, content = NON_EMPTY)
    @JsonPropertyDescription("Specifies any extensions of the object, as a dictionary.")
    @JsonSerialize(using = CyberObservableExtensionsFieldSerializer.class)
    @JsonDeserialize(using = CyberObservableExtensionsFieldDeserializer.class)
    Set<CyberObservableExtension> getExtensions();

    /**
     * Used for generation of Map Keys by {@link ObservedDataSdo#getObjects()}
     * Manually set this value if you want to control key names.  Otherwise UUIDs will be used.
     *
     * @return
     */
    @JsonProperty(value = "observable_object_key", access = JsonProperty.Access.WRITE_ONLY)
    @Value.Default
    default String getObservableObjectKey() {
        return UUID.randomUUID().toString();
    }

}
