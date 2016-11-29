package com.example.meghneelgore.barter.adapter;

import java.util.List;

import com.example.meghneelgore.barter.R;
import com.example.meghneelgore.barter.adapter.StationListAdapter.StationListHolder;
import com.example.meghneelgore.barter.network.Station;

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
    List<Station> stationList;

    public StationListAdapter(List<Station> stationList) {
        this.stationList = stationList;
    }

    public void setStationList(List<Station> stationList) {
        this.stationList = stationList;
        notifyDataSetChanged();
    }

    @Override
    public StationListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.station_list_item, null);
        return new StationListHolder(v);
    }

    @Override
    public void onBindViewHolder(StationListHolder holder, int position) {
        if (stationList == null || holder.mTextView == null) {
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
