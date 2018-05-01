package com.smoothspark.msgme.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by SmoothSpark on 2018. 04. 27.
 */
public interface MvpView {

    void showLoading();

    void hideLoading();

    void onError(@StringRes int stringId);

    void onError(String msg);

    void showMessage(@StringRes int stringId);

    void showMessage(String msg);

    boolean isNetworkConnected();
}
