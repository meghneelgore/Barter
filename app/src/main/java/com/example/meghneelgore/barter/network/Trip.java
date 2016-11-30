package com.example.meghneelgore.barter.network;

import org.simpleframework.xml.Attribute;

/**
 * Created by meghneel.gore on 11/30/16.
 */

public class Trip {

    /*
    <trip origin="EMBR" destination="WCRK" fare="5.25" origTimeMin="12:00 PM"
    origTimeDate="11/20/2016 " destTimeMin="12:34 PM" destTimeDate="11/20/2016"
    clipper="1.95" tripTime="34" co2="17.94">...</trip>
     */

    @Attribute
    String origin;

    @Attribute
    String destination;

    @Attribute
    String fare;

    @Attribute
    String origTimeMin;

    @Attribute
    String origTimeDate;

    @Attribute
    String destTimeMin;

    @Attribute
    String destTimeDate;

    @Attribute(required = false)
    String clipper;

    @Attribute
    String tripTime;

    @Attribute(required = false)
    String co2;


    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getFare() {
        return fare;
    }

    public String getOrigTimeMin() {
        return origTimeMin;
    }

    public String getOrigTimeDate() {
        return origTimeDate;
    }

    public String getDestTimeMin() {
        return destTimeMin;
    }

    public String getDestTimeDate() {
        return destTimeDate;
    }

    public String getClipper() {
        return clipper;
    }

    public String getTripTime() {
        return tripTime;
    }

    public String getCo2() {
        return co2;
    }
}
