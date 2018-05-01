package com.smoothspark.msgme.di.component;

import android.app.Application;
import android.content.Context;

import com.smoothspark.msgme.MsgMeApplication;
import com.smoothspark.msgme.data.DataManager;
import com.smoothspark.msgme.di.ApplicationContext;
import com.smoothspark.msgme.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by SmoothSpark on 2018. 04. 27.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MsgMeApplication application);

    DataManager getDataManager();

    @ApplicationContext
    Context context();

    Application application();
}
