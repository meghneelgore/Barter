package com.example.meghneelgore.barter.stationlist;

import java.util.List;

import com.example.meghneelgore.barter.R;
import com.example.meghneelgore.barter.stationlist.StationListAdapter.StationListHolder;
import com.example.meghneelgore.barter.network.NetworkService;
import com.example.meghneelgore.barter.network.Station;
import com.example.meghneelgore.barter.network.Stations;
import com.example.meghneelgore.barter.network.TripRoot;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by meghneel.gore on 11/28/16.
 */
public class StationListAdapter extends Adapter<StationListHolder> {
    private List<Station> stationList;

    public StationListAdapter() {
        if (stationList == null) {
            Retrofit retrofit = new Builder()
                    .baseUrl("http://api.bart.gov/api/")
                    .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
                    .build();
            NetworkService service = retrofit.create(NetworkService.class);
            Call<TripRoot> trips = service.getTrips("EMBR", "WCRK");
            trips.enqueue(new Callback<TripRoot>() {
                @Override
                public void onResponse(Call<TripRoot> call, Response<TripRoot> response) {

                }

                @Override
                public void onFailure(Call<TripRoot> call, Throwable t) {

                }
            });
            Call<Stations> stations = service.getStations();

            stations.enqueue(new Callback<Stations>() {
                @Override
                public void onResponse(Call<Stations> call, Response<Stations> response) {
                    stationList = response.body().getStations();
                    StationListAdapter.this.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<Stations> call, Throwable t) {

                }
            });
        }
    }

    @Override
    public StationListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.station_list_item, null);
        return new StationListHolder(v);
    }

    @Override
    public void onBindViewHolder(StationListHolder holder, int position) {
        if (stationList == null) {
            return;
        }
        holder.mTextView.setText(stationList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        if (stationList == null) {
            return 0;
        }
        return stationList.size();
    }


    static class StationListHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public StationListHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.station_name);

        }
    }
}
