package com.geektech.lastfmapp.presentation.track;

import com.geektech.core.mvp.CoreMvpPresenter;
import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.entities.TrackEntity;

public class TrackPresenter extends CoreMvpPresenter<ITrackContract.View>
        implements ITrackContract.Presenter {

    private ITracksRepository repository;
    private String trackId;

    public TrackPresenter(
            ITracksRepository repository,
            String trackId
    ) {
        this.repository = repository;
        this.trackId = trackId;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();

        TrackEntity track = repository.getTrack(trackId);

        if (view != null && track != null) {
            view.showTrack(track);
        }
    }
}
