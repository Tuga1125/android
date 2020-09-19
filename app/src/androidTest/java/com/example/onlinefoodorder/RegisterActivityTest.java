package com.example.onlinefoodorder;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.example.onlinefoodorder.Activity.RegisterActivity;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class RegisterActivityTest {

    @Rule
    public ActivityTestRule<RegisterActivity> RegisterTest = new ActivityTestRule<>(RegisterActivity.class);

    @Test
    public void TestRegister(){
        onView(withId(R.id.edtFirstName)).perform(typeText("abcdefgh"));

        closeSoftKeyboard();
        onView(withId(R.id.edtLastName)).perform(typeText("abcdefgh"));

        closeSoftKeyboard();

        onView(withId(R.id.edtUsername)).perform(typeText("abcdefgh"));

        closeSoftKeyboard();

        onView(withId(R.id.edtEmail)).perform(typeText("abcd@gmail.com"));

        closeSoftKeyboard();

        onView(withId(R.id.edtPassword)).perform(typeText("abcde11"));

        closeSoftKeyboard();

        onView(withId(R.id.btnRegister)).perform(click());
    }


}
