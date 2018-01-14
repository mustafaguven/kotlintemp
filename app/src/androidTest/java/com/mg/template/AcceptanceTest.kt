package com.mg.template

import android.app.Activity
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.mg.template.mvp.view.Events
import org.junit.Rule
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
abstract class AcceptanceTest<T : Activity>(clazz: Class<T>) {

  @Rule
  @JvmField
  val testRule: ActivityTestRule<T> = IntentsTestRule(clazz)

  val checkThat: CustomMatchers = CustomMatchers()
  val events: Events = Events()
}