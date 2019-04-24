package com.geektech.lastfmapp.presentation.toptracks;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.lastfmapp.model.TrackEntity;

import java.util.List;

public class TopTracksFragment extends Fragment
    implements ITopTracksContract.View {

    private ITopTracksContract.Presenter mPresenter;

    public static TopTracksFragment newInstance() {
        TopTracksFragment fragment = new TopTracksFragment();
        return fragment;
    }

    //region Lifecycle

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //endregion

    //region Contract

    @Override
    public void showTracks(List<TrackEntity> tracks) {

    }

    @Override
    public void openTrackDetails(TrackEntity track) {

    }

    @Override
    public void attachPresenter(ITopTracksContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void finishView() {
        getActivity().finish();
    }

    //endregion
}
