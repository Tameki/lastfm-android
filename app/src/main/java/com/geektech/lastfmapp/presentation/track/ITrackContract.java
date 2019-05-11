package com.geektech.lastfmapp.presentation.track;

import com.geektech.core.mvp.ICoreMvpContract;
import com.geektech.lastfmapp.entities.TrackEntity;

public interface ITrackContract {
    interface View extends ICoreMvpContract.View<Presenter> {
        void showTrack(TrackEntity track);
    }

    interface Presenter extends ICoreMvpContract.Presenter<View> {

    }
}
