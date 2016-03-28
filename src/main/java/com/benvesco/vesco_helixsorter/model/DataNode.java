package com.benvesco.vesco_helixsorter.model;

/**
 * Represents the "data" node in a patch file.
 * 
 * @author bvesco
 */
public class DataNode {
    /** Probably id for particular Helix version */
    // Examples: have only seen 2162689 in this node
    public long device = 2162689;

    /** Probably tied to firmware, but could be hardware or software */
    // Examples: have only seen 17171744 in this node
    public long device_version = 17171744;

    public MetaNode meta;

    public ToneNode tone;
}
