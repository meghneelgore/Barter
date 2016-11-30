package com.example.meghneelgore.barter.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by meghneel.gore on 11/28/16.
 */
public interface NetworkService {

    @GET("bsa.aspx?cmd=bsa&key=QT49-P4SJ-94LT-DWE9")
    Call<AdvisoriesRoot> getAdvisories();

    @GET("stn.aspx?cmd=stns&key=QT49-P4SJ-94LT-DWE9")
    Call<Stations> getStations();

    @GET("sched.aspx?b=0&a=2&cmd=depart&date=now&key=QT49-P4SJ-94LT-DWE9")
    Call<TripRoot> getTrips(@Query("orig") String origin, @Query("dest") String destination);

}
