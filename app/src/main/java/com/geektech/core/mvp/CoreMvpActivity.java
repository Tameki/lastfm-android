package com.geektech.core.mvp;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.geektech.core.CoreUtils;

public abstract class CoreMvpActivity<T extends ICoreMvpContract.Presenter> extends AppCompatActivity
    implements ICoreMvpContract.View<T> {

    @Nullable
    protected T presenter;

    @LayoutRes
    protected abstract int getLayoutId();
    protected abstract void initView();

    @Nullable
    protected abstract T providePresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        initView();

        presenter = providePresenter();
        if (presenter != null) {
            presenter.attachView(this);
            presenter.onViewCreated();
        }
    }

    @Override
    public void attachPresenter(T presenter) {
        this.presenter = presenter;
    }

    @Override
    public void finishView() {
        finish();
    }

    @Override
    public void showMessage(String message) {
        CoreUtils.showShortToast(this, message);
    }
}
