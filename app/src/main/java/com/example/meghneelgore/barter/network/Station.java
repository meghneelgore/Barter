package com.example.meghneelgore.barter.network;

import org.simpleframework.xml.Element;

/**
 * Created by meghneel.gore on 11/28/16.
 */
public class Station {
    /*
    <station>
      <name>12th St. Oakland City Center</name>
      <abbr>12TH</abbr>
      <gtfs_latitude>37.803664</gtfs_latitude>
      <gtfs_longitude>-122.271604</gtfs_longitude>
      <address>1245 Broadway</address>
      <city>Oakland</city>
      <county>alameda</county>
      <state>CA</state>
      <zipcode>94612</zipcode>
    </station>
    ...
     */


    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbr;
    }

    @Element
    String name;

    @Element
    String abbr;

    @Element(name = "gtfs_latitude")
    String lat;

    @Element(name = "gtfs_longitude")
    String lon;

    @Element
    String address;

    @Element
    String city;

    @Element
    String county;

    @Element
    String state;

    @Element
    String zipcode;
}
