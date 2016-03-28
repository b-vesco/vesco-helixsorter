package com.benvesco.vesco_helixsorter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Represents a single footswtich assignment. A physical footswitch could have
 * many of these if assigned to multiple functions.
 * 
 * @author bvesco
 */
public class Footswitch extends FreeformJson {
    /** Which dsp path this switch is assigned to */
    // Examples: 0, 1
    @JsonProperty("@dsp")
    public long dsp = 0;

    /** Determines if switch is 'on' when patch is recalled */
    @JsonProperty("@enabled")
    public boolean enabled = true;

    /** Which block this switch is assigned to */
    // Examples: block1, block2, block3, ... , blockN
    @JsonProperty("@group")
    public String group = "block1";

    /** The text displayed on the scribble strip, may not apply to Exp1/Exp2 */
    @JsonProperty("@label")
    public String label = "no label";

    /** The displayed color for the LED ring, no sure in what format */
    // Examples: 65408, 458496, 8716032, etc.
    @JsonProperty("@ledcolor")
    public long ledcolor = 0;

    /** false: switch is latching, true: switch is momentary */
    @JsonProperty("@momentary")
    public boolean momentary = false;

    /** Not sure what this is */
    // Examples: 0, 1, 2, ... , n (have seen at least as high as 7)
    @JsonProperty("@type")
    public long type = 0;

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
