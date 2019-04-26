package com.geektech.lastfmapp.data.tracks.remote;

import com.geektech.lastfmapp.data.tracks.ITracksRepository;

public interface ITracksRemoteStorage {
    void getTracks(ITracksRepository.TracksCallback callback);
}
