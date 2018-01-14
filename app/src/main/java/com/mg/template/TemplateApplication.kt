package com.mg.template

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.mg.template.bus.RxEventBus
import com.mg.template.di.component.AppComponent
import com.mg.template.di.component.DaggerAppComponent
import com.mg.template.di.module.ApplicationModule
import javax.inject.Inject

class TemplateApplication : Application() {

  lateinit var appComponent: AppComponent

  @Inject lateinit var bus: RxEventBus

  override fun onCreate() {
    super.onCreate()
    appComponent = DaggerAppComponent.builder().applicationModule(
        ApplicationModule(this)).build()
    appComponent.inject(this)
  }

  override fun attachBaseContext(base: Context?) {
    super.attachBaseContext(base)
    MultiDex.install(this)
  }

}
