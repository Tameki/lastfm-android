package com.geektech.lastfmapp.data.tracks.local;

import com.geektech.lastfmapp.data.common.RImage;
import com.geektech.lastfmapp.entities.Image;
import com.geektech.lastfmapp.entities.Track;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

class TracksMapper {
    static RTrack toRTrack(Track track) {
        RealmList<RImage> images = new RealmList<>();

        for (Image image : track.getImage()) {
            images.add(new RImage(image.getUrl(), image.getSize()));
        }

        return new RTrack(
                track.getName(),
                track.getUrl(),
                track.getPlaycount(),
                track.getListeners(),
                track.getUniqueId(),
                images
        );
    }

    static Track toTrack(RTrack track) {
        ArrayList<Image> images = new ArrayList<>();

        for (RImage image : track.getImages()) {
            images.add(new Image(image.getUrl(), image.getSize()));
        }

        return new Track(
                track.getName(),
                null,
                track.getUrl(),
                track.getPlaycount(),
                track.getListeners(),
                images
        );
    }

    static List<RTrack> toRTracks(List<Track> tracks) {
        ArrayList<RTrack> result = new ArrayList<>();

        for (Track track : tracks) {
            result.add(toRTrack(track));
        }

        return result;
    }

    static List<Track> toTracks(List<RTrack> tracks) {
        ArrayList<Track> result = new ArrayList<>();

        for (RTrack rTrack : tracks) {
            result.add(toTrack(rTrack));
        }

        return result;
    }
}
