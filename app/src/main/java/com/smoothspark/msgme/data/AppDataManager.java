package com.smoothspark.msgme.data;

import android.content.Context;

import com.smoothspark.msgme.data.db.DbHelper;
import com.smoothspark.msgme.data.db.model.Message;
import com.smoothspark.msgme.data.network.ApiHelper;
import com.smoothspark.msgme.di.ApplicationContext;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/**
 * Created by SmoothSpark on 2018. 04. 27.
 */
@Singleton
public class AppDataManager implements DataManager {

    private final Context context;
    private final ApiHelper apiHelper;
    private final DbHelper dbHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          ApiHelper apiHelper,
                          DbHelper dbHelper) {
        this.context = context;
        this.apiHelper = apiHelper;
        this.dbHelper = dbHelper;
    }

    @Override
    public WebSocket openWebSocket(WebSocketListener webSocketListener) {
        return apiHelper.openWebSocket(webSocketListener);
    }

    @Override
    public List<Message> retrievePreviousMessagesFromDb() {
        return dbHelper.retrievePreviousMessagesFromDb();
    }

    @Override
    public boolean saveMessagesToDb(List<Message> messages) {
        return dbHelper.saveMessagesToDb(messages);
    }
}
