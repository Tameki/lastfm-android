package com.geektech.lastfmapp.presentation.toptracks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.geektech.lastfmapp.App;

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

        mPresenter = new TopTracksPresenter(App.tracksRepository);
        mPresenter.attachView(fragment);
        mPresenter.getTracks();
    }
}
