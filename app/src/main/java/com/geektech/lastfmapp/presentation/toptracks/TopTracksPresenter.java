package com.geektech.lastfmapp.presentation.toptracks;

import com.geektech.lastfmapp.model.TrackEntity;

import java.util.ArrayList;

public class TopTracksPresenter implements ITopTracksContract.Presenter {

    private ITopTracksContract.View mView;

    @Override
    public void getTracks() {
        //TODO: Get tracks from Repository
        ArrayList<TrackEntity> trackEntities = new ArrayList<>();

        trackEntities.add(new TrackEntity(1, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(2, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(3, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(4, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(5, "name", "artist", "image"));

        if (mView != null) {
            mView.showTracks(trackEntities);
        }
    }

    @Override
    public void onTrackClick(int position) {

    }

    @Override
    public void attachView(ITopTracksContract.View view) {
        mView = view;
        mView.attachPresenter(this);
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
