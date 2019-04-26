package com.geektech.lastfmapp.data.tracks.remote;

import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.model.TrackEntity;

import java.util.ArrayList;

public class RemoteTracksStorage implements ITracksRemoteStorage {
    @Override
    public void getTracks(ITracksRepository.TracksCallback callback) {
        //TODO: Network call

        ArrayList<TrackEntity> trackEntities = new ArrayList<>();

        trackEntities.add(new TrackEntity(1, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(2, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(3, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(4, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(5, "name", "artist", "image"));

        callback.onSuccess(trackEntities);
    }
}
