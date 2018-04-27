package com.smoothspark.msgme.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.smoothspark.msgme.di.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by SmoothSpark on 2018. 04. 27.
 */
@Module
public class ActivityModule {

    private AppCompatActivity appCompatActivity;

    public ActivityModule(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return appCompatActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return appCompatActivity;
    }


}
