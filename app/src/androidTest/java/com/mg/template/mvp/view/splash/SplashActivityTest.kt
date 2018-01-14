package com.mg.template.mvp.view.splash

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.mg.template.AcceptanceTest
import com.mg.template.R
import com.mg.template.mvp.view.gsm.GsmSaveActivity
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SplashActivityTest : AcceptanceTest<SplashActivity>(SplashActivity::class.java) {

  @Test
  @Throws(Exception::class)
  fun testTopPadding() {
    val appContext = InstrumentationRegistry.getTargetContext()
    Assert.assertEquals("com.mavi.kartus", appContext.packageName)
  }

  @Test
  fun shouldDisplayGsmSaveActivityWhenClickBtnLogin() {
    events.clickOnView(R.id.btnLogin)
    checkThat.nextOpenActivityIs(GsmSaveActivity::class.java)
  }

  @Test
  fun shouldDisplayGsmSaveActivityWhenClickBtnSignUp() {
    events.clickOnView(R.id.btnSignUp)
    checkThat.nextOpenActivityIs(GsmSaveActivity::class.java)
  }
}