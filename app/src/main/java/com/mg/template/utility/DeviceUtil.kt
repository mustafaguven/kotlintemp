package com.mg.template.utility

import android.content.res.Resources
import android.os.Build
import android.os.Build.VERSION
import android.util.DisplayMetrics
import com.mg.template.BuildConfig
import com.mg.template.TemplateApplication


class DeviceUtil(private val application: TemplateApplication) {

  companion object {
    private val STATUS_BAR_HEIGHT = "status_bar_height"
    private val DIMEN = "dimen"
    private val ANDROID = "android"
  }

  val statusBarHeight: Int
    get() {
      var result = 0
      val resourceId = application.resources.getIdentifier(STATUS_BAR_HEIGHT, DIMEN, ANDROID)
      if (resourceId > 0) {
        result = application.resources.getDimensionPixelSize(resourceId)
      }
      return result
    }


  fun convertDpToPixel(dp: Float): Float {
    val resources = application.resources
    val metrics = resources.displayMetrics
    return dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
  }

  fun convertPixelsToDp(px: Float): Float {
    val resources = application.resources
    val metrics = resources.displayMetrics
    return px / (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
  }

  fun getScreenWidth(): Int {
    return Resources.getSystem().displayMetrics.widthPixels
  }

  fun getScreenHeight(): Int {
    return Resources.getSystem().displayMetrics.heightPixels
  }

  val osVersion = VERSION.RELEASE

  val apiVersion = BuildConfig.API_VERSION

  val apiKey = BuildConfig.API_KEY

  val versionCode: Int = BuildConfig.VERSION_CODE

  val phoneBrand: String = Build.MANUFACTURER

  val phoneModel: String = Build.MODEL

  val versionName: String = BuildConfig.VERSION_NAME

}
