package com.geektech.lastfmapp.data.tracks.local;

import com.geektech.core.Logger;
import com.geektech.core.realm.CoreRealmDataSource;
import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.entities.Track;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class TracksLocalStorage extends CoreRealmDataSource
        implements ITracksLocalStorage {

    private void getArtistTracks(String artistName, ITracksRepository.TracksCallback callback) {
        Realm realm = null;

        try {
            realm = getRealmInstance();

            //TODO: Search tracks by artistName
        } catch (Exception e) {
            Logger.e(e);
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    @Override
    public void getTracks(ITracksRepository.TracksCallback callback) {
        Realm realm = null;

        try {
            realm = getRealmInstance();

            RealmResults<RTrack> results = realm.where(RTrack.class).findAll();

            callback.onSuccess(
                    TracksMapper.toTracks(realm.copyFromRealm(results))
            );
        } catch (Exception e) {
            Logger.e(e);
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    @Override
    public void setTracks(List<Track> tracks) {
        List<RTrack> rTracks = TracksMapper.toRTracks(tracks);

        executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for (RTrack rTrack : rTracks) {

                    RTrack managedTrack = realm.where(RTrack.class)
                            .equalTo("uniqueId", rTrack.getUniqueId())
                            .findFirst();

                    if (managedTrack == null) {
                        realm.copyToRealm(rTrack);
                    } else {
                        managedTrack.setListeners(rTrack.getListeners());
                        managedTrack.setPlaycount(rTrack.getPlaycount());
                    }
                }

//                managedTrack.getImages().deleteAllFromRealm();
//                managedTrack.deleteFromRealm();
            }
        });
    }

    @Override
    public Track getTrack(String uniqueId) {
        //TODO: Find RTrack by uniqueId
        return null;
    }
}
