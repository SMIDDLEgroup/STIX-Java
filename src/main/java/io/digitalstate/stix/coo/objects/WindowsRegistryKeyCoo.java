package io.digitalstate.stix.coo.objects;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.digitalstate.stix.common.StixInstant;
import io.digitalstate.stix.coo.CyberObservableObject;
import io.digitalstate.stix.coo.types.WindowsRegistryValueObj;
import io.digitalstate.stix.validation.contraints.defaulttypevalue.DefaultTypeValue;
import io.digitalstate.stix.validation.groups.DefaultValuesProcessor;
import org.immutables.serial.Serial;
import org.immutables.value.Value;

import java.util.Optional;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * windows-registry-key
 * <p>
 * The Registry Key Object represents the properties of a Windows registry key.
 *
 */
@Value.Immutable @Serial.Version(1L)
@DefaultTypeValue(value = "windows-registry-key", groups = {DefaultValuesProcessor.class})
@Value.Style(typeAbstract="*Coo", typeImmutable="*", validationMethod = Value.Style.ValidationMethod.NONE, additionalJsonAnnotations = {JsonTypeName.class}, depluralize = true)
@JsonSerialize(as = WindowsRegistryKey.class) @JsonDeserialize(builder = WindowsRegistryKey.Builder.class)
@JsonInclude(value = NON_EMPTY, content= NON_EMPTY)
@JsonPropertyOrder({ "type", "key", "values", "modified", "creator_user_ref", "number_of_subkeys", "extensions" })
@JsonTypeName("windows-registry-key")
public interface WindowsRegistryKeyCoo extends CyberObservableObject {

    @JsonProperty("key")
    @JsonPropertyDescription("Specifies the full registry key including the hive.")
    String getKey();

    @JsonProperty("values")
    @JsonPropertyDescription("Specifies the values found under the registry key.")
    Set<WindowsRegistryValueObj> getValues();

    @JsonProperty("modified")
    @JsonPropertyDescription("Specifies the last date/time that the registry key was modified.")
    Optional<StixInstant> getModified();

    //@TODO Must be of type user-account
    @JsonProperty("creator_user_ref")
    @JsonPropertyDescription("Specifies a reference to a user account, represented as a User Account Object, that created the registry key.")
    Optional<String> getCreatorUserRef();

    @JsonProperty("number_of_subkeys")
    @JsonPropertyDescription("Specifies the number of subkeys contained under the registry key.")
    Optional<Long> getNumberOfSubkeys();

}
