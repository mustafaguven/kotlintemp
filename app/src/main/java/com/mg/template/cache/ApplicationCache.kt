package com.mg.template.cache

import android.content.SharedPreferences
import com.google.gson.Gson
import com.mg.template.bus.RxEventBus
import com.mg.template.constant.Constant

class ApplicationCache(private val applicationSharedPreferences: SharedPreferences,
    private val gson: Gson, rxEventBus: RxEventBus) {

  private fun <T> getObjectWithGenericDeserializer(key: String, clz: Class<T>): T {
    return gson.fromJson(applicationSharedPreferences.getString(key, null), clz)
  }

  private fun <T> setObjectWithGenericSerializer(key: String, t: T) {
    this.applicationSharedPreferences.edit().putString(key, gson.toJson(t)).apply()
  }

  fun removeApplicationCache() {
    applicationSharedPreferences.edit().clear().apply()
  }

  fun updateTestCache(s: String) {
    this.applicationSharedPreferences.edit().putString(CacheKey.TEST_NAME, s).apply()
  }

  fun getUpdateTestCache() =
      this.applicationSharedPreferences.getString(CacheKey.TEST_NAME, Constant.STRING_EMPTY)


}
