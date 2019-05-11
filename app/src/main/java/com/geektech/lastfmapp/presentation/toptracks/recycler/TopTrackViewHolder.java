package com.geektech.lastfmapp.presentation.toptracks.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class TopTrackViewHolder extends RecyclerView.ViewHolder {

    public TopTrackViewHolder(
            @NonNull View itemView,
            TopTrackClickListener listener
    ) {
        super(itemView);
        itemView.setOnClickListener(v -> {
            listener.onTrackClick(getAdapterPosition());
        });
    }

    public interface TopTrackClickListener {
        void onTrackClick(int position);
    }

}
