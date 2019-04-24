package com.geektech.lastfmapp.presentation.artist;

import com.geektech.core.mvp.ICoreMvpContract;

public interface IArtistContract {
    interface View extends ICoreMvpContract.View<Presenter> {

    }

    interface Presenter extends ICoreMvpContract.Presenter<View> {

    }
}
