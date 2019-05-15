package com.geektech.lastfmapp.presentation.toptracks;

import com.geektech.core.mvp.ICoreMvpContract;
import com.geektech.lastfmapp.entities.Track;

import java.util.List;

public interface ITopTracksContract {
    interface View extends ICoreMvpContract.View<Presenter> {
        void showTracks(List<Track> tracks);

        void openTrackDetails(Track track);

        void startRefresh();

        void stopRefresh();
    }

    interface Presenter extends ICoreMvpContract.Presenter<View> {
        void getTracks();

        void onTrackClick(int position);
    }
}
