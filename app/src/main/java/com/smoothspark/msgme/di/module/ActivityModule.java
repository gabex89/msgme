package com.smoothspark.msgme.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.smoothspark.msgme.di.ActivityContext;
import com.smoothspark.msgme.ui.main.MainMessageListAdapter;
import com.smoothspark.msgme.ui.main.MainPageMvpPresenter;
import com.smoothspark.msgme.ui.main.MainPageMvpView;
import com.smoothspark.msgme.ui.main.MainPagePresenter;

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

    @Provides
    MainPageMvpPresenter<MainPageMvpView> provideMainPagePresenter(
            MainPagePresenter<MainPageMvpView> presenter) {
        return presenter;
    }

    @Provides
    MainPageMvpPresenter provideMainPageMvpPresenter(
            MainPagePresenter<MainPageMvpView> presenter) {
        return presenter;
    }

    @Provides
    MainMessageListAdapter provideMainMessageListAdapter() {
        return new MainMessageListAdapter();
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
