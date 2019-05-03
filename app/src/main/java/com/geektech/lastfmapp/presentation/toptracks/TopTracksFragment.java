package com.geektech.lastfmapp.presentation.toptracks;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.geektech.core.Logger;
import com.geektech.core.mvp.CoreMvpFragment;
import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.data.tracks.remote.TracksRemoteStorage;
import com.geektech.lastfmapp.data.tracks.remote.model.TracksResponse;
import com.geektech.lastfmapp.entities.TrackEntity;
import com.geektech.lastfmapp.presentation.toptracks.recycler.TopTrackViewHolder;
import com.geektech.lastfmapp.presentation.toptracks.recycler.TopTracksAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopTracksFragment extends CoreMvpFragment<ITopTracksContract.Presenter>
    implements ITopTracksContract.View, TopTrackViewHolder.TopTrackClickListener {

    private TopTracksAdapter mAdapter;

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
        mAdapter = new TopTracksAdapter(this, new ArrayList<>());
    }

    private void refreshTracks() {
        if (presenter != null) {
            presenter.getTracks();
        }
    }

    //region ViewHolder

    @Override
    public void onTrackClick(int position) {

    }

    @Override
    public void onShareClick(int position) {

    }

    @Override
    public void onBookmarkClick(int position) {

    }

    //endregion

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
