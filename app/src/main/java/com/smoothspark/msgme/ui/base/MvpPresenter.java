package com.smoothspark.msgme.ui.base;

/**
 * Created by SmoothSpark on 2018. 04. 27.
 */
public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();
}
