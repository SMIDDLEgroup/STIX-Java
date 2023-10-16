package io.digitalstate.stix.sdo.objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.digitalstate.stix.bundle.BundleableObject;
import io.digitalstate.stix.common.StixInstant;
import io.digitalstate.stix.json.converters.dehydrated.BundleableObjectSetConverter;
import io.digitalstate.stix.redaction.Redactable;
import io.digitalstate.stix.sdo.DomainObject;
import io.digitalstate.stix.validation.contraints.defaulttypevalue.DefaultTypeValue;
import io.digitalstate.stix.validation.contraints.vocab.Vocab;
import io.digitalstate.stix.validation.groups.DefaultValuesProcessor;
import io.digitalstate.stix.vocabulary.vocabularies.ReportLabels;
import org.immutables.serial.Serial;
import org.immutables.value.Value;

import java.util.Optional;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * report
 * <p>
 * Reports are collections of threat intelligence focused on one or more topics, such as a 
 * description of a threat actor, malware, or attack technique, including context and related details.
 * 
 */
@Value.Immutable @Serial.Version(1L)
@JsonTypeName("report")
@DefaultTypeValue(value = "report", groups = {DefaultValuesProcessor.class})
@Value.Style(typeAbstract="*Sdo", typeImmutable="*", validationMethod = Value.Style.ValidationMethod.NONE, additionalJsonAnnotations = {JsonTypeName.class}, depluralize = true)
@JsonSerialize(as = Report.class) @JsonDeserialize(builder = Report.Builder.class)
@JsonPropertyOrder({"type", "id", "created_by_ref", "created",
        "modified", "revoked", "labels", "external_references",
        "object_marking_refs", "granular_markings", "name", "description",
        "published", "object_refs"})
@Redactable
public interface ReportSdo extends DomainObject {

    @Override
    @JsonPropertyDescription("This field is an Open Vocabulary that specifies the primary subject of this report. The suggested values for this field are in report-label-ov.")
    @Redactable(useMask = true)
    Set<@Vocab(ReportLabels.class) String> getLabels();

    @JsonProperty("name")
    @JsonPropertyDescription("A description that provides more details and context about Report.")
    @Redactable(useMask = true)
    String getName();

    @JsonProperty("description") @JsonInclude(value = NON_EMPTY, content= NON_EMPTY)
    @JsonPropertyDescription("A description that provides more details and context about Report.")
    @Redactable
    Optional<String> getDescription();

    @JsonProperty("published")
    @JsonPropertyDescription("The date that this report object was officially published by the creator of this report.")
    @Redactable(useMask = true)
    StixInstant getPublished();

    @JsonProperty("object_refs")
    @JsonPropertyDescription("Specifies the STIX Objects that are referred to by this Report.")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonDeserialize( converter = BundleableObjectSetConverter.class)
    @Redactable(useMask = true)
    Set<BundleableObject> getObjectRefs();
}
