package com.geektech.lastfmapp.presentation.toptracks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.model.TrackEntity;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TopTracksActivity extends AppCompatActivity {

    private ITopTracksContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TopTracksFragment fragment = TopTracksFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, fragment)
                .commit();

//        mPresenter = new TopTracksPresenter();
//        mPresenter.attachView(fragment);
    }
}
