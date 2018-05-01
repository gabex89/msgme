package com.smoothspark.msgme.ui.main;

import android.support.annotation.Nullable;

import com.smoothspark.msgme.data.DataManager;
import com.smoothspark.msgme.ui.base.BasePresenter;

import javax.inject.Inject;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/**
 * Created by SmoothSpark on 2018. 04. 28.
 */
public class MainPagePresenter<V extends MainPageMvpView> extends BasePresenter<V>
        implements MainPageMvpPresenter<V> {

    private WebSocket webSocket;

    @Inject
    public MainPagePresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void openWebSocket() {
        getMvpView().showLoading();
        webSocket = getDataManager().openWebSocket(new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                getMvpView().hideLoading();
                getMvpView().showMessage("Socket open");
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                getMvpView().updateMessagesList(text);
            }

            @Override
            public void onClosed(WebSocket webSocket, int code, String reason) {
                getMvpView().hideLoading();
                getMvpView().showMessage("Socket closed");
            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable t, @Nullable Response response) {
                getMvpView().hideLoading();
                getMvpView().showMessage("Socket failed to open");
            }
        });
    }

    @Override
    public boolean sendMessage(String message) {
        return webSocket.send(message);
    }
}
