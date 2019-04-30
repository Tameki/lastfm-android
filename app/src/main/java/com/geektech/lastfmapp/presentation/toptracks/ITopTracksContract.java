package com.geektech.lastfmapp.presentation.toptracks;

import com.geektech.core.mvp.ICoreMvpContract;
import com.geektech.lastfmapp.entities.TrackEntity;

import java.util.List;

public interface ITopTracksContract {
    interface View extends ICoreMvpContract.View<Presenter> {
        void showTracks(List<TrackEntity> tracks);

        void openTrackDetails(TrackEntity track);
    }

    interface Presenter extends ICoreMvpContract.Presenter<View> {
        void getTracks();

        void onTrackClick(int position);
    }
}
