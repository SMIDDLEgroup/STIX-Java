package io.digitalstate.stix.sro;

import io.digitalstate.stix.common.StixCommonProperties;
import io.digitalstate.stix.common.StixCustomProperties;
import io.digitalstate.stix.common.StixLabels;
import io.digitalstate.stix.common.StixModified;
import io.digitalstate.stix.common.StixRevoked;

import java.io.Serializable;

public interface RelationshipObject extends Serializable,
        StixCommonProperties,
        StixCustomProperties,
        StixLabels,
        StixModified,
        StixRevoked {

}
