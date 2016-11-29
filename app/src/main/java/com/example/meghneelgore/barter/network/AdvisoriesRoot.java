package com.example.meghneelgore.barter.network;

import org.simpleframework.xml.Element;

/**
 * Created by meghneel.gore on 11/28/16.
 */
@org.simpleframework.xml.Root(name = "root")
public class AdvisoriesRoot {
    @Element
    private String uri;

    @Element
    private String date;

    @Element
    private String time;

    @Element
    private BSA bsa;

    @Element(required = false)
    private String message;

}
