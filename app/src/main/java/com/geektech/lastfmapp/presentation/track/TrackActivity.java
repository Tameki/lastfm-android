package com.geektech.lastfmapp.presentation.track;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.geektech.core.mvp.CoreMvpActivity;
import com.geektech.lastfmapp.App;
import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.entities.TrackEntity;
import com.geektech.lastfmapp.presentation.artist.ArtistPresenter;
import com.geektech.lastfmapp.presentation.artist.IArtistContract;

public class TrackActivity extends CoreMvpActivity<ITrackContract.Presenter>
    implements ITrackContract.View {

    //region Static

    private static final String EXTRA_TRACK_ID = "track_id";

    public static void start(
            Activity activity,
            String trackId
    ) {
        Intent intent = new Intent(activity, TrackActivity.class);

        intent.putExtra(EXTRA_TRACK_ID, trackId);

        activity.startActivity(intent);
    }

    private static String getTrackId(Intent intent) {
        return intent.getStringExtra(EXTRA_TRACK_ID);
    }

    //endregion

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_top_tracks;
    }

    @Override
    protected void initView() {

    }

    @Nullable
    @Override
    protected ITrackContract.Presenter providePresenter() {
        return new TrackPresenter(
                App.tracksRepository,
                getTrackId(getIntent())
        );
    }

    @Override
    public void showTrack(TrackEntity track) {
        //TODO: Show track details
    }
}
