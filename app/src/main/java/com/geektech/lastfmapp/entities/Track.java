package com.geektech.lastfmapp.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Track {
    @SerializedName("name")
    private String name;

    @SerializedName("artist")
    private Artist artist;

    @SerializedName("url")
    private String url;

    @SerializedName("playcount")
    private String playcount;

    @SerializedName("listeners")
    private String listeners;

    @SerializedName("image")
    private List<Image> image;

    public Track(String name, Artist artist, String url, String playcount, String listeners, List<Image> image) {
        this.name = name;
        this.artist = artist;
        this.url = url;
        this.playcount = playcount;
        this.listeners = listeners;
        this.image = image;
    }

    //region Getters/Setters

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
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

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //endregion

    public String getUniqueId() {
        return name + " " + artist.getName();
    }

    @Override
    public String toString() {
        return name + " " + artist + " " + image;
    }
}
