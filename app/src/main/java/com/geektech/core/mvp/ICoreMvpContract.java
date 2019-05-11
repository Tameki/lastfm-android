package com.geektech.core.mvp;

public interface ICoreMvpContract {
    interface View<T extends Presenter> {
        void attachPresenter(T presenter);

        void finishView();

        void showMessage(String message);
    }

    interface Presenter<T extends View> {
        void attachView(T view);

        void detachView();

        void onViewCreated();
    }
}
