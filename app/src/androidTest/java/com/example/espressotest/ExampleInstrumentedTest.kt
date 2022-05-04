package com.example.espressotest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun isHelloWorldDisplayed() {

        onView(withId(R.id.TV_hello)).check(matches(withText("Hello World!")))
    }

    @Test
    fun isHelloWorldClickable() {onView(withId(R.id.TV_hello)).check(matches(isNotClickable()))}

    @Test
    fun isEditTextFocused() {onView(withId(R.id.ET_input)).check(matches(isFocusable()))
    }

    @Test
    fun isButtonClickable() {onView(withId(R.id.BTN_click)).check(matches(isClickable()))}

    @Test
    fun isButtonFocusable() {onView(withId(R.id.BTN_click)).check(matches(isFocusable()))}

    @Test
    fun writeSomethingInEditText() {

        onView(withId(R.id.ET_input)).perform(
            ViewActions.typeText("ALL YOU NEED IS VERVE"))
    }

    @Test
    fun clickOnButton(){onView(withId(R.id.BTN_click)).perform(ViewActions.click())}

    @Test
    fun clickToSendEditTextToTextView(){

        onView(withId(R.id.ET_input)).perform(
            ViewActions.typeText("Espresso, baby!"))
        onView(withId(R.id.BTN_click)).perform(ViewActions.click())
        Thread.sleep(1000)
        onView(withId(R.id.TV_hello)).check(matches(withText("Espresso, baby!")))
    }
}

