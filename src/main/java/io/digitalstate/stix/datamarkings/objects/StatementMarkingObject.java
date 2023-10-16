package io.digitalstate.stix.datamarkings.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.digitalstate.stix.datamarkings.StixMarkingObject;
import io.digitalstate.stix.redaction.Redactable;
import io.digitalstate.stix.validation.GenericValidation;
import org.immutables.serial.Serial;
import org.immutables.value.Value;

@Value.Immutable @Serial.Version(1L)
@Value.Style(typeImmutable = "Statement", additionalJsonAnnotations = {JsonTypeName.class}, validationMethod = Value.Style.ValidationMethod.NONE, depluralize = true)
@JsonSerialize(as = Statement.class) @JsonDeserialize(builder = Statement.Builder.class)
@Redactable
@JsonTypeName("statement")
public interface StatementMarkingObject extends GenericValidation, StixMarkingObject {

    @JsonProperty("statement")
    String getStatement();

}
