package com.benvesco.vesco_helixsorter.model;

/**
 * Contains everything processed on a single DSP. Helix has two of these. While
 * it has been said that Path 2 has more horsepower than Path 1 (due to Path 1
 * running the OS) both paths have the same available blocks.
 * 
 * @author bvesco
 */
public class DspNode extends FreeformJson {
    public JoinNode join;
}
