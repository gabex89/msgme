package com.smoothspark.msgme.data.network;

import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/**
 * Created by SmoothSpark on 2018. 04. 27.
 */

public interface ApiHelper {

    WebSocket openWebSocket(WebSocketListener webSocketListener);
}
