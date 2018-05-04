package com.smoothspark.msgme.data.db;

import com.smoothspark.msgme.data.db.model.DaoMaster;
import com.smoothspark.msgme.data.db.model.DaoSession;
import com.smoothspark.msgme.data.db.model.Message;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by SmoothSpark on 2018. 05. 04.
 */
@Singleton
public class AppDbHelper implements DbHelper {

    private final DaoSession daoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        daoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    @Override
    public List<Message> retrievePreviousMessagesFromDb() {
        return daoSession.getMessageDao().loadAll();
    }

    @Override
    public boolean saveMessagesToDb(List<Message> messages) {
        daoSession.getMessageDao().deleteAll();
        daoSession.getMessageDao().insertInTx(messages);
        return true;
    }

}
