package com.smoothspark.msgme.data;

import android.content.Context;

import com.smoothspark.msgme.data.network.ApiHelper;
import com.smoothspark.msgme.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by SmoothSpark on 2018. 04. 27.
 */
@Singleton
public class AppDataManager implements DataManager {

    private final Context context;
    private final ApiHelper apiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          ApiHelper apiHelper) {
        this.context = context;
        this.apiHelper = apiHelper;
    }
}