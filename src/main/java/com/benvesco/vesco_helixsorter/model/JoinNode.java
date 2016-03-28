package com.benvesco.vesco_helixsorter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A "join" in helix is when a single DSP needs to merge two signals back
 * together as a result of a previous split. A DSP will only have one join.
 * 
 * @author bvesco
 */
public class JoinNode extends BaseBlockNode {
    /** Not sure what a disbled join block would be */
    @JsonProperty("@enabled")
    public boolean enabled = true;

    /** Clean gain adjust for this block */
    // Examples: -0.3, 0.0, 0.73
    public double Level = 0.0;

    /** Volume of the 'A' signal path */
    // Examples: [-60.0, 0.0]
    @JsonProperty("A Level")
    public double a_level = 0.0;

    /** Pan for the 'A' signal path */
    // Examples: [0.0, 1.0]
    @JsonProperty("A Pan")
    public double a_pan = 0.5;

    /** Volume of the 'B' signal path */
    // Examples: [-60.0, 0.0]
    @JsonProperty("B Level")
    public double b_level = 0.0;

    /** Pan for the 'B' signal path */
    // Examples: [0.0, 1.0]
    @JsonProperty("B Pan")
    public double b_pan = 0.5;

    /** Should signal path 'B' have reverse polarity? */
    @JsonProperty("B Polarity")
    public boolean b_polarity = false;
}
