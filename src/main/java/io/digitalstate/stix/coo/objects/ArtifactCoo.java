package io.digitalstate.stix.coo.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.digitalstate.stix.coo.CyberObservableObject;
import io.digitalstate.stix.validation.contraints.businessrule.BusinessRule;
import io.digitalstate.stix.validation.contraints.defaulttypevalue.DefaultTypeValue;
import io.digitalstate.stix.validation.contraints.hashingvocab.HashingVocab;
import io.digitalstate.stix.validation.groups.DefaultValuesProcessor;
import io.digitalstate.stix.vocabulary.vocabularies.HashingAlgorithms;
import org.hibernate.validator.constraints.Length;
import org.immutables.serial.Serial;
import org.immutables.value.Value;

import java.util.Map;
import java.util.Optional;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * artifact
 * <p>
 * The Artifact Object permits capturing an array of bytes (8-bits), as a base64-encoded string string, or linking to a file-like payload.
 */
@Value.Immutable
@Serial.Version(1L)
@DefaultTypeValue(value = "artifact", groups = {DefaultValuesProcessor.class})
@Value.Style(typeAbstract = "*Coo", typeImmutable = "*", validationMethod = Value.Style.ValidationMethod.NONE, additionalJsonAnnotations = {JsonTypeName.class}, depluralize = true, depluralizeDictionary = {"hash:hashes"})
@JsonTypeName("artifact")
@JsonSerialize(as = Artifact.class)
@JsonDeserialize(builder = Artifact.Builder.class)
@JsonPropertyOrder({"type", "extensions", "mime_type", "payload_bin", "url", "hashes"})
@JsonInclude(value = NON_EMPTY, content = NON_EMPTY)
@BusinessRule(ifExp = "getUrl().isPresent() == true", thenExp = "getHashes().isEmpty() == false && getPayloadBin().isPresent() == false", errorMessage = "When Url is used, Hashes have at least 1 value, and payload_bin cannot be used.")
@BusinessRule(ifExp = "getPayloadBin().isPresent() == true", thenExp = "getUrl().isPresent() == false && getHashes().isEmpty() == true", errorMessage = "When payload_bin is used, Url and hashes cannot be used.")
public interface ArtifactCoo extends CyberObservableObject {

    /**
     * The value of this property MUST be a valid MIME type as specified in the IANA Media Types registry.
     */
    @JsonProperty("mime_type")
    @JsonPropertyDescription("The value of this property MUST be a valid MIME type as specified in the IANA Media Types registry.")
    Optional<String> getMimeType();

    @JsonProperty("payload_bin")
    @JsonPropertyDescription("Specifies the binary data contained in the artifact as a base64-encoded string.")
        //Removed the @pattern from within the optional until it is clear on the usage and expectation.
        //@Pattern(regexp = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$")
    Optional<String> getPayloadBin();

    /**
     * url-regex
     * <p>
     * Matches the elements of a URL using a regular expression. Uses Diego Perini's regex from https://gist.github.com/dperini/729294.
     */
    @JsonProperty("url")
    @JsonPropertyDescription("The value of this property MUST be a valid URL that resolves to the unencoded content.")
    //@TODO review if the @Url constraint can be used instead.
    Optional<String> getUrl();

    //@TODO review logic requirements for Redactable on Hash values

    /**
     * hashes
     * <p>
     * This MUST be provided when the url property is present.  Optional if payload_bin is present.
     */
    @JsonProperty("hashes")
    @JsonPropertyDescription("Specifies a dictionary of hashes for the contents of the url or the payload_bin.")
    Map<@Length(min = 3, max = 256) @HashingVocab(HashingAlgorithms.class) String, String> getHashes();

}
