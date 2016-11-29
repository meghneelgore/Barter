package com.example.meghneelgore.barter.network;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.google.common.collect.ImmutableList;

/**
 * Created by meghneel.gore on 11/28/16.
 */
@Root(name = "root")
public class Stations {

    @Element
    private String uri;

    @ElementList
    private List<Station> stations;

    @Element(required = false)
    private String message;

    public List<Station> getStations() {
        return ImmutableList.copyOf(stations);
    }
}
