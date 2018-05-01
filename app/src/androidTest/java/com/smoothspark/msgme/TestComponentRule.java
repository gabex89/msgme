package com.smoothspark.msgme;

import android.content.Context;

import com.smoothspark.msgme.data.DataManager;
import com.smoothspark.msgme.di.component.DaggerTestApplicationComponent;
import com.smoothspark.msgme.di.component.TestApplicationComponent;
import com.smoothspark.msgme.di.module.ApplicationTestModule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by SmoothSpark on 2018. 05. 01.
 */
public class TestComponentRule implements TestRule {

    private TestApplicationComponent testComponent;
    private Context context;

    public TestComponentRule(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public DataManager getDataManager() {
        return testComponent.getDataManager();
    }

    private void setupDaggerTestComponentInApplication() {
        MsgMeApplication application = ((MsgMeApplication) context.getApplicationContext());
        testComponent = DaggerTestApplicationComponent.builder()
                .applicationTestModule(new ApplicationTestModule(application))
                .build();
        application.setApplicationComponent(testComponent);
    }

    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    setupDaggerTestComponentInApplication();
                    base.evaluate();
                } finally {
                    testComponent = null;
                }
            }
        };
    }
}
