package com.geektech.lastfmapp.data.tracks.local;

import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.model.TrackEntity;

import java.util.List;

public interface ITracksLocalStorage {
    void getTracks(ITracksRepository.TracksCallback callback);

    void setTracks(List<TrackEntity> tracks);
}
