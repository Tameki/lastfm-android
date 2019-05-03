package com.geektech.lastfmapp.presentation.artist;

import android.support.annotation.Nullable;

import com.geektech.core.mvp.CoreMvpActivity;
import com.geektech.lastfmapp.R;

public class ArtistActivity extends CoreMvpActivity<IArtistContract.Presenter>
    implements IArtistContract.View {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_top_tracks;
    }

    @Override
    protected void initView() {

    }

    @Nullable
    @Override
    protected IArtistContract.Presenter providePresenter() {
        return new ArtistPresenter();
    }
}
