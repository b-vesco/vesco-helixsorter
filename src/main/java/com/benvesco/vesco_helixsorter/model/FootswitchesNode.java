package com.benvesco.vesco_helixsorter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Holds assignments for every footswitch. I'm not sure of the max size for each
 * array or if a {@code null} is allowed in the saved json. When a switch is
 * pressed it will toggle the state of every block within. This is even true for
 * the toe-switch.
 * 
 * @author bvesco
 */
public class FootswitchesNode {
    /** This is the toe-switch that only controls on/off or min/max toggles */
    @JsonProperty("@fsExp")
    public Footswitch[] fsExp;

    @JsonProperty("@fs1")
    public Footswitch[] fs1;

    @JsonProperty("@fs2")
    public Footswitch[] fs2;

    @JsonProperty("@fs3")
    public Footswitch[] fs3;

    @JsonProperty("@fs4")
    public Footswitch[] fs4;

    @JsonProperty("@fs5")
    public Footswitch[] fs5;

    // @fs6 probably reserved for "MODE" button
    // @JsonProperty("@fs6")
    // public Footswitch[] fs6;

    @JsonProperty("@fs7")
    public Footswitch[] fs7;

    @JsonProperty("@fs8")
    public Footswitch[] fs8;

    @JsonProperty("@fs9")
    public Footswitch[] fs9;

    @JsonProperty("@fs10")
    public Footswitch[] fs10;

    @JsonProperty("@fs11")
    public Footswitch[] fs11;

    // @fs12 probably reserved for "TAP" button
    // @JsonProperty("@fs12")
    // public Footswitch[] fs12;
}
