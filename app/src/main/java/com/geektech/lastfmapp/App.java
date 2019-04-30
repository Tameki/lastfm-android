package com.geektech.lastfmapp;

import android.app.Application;

import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.data.tracks.TracksRepository;
import com.geektech.lastfmapp.data.tracks.local.TracksLocalStorage;
import com.geektech.lastfmapp.data.tracks.remote.TracksRemoteStorage;

public class App extends Application {

    public static ITracksRepository tracksRepository;

    @Override
    public void onCreate() {
        super.onCreate();

        tracksRepository = new TracksRepository(
                new TracksLocalStorage(),
                new TracksRemoteStorage()
        );
    }
}
