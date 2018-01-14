package com.mg.template.mvp.view

import android.support.annotation.IdRes
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId

class Events {
  fun selectView(@IdRes viewId: Int) {
    onView(withId(viewId))
  }

  fun clickOnView(@IdRes viewId: Int) {
    onView(withId(viewId)).perform(click())
  }
}