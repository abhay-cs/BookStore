package com.uom.thebookstore.ui;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static org.hamcrest.CoreMatchers.anything;
import static java.util.concurrent.CompletableFuture.allOf;

import android.widget.GridView;

import androidx.recyclerview.widget.GridLayoutManager;
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

    @Test
    public void checkSearch(){

        onView(withId(R.id.signin)).perform(click());

        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.userName)).perform(click());
        onView(withId(R.id.userName)).perform(typeText("user@mail.com"));

        onView(withId(R.id.password)).perform(click());
        onView(withId(R.id.password)).perform(typeText("username123"));

        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.searchViewBar)).perform(click());
        onView(withId(R.id.searchViewBar)).perform(typeText("things\n"));

//        onView(withId())

    }

    @Test
    public void checkCart(){

        onView(withId(R.id.signin)).perform(click());

        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.userName)).perform(click());
        onView(withId(R.id.userName)).perform(typeText("user@mail.com"));

        onView(withId(R.id.password)).perform(click());
        onView(withId(R.id.password)).perform(typeText("username123"));

        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.button)).perform(click());

        onData(anything()).inAdapterView(withId(R.id.gridviewBuyPage)).atPosition(2).perform(click());
        onView(withId(R.id.addToCart)).perform(click());

//        onView(withId(R.id.cart)).perform(click()).check(matches(isDisplayed()));

    }

    @Test
    public void checkBuy(){

        onView(withId(R.id.signin)).perform(click());

        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.userName)).perform(click());
        onView(withId(R.id.userName)).perform(typeText("user@mail.com"));

        onView(withId(R.id.password)).perform(click());
        onView(withId(R.id.password)).perform(typeText("username123"));

        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.button)).perform(click());

        onData(anything()).inAdapterView(withId(R.id.gridviewBuyPage)).atPosition(2).perform(click());
        onView(withId(R.id.addToCart)).perform(click());

        onView(withId(R.id.buy_now)).perform(click());
    }
}
