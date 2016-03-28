package com.benvesco.vesco_helixsorter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Common fields.
 * 
 * @author bvesco
 */
public class BaseBlockNode extends FreeformJson {
    /** What type of block this is. The "model" used here. */
    @JsonProperty("@model")
    public String model = "no model detected";

    /** Where the block is situated */
    @JsonProperty("@position")
    public long position;
}
