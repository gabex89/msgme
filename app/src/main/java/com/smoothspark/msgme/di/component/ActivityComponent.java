package com.smoothspark.msgme.di.component;

import com.smoothspark.msgme.di.PerActivity;
import com.smoothspark.msgme.di.module.ActivityModule;
import com.smoothspark.msgme.ui.main.MainPageActivity;

import dagger.Component;

/**
 * Created by SmoothSpark on 2018. 04. 27.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainPageActivity activity);
}
