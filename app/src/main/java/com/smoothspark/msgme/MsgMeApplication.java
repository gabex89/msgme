package com.smoothspark.msgme;

import android.app.Application;

import com.smoothspark.msgme.data.DataManager;
import com.smoothspark.msgme.di.component.ApplicationComponent;
import com.smoothspark.msgme.di.component.DaggerApplicationComponent;
import com.smoothspark.msgme.di.module.ApplicationModule;
import com.smoothspark.msgme.utils.AppLogger;

import javax.inject.Inject;

/**
 * Created by SmoothSpark on 2018. 04. 27.
 */
public class MsgMeApplication extends Application {

    @Inject
    DataManager dataManager;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        applicationComponent.inject(this);

        AppLogger.initLogger();
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }

    //for tests
    public void setApplicationComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }
}
