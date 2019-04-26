package com.geektech.core.mvp;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.core.CoreUtils;

public abstract class CoreMvpFragment<T extends ICoreMvpContract.Presenter> extends Fragment
    implements ICoreMvpContract.View<T> {

    @Nullable
    protected T presenter;

    @LayoutRes
    protected abstract int getLayoutId();
    protected abstract void initView(View view);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void attachPresenter(T presenter) {
        this.presenter = presenter;
    }

    @Override
    public void finishView() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    @Override
    public void showMessage(String message) {
        CoreUtils.showShortToast(getContext(), message);
    }
}
