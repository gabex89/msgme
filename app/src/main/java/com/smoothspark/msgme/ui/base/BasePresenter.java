package com.smoothspark.msgme.ui.base;

import com.smoothspark.msgme.data.DataManager;

import javax.inject.Inject;

/**
 * Created by SmoothSpark on 2018. 04. 27.
 */
public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private static final String TAG = BasePresenter.class.getSimpleName();

    private final DataManager dataManager;

    private V mvpView;

    @Inject
    public BasePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void onAttach(V mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void onDetach() {
        this.mvpView = null;
    }

    public boolean isViewAttached() {
        return mvpView != null;
    }

    public V getMvpView() {
        return mvpView;
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
