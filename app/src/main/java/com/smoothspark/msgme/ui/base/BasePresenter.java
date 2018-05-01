package com.smoothspark.msgme.ui.base;

import com.androidnetworking.common.ANConstants;
import com.androidnetworking.error.ANError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.smoothspark.msgme.R;
import com.smoothspark.msgme.data.DataManager;
import com.smoothspark.msgme.data.network.model.NetworkErrorModel;
import com.smoothspark.msgme.utils.AppLogger;

import java.net.HttpURLConnection;

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

    @Override
    public void handleNetworkError(ANError error) {
        if (error == null || error.getErrorBody() == null) {
            getMvpView().onError(R.string.network_default_error);
            return;
        }
        switch (error.getErrorDetail()) {
            case ANConstants.CONNECTION_ERROR:
                getMvpView().onError(R.string.network_connection_error);
                return;
            case ANConstants.REQUEST_CANCELLED_ERROR:
                getMvpView().onError(R.string.network_retry_error);
                return;
        }
        final GsonBuilder gsonBuilder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = gsonBuilder.create();
        try {
            NetworkErrorModel errorModel = gson.fromJson(error.getErrorBody(), NetworkErrorModel.class);
            if (errorModel == null || errorModel.getMessage() == null) {
                getMvpView().onError(R.string.network_default_error);
                return;
            }
            switch (error.getErrorCode()) {
                case HttpURLConnection.HTTP_INTERNAL_ERROR:
                case HttpURLConnection.HTTP_NOT_FOUND:
                    getMvpView().onError(errorModel.getMessage());
                    break;
            }

        } catch (JsonSyntaxException | NullPointerException e) {
            AppLogger.e(TAG);
            getMvpView().onError(R.string.network_default_error);
        }
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
