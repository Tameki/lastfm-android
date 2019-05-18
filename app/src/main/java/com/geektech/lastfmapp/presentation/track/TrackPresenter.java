package com.geektech.lastfmapp.presentation.track;

import com.geektech.core.mvp.CoreMvpPresenter;
import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.entities.Track;

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

        Track track = repository.getTrack(trackId);

        if (view != null && track != null) {
            view.showTrack(track);

            //TODO: Fetch track lyrics
        }
    }
}
