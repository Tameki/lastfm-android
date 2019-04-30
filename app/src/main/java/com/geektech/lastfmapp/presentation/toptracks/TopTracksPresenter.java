package com.geektech.lastfmapp.presentation.toptracks;

import android.util.Log;

import com.geektech.core.Logger;
import com.geektech.core.mvp.CoreMvpPresenter;
import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.entities.TrackEntity;

import java.util.List;

public class TopTracksPresenter extends CoreMvpPresenter<ITopTracksContract.View>
        implements ITopTracksContract.Presenter {

    private ITracksRepository repository;

    public TopTracksPresenter(ITracksRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getTracks() {
        repository.getTracks(new ITracksRepository.TracksCallback() {
            @Override
            public void onSuccess(List<TrackEntity> tracks) {
                Logger.d("Tracks success " + tracks.size());
                if (view != null) {
                    view.showTracks(tracks);
                }
            }

            @Override
            public void onFailure(String message) {
                Logger.d(message);
                if (view != null) {
                    view.showMessage(message);
                }
            }
        });
    }

    @Override
    public void onTrackClick(int position) {

    }
}
