package com.geektech.lastfmapp.presentation.track;

import com.geektech.core.mvp.ICoreMvpContract;
import com.geektech.lastfmapp.entities.Track;

public interface ITrackContract {
    interface View extends ICoreMvpContract.View<Presenter> {
        void showTrack(Track track);
    }

    interface Presenter extends ICoreMvpContract.Presenter<View> {

    }
}
