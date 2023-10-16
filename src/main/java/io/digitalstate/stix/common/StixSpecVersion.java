package io.digitalstate.stix.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.immutables.value.Value;

public interface StixSpecVersion {

    /**
     * Helper attribute to track the STIX Spec Version that was used for this object.
     * @return String of STIX Spec Version, example: "2.0"
     */
    @JsonIgnore
    @Value.Lazy
    default String getSpecVersion(){
        return io.digitalstate.stix.helpers.StixSpecVersion.SPECVERSION;
    }

}
