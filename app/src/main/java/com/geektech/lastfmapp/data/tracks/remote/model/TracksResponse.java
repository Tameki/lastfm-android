package com.geektech.lastfmapp.data.tracks.remote.model;

import com.google.gson.annotations.SerializedName;

public class TracksResponse {
    @SerializedName("tracks")
    private TracksResponseData tracks;

    public TracksResponse(TracksResponseData tracks) {
        this.tracks = tracks;
    }

    public TracksResponseData getTracks() {
        return tracks;
    }

    public void setTracks(TracksResponseData tracks) {
        this.tracks = tracks;
    }
}
