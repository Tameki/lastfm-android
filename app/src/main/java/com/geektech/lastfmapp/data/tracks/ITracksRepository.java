package com.geektech.lastfmapp.data.tracks;

import android.support.annotation.Nullable;

import com.geektech.core.CoreCallback;
import com.geektech.lastfmapp.entities.TrackEntity;

import java.util.List;

public interface ITracksRepository {

    @Nullable
    TrackEntity getTrack(String uniqueId);

    void getTracks(TracksCallback callback);

    interface TracksCallback extends CoreCallback<List<TrackEntity>> { }
}
