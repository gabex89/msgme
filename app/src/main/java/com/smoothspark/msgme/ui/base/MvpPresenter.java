package com.smoothspark.msgme.ui.base;

import com.androidnetworking.error.ANError;

/**
 * Created by SmoothSpark on 2018. 04. 27.
 */
public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

    void handleNetworkError(ANError error);
}
