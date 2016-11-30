package com.example.meghneelgore.barter.network;

import java.util.List;

import org.simpleframework.xml.ElementList;

/**
 * Created by meghneel.gore on 11/30/16.
 */
public class Schedule {

    @ElementList
    private List<Trip> request;

    public List<Trip> getTrips() {
        return request;
    }
}
