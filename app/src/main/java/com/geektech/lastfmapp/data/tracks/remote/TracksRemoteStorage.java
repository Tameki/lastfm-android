package com.geektech.lastfmapp.data.tracks.remote;

import com.geektech.lastfmapp.BuildConfig;
import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.data.tracks.remote.model.TracksResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class TracksRemoteStorage implements ITracksRemoteStorage {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static TracksNetworkClient client = retrofit.create(TracksNetworkClient.class);

    @Override
    public void getTracks(ITracksRepository.TracksCallback callback) {
        Call<TracksResponse> call = client.getTracks(
                "chart.getTopTracks",
                BuildConfig.API_KEY,
                "json",
                1,
                100
        );

        call.enqueue(new Callback<TracksResponse>() {
            @Override
            public void onResponse(Call<TracksResponse> call, Response<TracksResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body().getTracks().getData());
                    } else {
                        callback.onFailure("Body is empty " + response.code());
                    }
                } else {
                    callback.onFailure("Request failed " + response.code());
                }
            }

            @Override
            public void onFailure(Call<TracksResponse> call, Throwable t) {
                callback.onFailure("Top tracks failure: " + t.getMessage());
            }
        });
    }

    private interface TracksNetworkClient {

        @GET("/2.0/")
        Call<TracksResponse> getTracks(
                @Query("method") String method,
                @Query("api_key") String apiKey,
                @Query("format") String format,
                @Query("page") int page,
                @Query("limit") int limit
        );
    }
}
