package com.smoothspark.msgme.data.db;

import android.content.Context;

import com.smoothspark.msgme.data.db.model.DaoMaster;
import com.smoothspark.msgme.di.ApplicationContext;
import com.smoothspark.msgme.di.DatabaseInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by SmoothSpark on 2018. 05. 04.
 */
@Singleton
public class DbOpenHelper extends DaoMaster.OpenHelper {

    @Inject
    public DbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
        super(context, name);
    }
}
