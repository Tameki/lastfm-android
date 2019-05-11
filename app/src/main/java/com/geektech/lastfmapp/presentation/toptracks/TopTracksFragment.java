package com.geektech.lastfmapp.presentation.toptracks;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.geektech.core.Logger;
import com.geektech.core.mvp.CoreMvpFragment;
import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.entities.TrackEntity;
import com.geektech.lastfmapp.presentation.toptracks.recycler.TopTrackViewHolder;
import com.geektech.lastfmapp.presentation.toptracks.recycler.TopTracksAdapter;
import com.geektech.lastfmapp.presentation.track.TrackActivity;

import java.util.ArrayList;
import java.util.List;

public class TopTracksFragment extends CoreMvpFragment<ITopTracksContract.Presenter>
    implements ITopTracksContract.View, TopTrackViewHolder.TopTrackClickListener {

    private TopTracksAdapter mAdapter;
    private SwipeRefreshLayout mRefresh;

    public static TopTracksFragment newInstance() {
        TopTracksFragment fragment = new TopTracksFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list;
    }

    @Override
    protected void initView(View view) {
        mAdapter = new TopTracksAdapter(this, new ArrayList<>());

        mRefresh = view.findViewById(R.id.fragment_refresh);
        mRefresh.setOnRefreshListener(() -> {
            refreshTracks();
        });
    }

    private void refreshTracks() {
        if (presenter != null) {
            presenter.getTracks();
        }
    }

    //region ViewHolder

    @Override
    public void onTrackClick(int position) {
        if (presenter != null) {
            presenter.onTrackClick(position);
        }
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
        if (getActivity() != null) {
            TrackActivity.start(getActivity(), track.getUniqueId());
        }
    }

    @Override
    public void startRefresh() {
        if (mRefresh != null) {
            mRefresh.setRefreshing(true);
        }
    }

    @Override
    public void stopRefresh() {
        if (mRefresh != null) {
            mRefresh.setRefreshing(false);
        }
    }

    //endregion
}
