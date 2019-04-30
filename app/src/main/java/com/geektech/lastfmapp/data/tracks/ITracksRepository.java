package com.geektech.lastfmapp.data.tracks;

import android.support.annotation.Nullable;

import com.geektech.lastfmapp.entities.TrackEntity;

import java.util.List;

public interface ITracksRepository {

    @Nullable
    TrackEntity getTrack(int id);

    void getTracks(TracksCallback callback);

    public interface TracksCallback {
        void onSuccess(List<TrackEntity> tracks);

        void onFailure(String message);
    }
}
