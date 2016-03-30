package com.benvesco.vesco_helixsorter.model;

public class ToneNode extends FreeformJson {
    public GlobalNode global;

    // 1.06.5
    public FootswitchesNode footswitches;
    public ControllersNode controllers;

    // 1.10.0
    public FreeformJson footswitch;
    public FreeformJson controller;

    public DspNode dsp0;

    public DspNode dsp1;
}
