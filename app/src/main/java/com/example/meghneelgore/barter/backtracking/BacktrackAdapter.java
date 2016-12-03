package com.example.meghneelgore.barter.backtracking;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.meghneelgore.barter.R;
import com.example.meghneelgore.barter.backtracking.BacktrackAdapter.BacktrackViewHolder;
import com.example.meghneelgore.barter.network.NetworkService;
import com.example.meghneelgore.barter.network.Trip;
import com.example.meghneelgore.barter.network.TripRoot;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by meghneel.gore on 11/30/16.
 */
public class BacktrackAdapter extends RecyclerView.Adapter<BacktrackViewHolder> {

    private List<Backtrack> mBacktrackList = new ArrayList<>();

    private String timeFormat = "hh:mm a";
    private SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(timeFormat);


    public BacktrackAdapter() {
        getNewBacktrackInfo();
    }

    static class Backtrack {
        String backtrackStation;
        String backtrackTrain;

        public Backtrack(String station, String train) {
            backtrackStation = station;
            backtrackTrain = train;
        }
    }

    public void getNewBacktrackInfo() {

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                Retrofit retrofit = new Builder()
                        .baseUrl("http://api.bart.gov/api/")
                        .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
                        .build();

                NetworkService service = retrofit.create(NetworkService.class);
                Call<TripRoot> directTrips = service.getTrips("EMBR", "WCRK");
                Call<TripRoot> oneBackTrips = service.getTrips("POWL", "WCRK");
                Call<TripRoot> toOneBackTrips = service.getTrips("EMBR", "POWL");


                try {
                    Response<TripRoot> directTripResponse = directTrips.execute();
                    Response<TripRoot> oneBackTripResponse = oneBackTrips.execute();
                    Response<TripRoot> toOneBackTripResponse = toOneBackTrips.execute();


                    List<Trip> directList = directTripResponse.body().getSchedule().getTrips();
                    List<Trip> oneBackList = oneBackTripResponse.body().getSchedule().getTrips();
                    List<Trip> toOneBackList = toOneBackTripResponse.body().getSchedule().getTrips();


                    String startTime = directList.get(0).getOrigTimeMin();
                    String endTime = directList.get(0).getDestTimeMin();

                    String startTimeOneBack = oneBackList.get(0).getOrigTimeMin();
                    String endTimeOneBack = oneBackList.get(0).getDestTimeMin();

                    String startTimeToOneBack = toOneBackList.get(0).getOrigTimeMin();
                    String endTimeToOneBack = toOneBackList.get(0).getDestTimeMin();

                    Date startTimeOneBackAsDate = parseTime(startTimeOneBack);
                    Date endTimeToOneBackAsDate = parseTime(endTimeToOneBack);
                    if (startTimeOneBackAsDate.compareTo(endTimeToOneBackAsDate) > 0) {
                        //Success
                    }
                    System.out.println("yes");

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();

    }

    private Date parseTime(String timeString) {
        Date date = null;
        try {
            date = mSimpleDateFormat.parse(timeString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public BacktrackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.backtracking_item, null);
        return new BacktrackViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BacktrackViewHolder holder, int position) {

        holder.backtrackToStation.setText(mBacktrackList.get(position).backtrackStation);
        holder.backtrackWithTrain.setText(mBacktrackList.get(position).backtrackTrain);
    }

    @Override
    public int getItemCount() {
        return mBacktrackList.size();
    }

    static class BacktrackViewHolder extends RecyclerView.ViewHolder {
        TextView backtrackToStation;
        TextView backtrackWithTrain;

        public BacktrackViewHolder(View view) {
            super(view);
            backtrackToStation = (TextView) view.findViewById(R.id.txt_backtrack_station);
            backtrackWithTrain = (TextView) view.findViewById(R.id.txt_backtrack_train_info);

        }
    }
}
