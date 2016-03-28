package com.benvesco.vesco_helixsorter.model;

public class MetaNode {
    /** Name of the patch file as displayed on Helix */
    public String name;

    /** Probably name of the application that wrote this patch file */
    public String application;

    /** Not sure what this comes from or means, there are a lot of matches */
    // Examples: have only seen two different values "69d8fa6", "b4fb225"
    public String build_sha;

    /** Timestamp (in seconds) of when patch was edited last */
    public long modifieddate;

    /** Not sure what this comes from */
    // Examples: have only seen 17039360 in this node
    public long appversion = 17039360;
}
