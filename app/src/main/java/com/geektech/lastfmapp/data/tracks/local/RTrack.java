package com.geektech.lastfmapp.data.tracks.local;

import com.geektech.lastfmapp.data.common.RImage;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RTrack extends RealmObject {
    @PrimaryKey
    private String uniqueId;

    private String name;
    private String url;
    private String playcount;
    private String listeners;
    private RealmList<RImage> images;

    //TODO: Add RShortArtist model

    public RTrack(String name, String url, String playcount, String listeners, String uniqueId, RealmList<RImage> images) {
        this.name = name;
        this.url = url;
        this.playcount = playcount;
        this.listeners = listeners;
        this.uniqueId = uniqueId;
        this.images = images;
    }

    public RTrack() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public RealmList<RImage> getImages() {
        return images;
    }

    public void setImages(RealmList<RImage> images) {
        this.images = images;
    }
}
