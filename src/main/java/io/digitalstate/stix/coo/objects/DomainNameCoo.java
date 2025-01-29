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

import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * domain-name
 * <p>
 * The Domain Name represents the properties of a network domain name.
 */
@Value.Immutable
@Serial.Version(1L)
@DefaultTypeValue(value = "domain-name", groups = {DefaultValuesProcessor.class})
@Value.Style(typeAbstract = "*Coo", typeImmutable = "*", validationMethod = Value.Style.ValidationMethod.NONE, additionalJsonAnnotations = {JsonTypeName.class}, depluralize = true)
@JsonTypeName("domain-name")
@JsonSerialize(as = DomainName.class)
@JsonDeserialize(builder = DomainName.Builder.class)
@JsonPropertyOrder({"type", "extensions", "value", "resolves_to_refs"})
@JsonInclude(value = NON_EMPTY, content = NON_EMPTY)
public interface DomainNameCoo extends CyberObservableObject {

    @JsonProperty("value")
    @JsonPropertyDescription("Specifies the value of the domain name.")
    String getValue();

    @JsonProperty("resolves_to_refs")
    @JsonPropertyDescription("Specifies a list of references to one or more IP addresses or domain names that the domain name resolves to.")
    Set<String> getResolvesToRefs();
}
