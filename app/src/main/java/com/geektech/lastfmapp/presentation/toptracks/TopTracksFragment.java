package com.geektech.lastfmapp.presentation.toptracks;

import android.view.View;

import com.geektech.core.mvp.CoreMvpFragment;
import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.model.TrackEntity;

import java.util.List;

public class TopTracksFragment extends CoreMvpFragment<ITopTracksContract.Presenter>
    implements ITopTracksContract.View {

    public static TopTracksFragment newInstance() {
        TopTracksFragment fragment = new TopTracksFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_top_tracks;
    }

    @Override
    protected void initView(View view) {
        //TODO: Init
    }

    //region Contract

    @Override
    public void showTracks(List<TrackEntity> tracks) {

    }

    @Override
    public void openTrackDetails(TrackEntity track) {

    }

    //endregion
}
