package com.example.onlinefoodorder;

import androidx.test.rule.ActivityTestRule;

import com.example.onlinefoodorder.Activity.LoginScreenActivity;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class LoginActivityTest {
//
    @Rule
    public ActivityTestRule<LoginScreenActivity> LoginTest = new ActivityTestRule<>(LoginScreenActivity.class);

    @Test
    public void TestLogin() throws Exception
    {

        onView(withId(R.id.edtUsername)).perform(typeText("abcdefgh"));

        closeSoftKeyboard();

        onView(withId(R.id.edtPassword)).perform(typeText("abcdefgh"));

        closeSoftKeyboard();

        onView(withId(R.id.btnLogin)).perform(click());

    }

}

