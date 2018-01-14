package com.mg.template.di.module

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.mg.template.TemplateApplication
import com.mg.template.bus.RxEventBus
import com.mg.template.cache.ApplicationCache
import com.mg.template.constant.Constant
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class CacheModule {

  @Provides
  @Singleton
  @Named(Constant.APPLICATION_SHARED_PREFERENCES)
  internal fun provideApplicationSharedPreference(
      application: TemplateApplication): SharedPreferences {
    return application.getSharedPreferences(Constant.APPLICATION_SHARED_PREFERENCES,
        Context.MODE_PRIVATE)
  }

  @Provides
  @Singleton internal fun provideApplicationCache(
      @Named(Constant.APPLICATION_SHARED_PREFERENCES) applicationPreferences: SharedPreferences,
      gson: Gson, rxEventBus: RxEventBus): ApplicationCache = ApplicationCache(
      applicationPreferences,
      gson, rxEventBus)
}
