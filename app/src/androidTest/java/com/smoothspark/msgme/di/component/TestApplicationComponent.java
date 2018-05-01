package com.smoothspark.msgme.di.component;

import com.smoothspark.msgme.di.module.ApplicationTestModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by SmoothSpark on 2018. 05. 01.
 */
@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestApplicationComponent extends ApplicationComponent {
}