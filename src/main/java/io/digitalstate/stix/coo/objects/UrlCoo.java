package io.digitalstate.stix.coo.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.digitalstate.stix.coo.CyberObservableObject;
import io.digitalstate.stix.validation.contraints.defaulttypevalue.DefaultTypeValue;
import io.digitalstate.stix.validation.groups.DefaultValuesProcessor;
import org.immutables.serial.Serial;
import org.immutables.value.Value;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * url
 * <p>
 * The URL Object represents the properties of a uniform resource locator (URL).
 */
@Value.Immutable
@Serial.Version(1L)
@DefaultTypeValue(value = "url", groups = {DefaultValuesProcessor.class})
@Value.Style(typeAbstract = "*Coo", typeImmutable = "*", validationMethod = Value.Style.ValidationMethod.NONE, additionalJsonAnnotations = {JsonTypeName.class}, depluralize = true)
@JsonTypeName("url")
@JsonSerialize(as = Url.class)
@JsonDeserialize(builder = Url.Builder.class)
@JsonPropertyOrder({"type", "extensions", "value"})
@JsonInclude(value = NON_EMPTY, content = NON_EMPTY)
public interface UrlCoo extends CyberObservableObject {

    /**
     * The value of this property MUST conform to [RFC3986], more specifically section 1.1.3
     * with reference to the definition for "Uniform Resource Locator"
     * (Required)
     */
    //@TODO can this be changed from @Pattern to @URL?
    @JsonProperty("value")
    @JsonPropertyDescription("Specifies the value of the URL.")
    String getValue();

}
