package com.example.meghneelgore.barter.network;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by meghneel.gore on 11/30/16.
 */
@Root(name = "root", strict = false)
public class TripRoot {

    @Element
    private Schedule schedule;


    public Schedule getSchedule() {
        return schedule;
    }

}
