package com.mg.template

import android.app.Activity
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.espresso.matcher.ViewMatchers.Visibility
import android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.view.View
import android.widget.EditText
import org.hamcrest.Description
import org.hamcrest.Matcher


class CustomMatchers {
  fun <T : Activity> nextOpenActivityIs(clazz: Class<T>) {
    intended(IntentMatchers.hasComponent(clazz.name))
  }

  fun viewIsVisibleAndContainsText(@StringRes stringResource: Int) {
    onView(withText(stringResource)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
  }

  fun viewContainsText(@IdRes viewId: Int, @StringRes stringResource: Int) {
    onView(withId(viewId)).check(matches(withText(stringResource)))
  }

  fun hasErrorText(stringMatcher: Matcher<String>): Matcher<View> {
    checkNotNull(stringMatcher)
    return object : BoundedMatcher<View, EditText>(EditText::class.java) {

      override fun describeTo(description: Description) {
        description.appendText("with error: ")
        stringMatcher.describeTo(description)
      }

      override fun matchesSafely(view: EditText): Boolean {
        return if (view.error == null) stringMatcher.matches(view.error) else stringMatcher.matches(
            view.error.toString())
      }
    }
  }


}