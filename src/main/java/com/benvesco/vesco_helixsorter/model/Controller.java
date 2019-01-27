package com.benvesco.vesco_helixsorter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Data to describe a single expression pedal assignment
 *
 * @author bvesco
 */
public class Controller {
    /** Which dsp path this switch is assigned to */
    // Examples: 0, 1
    @JsonProperty("@dsp")
    public long dsp = 0;

    /** Which block this switch is assigned to */
    // Examples: block1, block2, block3, ... , blockN
    @JsonProperty("@group")
    public String group = "block1";

    /** A mixed-type node to describe the minimum value */
    // Examples: 0, 0.11, false, 8000
    @JsonProperty("@min")
    public JsonNode min = null;

    /** A mixed-type node to describe the maximum value */
    // Examples: 1, 0.27, true, 4900
    @JsonProperty("@max")
    public JsonNode max = null;

    /** Name of the controlled param */
    // Examples: have only seen "Pedal" here so far
    @JsonProperty("@param")
    public String param = "Pedal";
}
