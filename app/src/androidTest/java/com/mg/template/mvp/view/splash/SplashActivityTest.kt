package com.mg.template.mvp.view.splash

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.mg.template.AcceptanceTest
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SplashActivityTest : AcceptanceTest<SplashActivity>(SplashActivity::class.java) {

  @Test
  @Throws(Exception::class)
  fun testTopPadding() {
    val appContext = InstrumentationRegistry.getTargetContext()
    Assert.assertEquals("com.abc", appContext.packageName)
  }

}