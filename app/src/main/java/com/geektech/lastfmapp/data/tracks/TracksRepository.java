package com.geektech.lastfmapp.data.tracks;

import android.support.annotation.Nullable;

import com.geektech.lastfmapp.data.tracks.local.ITracksLocalStorage;
import com.geektech.lastfmapp.data.tracks.remote.ITracksRemoteStorage;
import com.geektech.lastfmapp.entities.TrackEntity;

import java.util.List;

public class TracksRepository implements ITracksRepository {

    @Nullable
    private ITracksLocalStorage local;
    @Nullable
    private ITracksRemoteStorage remote;

    public TracksRepository(
            @Nullable ITracksLocalStorage local,
            @Nullable ITracksRemoteStorage remote
    ) {
        this.local = local;
        this.remote = remote;
    }

    @Nullable
    @Override
    public TrackEntity getTrack(int id) {
        return null;
    }

    @Override
    public void getTracks(final TracksCallback callback) {
        if (local != null) {
            local.getTracks(callback);
        }

        if (remote != null) {
            remote.getTracks(new TracksCallback() {
                @Override
                public void onSuccess(List<TrackEntity> tracks) {
                    local.setTracks(tracks);

                    callback.onSuccess(tracks);
                }

                @Override
                public void onFailure(String message) {
                    callback.onFailure(message);
                }
            });
        }
    }
}
