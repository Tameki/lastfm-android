package com.geektech.lastfmapp.data.tracks.local;

import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.entities.TrackEntity;

import java.util.List;

public class TracksLocalStorage implements ITracksLocalStorage {

    @Override
    public void getTracks(ITracksRepository.TracksCallback callback) {
        //TODO: Fetch from DB
    }

    @Override
    public void setTracks(List<TrackEntity> tracks) {
        //TODO: Save to DB
    }

    @Override
    public TrackEntity getTrack() {
        return null;
    }
}
