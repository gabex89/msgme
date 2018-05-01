package com.smoothspark.msgme.data.network;

import com.smoothspark.msgme.BuildConfig;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/**
 * Created by SmoothSpark on 2018. 04. 27.
 */
@Singleton
public class AppApiHelper implements ApiHelper {

    private OkHttpClient okHttpClient;

    @Inject
    public AppApiHelper() {
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(3, TimeUnit.SECONDS)
                .pingInterval(10, TimeUnit.SECONDS)
                .build();
    }

    @Override
    public WebSocket openWebSocket(WebSocketListener webSocketListener) {
        Request request = new Request.Builder()
                .url(BuildConfig.URL)
                .build();
        return okHttpClient.newWebSocket(request, webSocketListener);
    }
}
