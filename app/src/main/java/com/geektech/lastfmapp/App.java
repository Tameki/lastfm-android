package com.geektech.lastfmapp;

import android.app.Application;

import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.data.tracks.TracksRepository;
import com.geektech.lastfmapp.data.tracks.local.TracksLocalStorage;
import com.geektech.lastfmapp.data.tracks.remote.TracksRemoteStorage;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application {

    public static ITracksRepository tracksRepository;

    @Override
    public void onCreate() {
        super.onCreate();

        initRealm();

        tracksRepository = new TracksRepository(
                new TracksLocalStorage(),
                new TracksRemoteStorage()
        );
    }

    private void initRealm() {
        Realm.init(this);

        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name("lastfm.realm")
                .schemaVersion(1)
                .build();

        Realm.setDefaultConfiguration(configuration);
    }
}
