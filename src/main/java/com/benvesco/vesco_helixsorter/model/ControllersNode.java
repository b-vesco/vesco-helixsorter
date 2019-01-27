package com.benvesco.vesco_helixsorter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This holds assignments for the expression pedals. Even though footswitch
 * toggles are assigned in the Helix's "controllers" menu they will not be in
 * this data structure. Instead those types of controllers are represented in
 * the "footswitches" structure.
 *
 * @author bvesco
 */
public class ControllersNode {
    @JsonProperty("@expPedal1")
    public Controller[] expPedal1;

    @JsonProperty("@expPedal2")
    public Controller[] expPedal2;

    @JsonProperty("@expPedal3")
    public Controller[] expPedal3;

    @JsonProperty("@variaxTone")
    public Controller[] variaxTone;
}
