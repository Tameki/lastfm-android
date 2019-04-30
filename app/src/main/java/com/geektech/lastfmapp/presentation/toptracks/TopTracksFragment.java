package com.geektech.lastfmapp.presentation.toptracks;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.geektech.core.Logger;
import com.geektech.core.mvp.CoreMvpFragment;
import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.entities.TrackEntity;

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

    }

    //region Contract

    @Override
    public void showTracks(List<TrackEntity> tracks) {
        for (TrackEntity track : tracks) {
            Logger.d(track.toString());
        }
    }

    @Override
    public void openTrackDetails(TrackEntity track) {

    }

    //endregion
}
