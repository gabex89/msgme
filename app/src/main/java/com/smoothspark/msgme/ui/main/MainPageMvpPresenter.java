package com.smoothspark.msgme.ui.main;

import com.smoothspark.msgme.ui.base.MvpPresenter;

/**
 * Created by SmoothSpark on 2018. 04. 28.
 */
public interface MainPageMvpPresenter<V extends MainPageMvpView>
        extends MvpPresenter<V> {

    void openWebSocket();
}
