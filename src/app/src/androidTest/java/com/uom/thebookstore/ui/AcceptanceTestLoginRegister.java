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
public class AcceptanceTestLoginRegister {

    @Rule
    public ActivityTestRule<start_page> activityTestRule = new ActivityTestRule<>(start_page.class);


    @Test
    public void checkRegister(){

        onView(withId(R.id.signup)).perform(click());

        onView(withId(R.id.editTextTextPersonNam)).perform(typeText("user"));

        onView(withId(R.id.editTextTextPersonName2)).perform(typeText("name"));

        onView(withId(R.id.editTextTextEmailAddress)).perform(typeText("user@mail.com"));

        onView(withId(R.id.editTextTextPassword)).perform(typeText("username123"));

        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.signup_btn)).perform(click());

    }

    @Test
    public void checkLogin(){

        onView(withId(R.id.signin)).perform(click());

        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.userName)).perform(click());
        onView(withId(R.id.userName)).perform(typeText("user@mail.com"));

        onView(withId(R.id.password)).perform(click());
        onView(withId(R.id.password)).perform(typeText("username123"));

        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.button)).perform(click());
    }


}
