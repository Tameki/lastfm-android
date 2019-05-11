package com.geektech.lastfmapp.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrackEntity {
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("artist")
    private ArtistEntity artist;

    @SerializedName("url")
    private String url;

    @SerializedName("playcount")
    private String playcount;

    @SerializedName("listeners")
    private String listeners;

    @SerializedName("image")
    private List<TrackImage> image;

    public TrackEntity(int id, String name, ArtistEntity artist, String url, String playcount, String listeners, List<TrackImage> image) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.url = url;
        this.playcount = playcount;
        this.listeners = listeners;
        this.image = image;
    }

    //region Getters/Setters

    public ArtistEntity getArtist() {
        return artist;
    }

    public void setArtist(ArtistEntity artist) {
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

    public List<TrackImage> getImage() {
        return image;
    }

    public void setImage(List<TrackImage> image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return id + " " + name + " " + artist + " " + image;
    }
}
