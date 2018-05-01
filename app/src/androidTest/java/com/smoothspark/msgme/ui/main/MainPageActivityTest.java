package com.smoothspark.msgme.ui.main;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.smoothspark.msgme.R;
import com.smoothspark.msgme.TestComponentRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by SmoothSpark on 2018. 05. 01.
 */
@RunWith(AndroidJUnit4.class)
public class MainPageActivityTest {

    public final TestComponentRule component =
            new TestComponentRule(InstrumentationRegistry.getTargetContext());

    public final IntentsTestRule<MainPageActivity> main =
            new IntentsTestRule<>(MainPageActivity.class, false, false);

    @Rule
    public TestRule chain = RuleChain.outerRule(component).around(main);

    @Test
    public void checkViewsDisplayed() {
        main.launchActivity(MainPageActivity.getStartIntent(component.getContext()));

        onView(withId(R.id.sendButton))
                .check(matches(isDisplayed()));

        onView(withId(R.id.messageEditText))
                .check(matches(isDisplayed()));

        onView(withId(R.id.messageRecyclerView))
                .check(matches(isDisplayed()));
    }
}