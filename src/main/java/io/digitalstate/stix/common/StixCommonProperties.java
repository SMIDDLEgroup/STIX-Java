package io.digitalstate.stix.common;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.digitalstate.stix.bundle.BundleableObject;
import io.digitalstate.stix.datamarkings.GranularMarkingDm;
import io.digitalstate.stix.datamarkings.MarkingDefinitionDm;
import io.digitalstate.stix.json.StixParsers;
import io.digitalstate.stix.json.converters.dehydrated.DomainObjectOptionalConverter;
import io.digitalstate.stix.json.converters.dehydrated.MarkingDefinitionSetConverter;
import io.digitalstate.stix.redaction.Redactable;
import io.digitalstate.stix.sdo.objects.IdentitySdo;
import io.digitalstate.stix.sdo.types.ExternalReferenceType;
import io.digitalstate.stix.validation.SdoDefaultValidator;
import io.digitalstate.stix.validation.groups.ValidateIdOnly;
import org.immutables.value.Value;

import javax.validation.ConstraintViolationException;
import java.util.Optional;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * Base interface used by Immutable STIX Bundleable Objects
 */
@Value.Style(validationMethod = Value.Style.ValidationMethod.NONE)
public interface StixCommonProperties extends StixSpecVersion, SdoDefaultValidator, BundleableObject {

    /**
     * Dictates if the object is hydrated.
     * Hydration is defined as if the Object has only a "ID" or has been properly
     * hydrated with the expected required fields
     * @return boolean
     */
    @Value.Default
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    default boolean getHydrated(){
        return true;
    }

    @JsonProperty("type")
    @JsonPropertyDescription("The type property identifies the type of STIX Object (SDO, Relationship Object, etc). The value of the type field MUST be one of the types defined by a STIX Object (e.g., indicator).")
    String getType();

    @JsonProperty("id")
    @JsonPropertyDescription("Represents identifiers across the CTI specifications. The format consists of the name of the top-level object being identified, followed by two dashes (--), followed by a UUIDv4.")
    String getId();

    @JsonProperty("created_by_ref") @JsonInclude(value = NON_EMPTY, content = NON_EMPTY)
    @JsonPropertyDescription("Represents identifiers across the CTI specifications. The format consists of the name of the top-level object being identified, followed by two dashes (--), followed by a UUIDv4.")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonDeserialize(converter = DomainObjectOptionalConverter.class)
    @Redactable(useMask = true, redactionMask = "identity--__REDACTED__")
    Optional<IdentitySdo> getCreatedByRef();

    @JsonProperty("created")
    @JsonPropertyDescription("The created property represents the time at which the first version of this object was created. The timstamp value MUST be precise to the nearest millisecond.")
    @Value.Default
    @Redactable(useMask = true)
    default StixInstant getCreated(){
        return new StixInstant();
    }

    @JsonProperty("external_references") @JsonInclude(NON_EMPTY)
    @JsonPropertyDescription("A list of external references which refers to non-STIX information.")
    @Redactable
    Set<ExternalReferenceType> getExternalReferences();

    @JsonProperty("object_marking_refs") @JsonInclude(NON_EMPTY)
    @JsonPropertyDescription("The list of marking-definition objects to be applied to this object.")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonDeserialize(converter = MarkingDefinitionSetConverter.class)
    @Redactable
    Set<MarkingDefinitionDm> getObjectMarkingRefs();

    @JsonProperty("granular_markings") @JsonInclude(NON_EMPTY)
    @JsonPropertyDescription("The set of granular markings that apply to this object.")
    @Redactable
    Set<GranularMarkingDm> getGranularMarkings();

    @JsonIgnore
    @Value.Lazy
    @Value.Auxiliary
    default String toJsonString() {
        try {
            String jsonString = StixParsers.getJsonMapper().writeValueAsString(this);
//            return BundleableObjectRedactionProcessor.processObject(this, jsonString, new HashSet<>(Arrays.asList()));
            return jsonString;
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Cannot process JSON", e);
        }
    }

    @Value.Check
    default void checkHydrationValidation() throws ConstraintViolationException {
        if (getHydrated()){
            this.validate();
        } else {
            this.validateOnlyId();
        }
    }

}
