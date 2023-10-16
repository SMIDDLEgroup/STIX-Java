package io.digitalstate.stix.sdo.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.digitalstate.stix.common.StixInstant;
import io.digitalstate.stix.redaction.Redactable;
import io.digitalstate.stix.sdo.DomainObject;
import io.digitalstate.stix.validation.contraints.defaulttypevalue.DefaultTypeValue;
import io.digitalstate.stix.validation.groups.DefaultValuesProcessor;
import org.immutables.serial.Serial;
import org.immutables.value.Value;

import java.util.Optional;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * campaign
 * <p>
 * A Campaign is a grouping of adversary behavior that describes a set of malicious activities or attacks that occur over a period of time against a specific set of targets.
 * 
 */
@Value.Immutable @Serial.Version(1L)
@JsonTypeName("campaign")
@DefaultTypeValue(value = "campaign", groups = {DefaultValuesProcessor.class})
@Value.Style(typeAbstract="*Sdo", typeImmutable="*", validationMethod = Value.Style.ValidationMethod.NONE, additionalJsonAnnotations = {JsonTypeName.class}, depluralize = true)
@JsonSerialize(as = Campaign.class) @JsonDeserialize(builder = Campaign.Builder.class)
@JsonPropertyOrder({"type", "id", "created_by_ref", "created",
        "modified", "revoked", "labels", "external_references",
        "object_marking_refs", "granular_markings", "name", "description",
        "aliases", "first_seen", "last_seen", "objective"})
@Redactable
public interface CampaignSdo extends DomainObject {

    @JsonProperty("name")
    @JsonPropertyDescription("The name used to identify the Campaign.")
    @Redactable(useMask = true)
    String getName();

    @JsonProperty("description")
    @JsonInclude(value = NON_EMPTY, content= NON_EMPTY)
    @JsonPropertyDescription("A description that provides more details and context about the Campaign, potentially including its purpose and its key characteristics.")
    @Redactable
    Optional<String> getDescription();

    @JsonProperty("aliases")
    @JsonInclude(value = NON_EMPTY, content= NON_EMPTY)
    @JsonPropertyDescription("Alternative names used to identify this campaign.")
    @Redactable
    Set<String> getAliases();

    @JsonProperty("first_seen")
    @JsonInclude(value = NON_EMPTY, content= NON_EMPTY)
    @JsonPropertyDescription("The time that this Campaign was first seen.")
    @Redactable
    Optional<StixInstant> getFirstSeen();

    //@TODO add support to ensure that Last Seen is AFTER the First Seen value
    @JsonProperty("last_seen") @JsonInclude(value = NON_EMPTY, content= NON_EMPTY)
    @JsonPropertyDescription("The time that this Campaign was last seen.")
    @Redactable
    Optional<StixInstant> getLastSeen();

    @JsonProperty("objective") @JsonInclude(value = NON_EMPTY, content= NON_EMPTY)
    @JsonPropertyDescription("This field defines the Campaign’s primary goal, objective, desired outcome, or intended effect.")
    @Redactable
    Optional<String> getObjective();

}
