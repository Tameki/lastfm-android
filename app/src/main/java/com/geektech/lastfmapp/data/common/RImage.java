package com.geektech.lastfmapp.data.common;

import io.realm.RealmObject;

public class RImage extends RealmObject {
    private String url;
    private String size;

    public RImage() {
    }

    public RImage(String url, String size) {
        this.url = url;
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return url + " " + size;
    }
}
