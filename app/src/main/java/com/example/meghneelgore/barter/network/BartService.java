package com.example.meghneelgore.barter.network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by meghneel.gore on 11/28/16.
 */
public interface BartService {

    @GET("bsa.aspx?cmd=bsa&key=QT49-P4SJ-94LT-DWE9")
    Call<AdvisoriesRoot> getAdvisories();

    @GET("stn.aspx?cmd=stns&key=QT49-P4SJ-94LT-DWE9")
    Call<Stations> getStations();
}
