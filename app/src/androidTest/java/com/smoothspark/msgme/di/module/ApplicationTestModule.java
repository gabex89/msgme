package com.smoothspark.msgme.di.module;

import android.app.Application;
import android.content.Context;

import com.smoothspark.msgme.BuildConfig;
import com.smoothspark.msgme.data.AppDataManager;
import com.smoothspark.msgme.data.DataManager;
import com.smoothspark.msgme.data.network.ApiHelper;
import com.smoothspark.msgme.data.network.AppApiHelper;
import com.smoothspark.msgme.di.ApiInfo;
import com.smoothspark.msgme.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by SmoothSpark on 2018. 05. 01.
 */
@Module
public class ApplicationTestModule {

    private final Application application;

    public ApplicationTestModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    @ApiInfo
    String provideUrl() {
        return BuildConfig.URL;
    }

    //TODO Mock these below!!!

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

}