package com.smoothspark.msgme.data.network;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by SmoothSpark on 2018. 04. 28.
 */
@Singleton
public class AppApiClientBuilder {

    private static final String WEBSOCKETSTRING = "wss://remy-ws.glitch.me";

    @Inject
    public AppApiClientBuilder() {
    }


}
