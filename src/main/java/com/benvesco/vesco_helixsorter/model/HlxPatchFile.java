package com.benvesco.vesco_helixsorter.model;

/**
 * Representation of the .hlx file format.
 * 
 * @author bvesco
 */
public class HlxPatchFile {
    /** Probably the schema version of this patch file */
    // Examples: have only seen 6 in this node
    public long version = 6;

    public DataNode data;

    /** Probably identifies some internal schema file I don't have access to */
    // Examples: have only seen "L6Preset" in this node
    public String schema = "L6Preset";
}
