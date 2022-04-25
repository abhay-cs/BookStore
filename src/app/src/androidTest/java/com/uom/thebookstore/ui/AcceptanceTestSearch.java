package com.uom.thebookstore.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.uom.thebookstore.ui.start_page;
import com.uom.thebookstore.ui.signup_page;
import com.uom.thebookstore.ui.MainActivity;

@RunWith(AndroidJUnit4.class)

@LargeTest
public class AcceptanceTestSearch {

    @Rule
    public ActivityTestRule<welcome_page> activityTestRule = new ActivityTestRule<>(welcome_page.class);

    @Test
    public void testSearch(){

        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.searchViewBar)).perform(click());
        onView(withId(R.id.searchViewBar)).perform(typeText("India"));


    }
}
