package com.geektech.lastfmapp.data.tracks;

import android.support.annotation.Nullable;

import com.geektech.lastfmapp.data.tracks.local.ITracksLocalStorage;
import com.geektech.lastfmapp.data.tracks.remote.ITracksRemoteStorage;
import com.geektech.lastfmapp.entities.Track;

import java.util.HashMap;
import java.util.List;

public class TracksRepository implements ITracksRepository {

    @Nullable
    private ITracksLocalStorage local;
    @Nullable
    private ITracksRemoteStorage remote;

    private HashMap<String, Track> mCache = new HashMap<>();

    public TracksRepository(
            @Nullable ITracksLocalStorage local,
            @Nullable ITracksRemoteStorage remote
    ) {
        this.local = local;
        this.remote = remote;
    }

    private void setCache(List<Track> tracks) {
        if (local != null) {
            local.setTracks(tracks);
        }

        for(Track track : tracks) {
            mCache.put(track.getUniqueId(), track);
        }
    }

    @Nullable
    @Override
    public Track getTrack(String uniqueId) {
        Track track = mCache.get(uniqueId);

        if (track == null && local != null) {
            track = local.getTrack(uniqueId);
        }

        return track;
    }

    @Override
    public void getTopTracks(final TracksCallback callback) {
        if (local != null) {
            local.getTracks(callback);
        }

        if (remote != null) {
            remote.getTracks(new TracksCallback() {
                @Override
                public void onSuccess(List<Track> tracks) {
                    setCache(tracks);

                    callback.onSuccess(tracks);
                }

                @Override
                public void onFailure(String message) {
                    callback.onFailure(message);
                }
            });
        }
    }

    @Override
    public void getArtistTopTracks(String artistName, TracksCallback callback) {
        //TODO: Fetch artist top tracks
    }
}
