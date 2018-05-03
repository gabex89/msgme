package com.smoothspark.msgme.data.db;

import com.smoothspark.msgme.data.db.model.DaoMaster;
import com.smoothspark.msgme.data.db.model.DaoSession;

import java.util.ArrayList;
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
    public List<String> getPreviousMessages() {
//        return daoSession.getUserDao().loadAll();
        return new ArrayList<>();
    }

}
