package com.benvesco.vesco_helixsorter.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * This class allows JSON to be completely freeform. Any non-modeled fields will
 * end up in the enclosed collected.
 *
 * @author bvesco
 */
public class FreeformJson {
    @JsonIgnore
    private Map<String, JsonNode> extraFields = Maps.newHashMap();

    @JsonAnySetter
    public void setExtraField(String name, JsonNode value) {
        extraFields.put(name, value);
    }

    @JsonIgnore
    public JsonNode getExtraField(String name) {
        return extraFields.get(name);
    }

    @JsonAnyGetter
    public Map<String, JsonNode> getExtraFields() {
        return extraFields;
    }
}
