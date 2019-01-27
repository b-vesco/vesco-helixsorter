package com.benvesco.vesco_helixsorter.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Representation of the .hlx file format.
 *
 * @author bvesco
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class HlxPatchFile {
    /** Probably the schema version of this patch file */
    // Examples: have only seen 6 in this node
    public long version = 6;

    public DataNode data;

    /** Probably identifies some internal schema file I don't have access to */
    // Examples: have only seen "L6Preset" in this node
    public String schema = "L6Preset";

    /**
     * New things that Line 6 add will be collected here rather than thrown
     * away. It could help in debugging someday.
     */
    @JsonIgnore
    public Map<String, JsonNode> otherParams = new HashMap<>();

    @JsonAnySetter
    public void setUnknownProperty(String key, JsonNode value) {
        otherParams.put(key, value);
    }
}
