package com.example.meghneelgore.barter.network;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

/**
 * Created by meghneel.gore on 11/28/16.
 */
@Element(name = "bsa")
public class BSA {
    @Attribute(required = false)
    int id;

    @Element(required = false)
    String station;

    @Element(required = false)
    String type;

    @Element(required = false)
    String description;

    @Element(name = "sms_text", required = false)
    String smsText;

    @Element(required = false)
    String posted;

    @Element(required = false)
    String expires;
}
