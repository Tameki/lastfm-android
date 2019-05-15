package com.geektech.lastfmapp.presentation.toptracks.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.geektech.lastfmapp.entities.Track;

import java.util.ArrayList;
import java.util.List;

public class TopTracksAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private TopTrackViewHolder.TopTrackClickListener mListener;
    private ArrayList<Track> mTracks;

    public TopTracksAdapter(
            TopTrackViewHolder.TopTrackClickListener listener,
            ArrayList<Track> tracks
    ) {
        mListener = listener;
        mTracks = tracks;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return mTracks.size();
    }

    public void setTracks(List<Track> tracks) {
        mTracks.clear();
        mTracks.addAll(tracks);
        notifyDataSetChanged();
    }
}
