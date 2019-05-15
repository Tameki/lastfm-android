package com.geektech.lastfmapp.data.tracks.local;

import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.entities.Track;

import java.util.List;

public interface ITracksLocalStorage {
    void getTracks(ITracksRepository.TracksCallback callback);

    void setTracks(List<Track> tracks);

    Track getTrack(String uniqueId);
}
