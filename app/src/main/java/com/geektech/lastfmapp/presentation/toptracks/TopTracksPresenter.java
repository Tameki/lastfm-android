package com.geektech.lastfmapp.presentation.toptracks;

import com.geektech.core.mvp.CoreMvpPresenter;
import com.geektech.lastfmapp.model.TrackEntity;

import java.util.ArrayList;

public class TopTracksPresenter extends CoreMvpPresenter<ITopTracksContract.View>
        implements ITopTracksContract.Presenter {

    @Override
    public void getTracks() {
        //TODO: Get tracks from Repository
        ArrayList<TrackEntity> trackEntities = new ArrayList<>();

        trackEntities.add(new TrackEntity(1, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(2, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(3, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(4, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(5, "name", "artist", "image"));

        if (view != null) {
            view.showTracks(trackEntities);
        }
    }

    @Override
    public void onTrackClick(int position) {

    }
}
