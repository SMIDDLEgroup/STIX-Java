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
 * ipv6-addr
 * <p>
 * The IPv6 Address Object represents one or more IPv6 addresses expressed using CIDR notation.
 */
@Value.Immutable
@Serial.Version(1L)
@DefaultTypeValue(value = "ipv6-addr", groups = {DefaultValuesProcessor.class})
@Value.Style(typeAbstract = "*Coo", typeImmutable = "*", validationMethod = Value.Style.ValidationMethod.NONE, additionalJsonAnnotations = {JsonTypeName.class}, depluralize = true)
@JsonInclude(value = NON_EMPTY, content = NON_EMPTY)
@JsonTypeName("ipv6-addr")
@JsonSerialize(as = Ipv6Address.class)
@JsonDeserialize(builder = Ipv6Address.Builder.class)
@JsonPropertyOrder({"type", "extensions", "value", "resolves_to_refs", "belongs_to_refs"})
public interface Ipv6AddressCoo extends CyberObservableObject {
    // TODO  Consider using regexp to validate:
    // http://blog.markhatton.co.uk/2011/03/15/regular-expressions-for-ip-addresses-cidr-ranges-and-hostnames/

    /**
     * If a given IPv6 Address Object represents a single IPv6 address, the CIDR /128 suffix MAY be omitted.
     * (Required)
     */
    @JsonProperty("value")
    @JsonPropertyDescription("Specifies one or more IPv6 addresses expressed using CIDR notation.")
    String getValue();

    /**
     * The objects referenced in this list MUST be of type mac-addr.
     */
    @JsonProperty("resolves_to_refs")
    @JsonPropertyDescription("Specifies a list of references to one or more Layer 2 Media Access Control (MAC) addresses that the IPv4 address resolves to.")
    Set<String> getResolvesToRefs();

    /**
     * The objects referenced in this list MUST be of type autonomous-system.
     */
    @JsonProperty("belongs_to_refs")
    @JsonPropertyDescription("Specifies a reference to one or more autonomous systems (AS) that the IPv4 address belongs to.")
    Set<String> getBelongsToRefs();

}
