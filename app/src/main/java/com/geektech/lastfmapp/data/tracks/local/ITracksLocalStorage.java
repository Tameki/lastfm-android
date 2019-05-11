package com.geektech.lastfmapp.data.tracks.local;

import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.entities.TrackEntity;

import java.util.List;

public interface ITracksLocalStorage {
    void getTracks(ITracksRepository.TracksCallback callback);

    void setTracks(List<TrackEntity> tracks);

    TrackEntity getTrack();
}
