package com.geektech.lastfmapp.data.tracks;

import android.support.annotation.Nullable;

import com.geektech.core.CoreCallback;
import com.geektech.lastfmapp.entities.Track;

import java.util.List;

public interface ITracksRepository {

    @Nullable
    Track getTrack(String uniqueId);

    void getTopTracks(TracksCallback callback);

    void getArtistTopTracks(String artistName, TracksCallback callback);

    interface TracksCallback extends CoreCallback<List<Track>> { }
}
