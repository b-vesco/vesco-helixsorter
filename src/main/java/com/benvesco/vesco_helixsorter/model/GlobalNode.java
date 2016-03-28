package com.benvesco.vesco_helixsorter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GlobalNode {
    /** Probably which path has the block that loads selected on patch recall */
    // Examples: 0, 1
    @JsonProperty("@cursor_dsp")
    public long cursor_dsp = 0;

    /** Probably the block that is selected when the patch is recalled */
    // Examples: block1, block2, block3, ... , blockN
    @JsonProperty("@cursor_group")
    public String cursor_group = "block5";

    /** Not sure what this is */
    // Examples: have only seen 0 in this node
    @JsonProperty("@cursor_path")
    public long cursor_path = 0;

    /** Not sure what this is */
    // Examples: have only seen 0 in this node
    @JsonProperty("@cursor_position")
    public long cursor_position = 0;

    /** Not sure what this is */
    // Examples: have only seen "@global_params" in this node
    @JsonProperty("@model")
    public String model = "@global_params";

    /** Not sure what this is */
    // Examples: have only seen 2 in this node
    @JsonProperty("@pedalstate")
    public long pedalstate = 2;

    @JsonProperty("@tempo")
    public double tempo = 120.0;

    /** Examples: A, AB, SAB, SABJ, ABJ */
    @JsonProperty("@topology0")
    public String topology0 = "A";

    /** Examples: A, AB, SAB, SABJ, ABJ */
    @JsonProperty("@topology1")
    public String topology1 = "A";

    /** Not sure what this is */
    @JsonProperty("@variax_customtuning")
    public boolean variax_customtuning = true;

    /** Not sure what this is */
    // Examples: have only seen 0 in this node
    @JsonProperty("@variax_lockctrls")
    public long variax_lockctrls = 0;

    /** Probably whether or not Variax magnetic pickups are on/off */
    @JsonProperty("@variax_magmode")
    public boolean variax_magmode = true;

    /** Which Variax model is selcted on patch recall */
    // Examples: 0, 1, 2, ... , n (have seen at least as high as 60)
    @JsonProperty("@variax_model")
    public long variax_model = 10;

    /** Per-string tuning */
    // Examples: have only seen 0 in this node
    @JsonProperty("@variax_str1tuning")
    public long variax_str1tuning = 0;

    /** Per-string tuning */
    // Examples: have only seen 0 in this node
    @JsonProperty("@variax_str2tuning")
    public long variax_str2tuning = 0;

    /** Per-string tuning */
    // Examples: have only seen 0 in this node
    @JsonProperty("@variax_str3tuning")
    public long variax_str3tuning = 0;

    /** Per-string tuning */
    // Examples: have only seen 0 in this node
    @JsonProperty("@variax_str4tuning")
    public long variax_str4tuning = 0;

    /** Per-string tuning */
    // Examples: have only seen 0 in this node
    @JsonProperty("@variax_str5tuning")
    public long variax_str5tuning = 0;

    /** Per-string tuning */
    // Examples: have only seen 0 in this node
    @JsonProperty("@variax_str6tuning")
    public long variax_str6tuning = 0;

    /** Variax tone-knob position on patch recall */
    // Examples: have only seen -0.1 in this node
    @JsonProperty("@variax_toneknob")
    public double variax_toneknob = -0.1;

    /** Variax volume-knob position on patch recall */
    // Examples: have only seen -0.1 in this node
    @JsonProperty("@variax_volumeknob")
    public double variax_volumeknob = -0.1;
}
