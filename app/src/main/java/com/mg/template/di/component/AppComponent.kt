package com.mg.template.di.component

import com.mg.template.TemplateApplication
import com.mg.template.di.module.ApplicationModule
import com.mg.template.di.module.CacheModule
import com.mg.template.di.module.DeviceUtilModule
import com.mg.template.di.module.FileUtilModule
import com.mg.template.di.module.GsonModule
import com.mg.template.di.module.RxEventBusModule
import com.mg.template.di.module.SchedulerModule
import com.mg.template.di.module.UriWrapperModule
import com.mg.template.di.module.network.RestServicesModule
import com.mg.template.di.module.screen.SplashActivityModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    ApplicationModule::class,
    CacheModule::class,
    DeviceUtilModule::class,
    RxEventBusModule::class,
    GsonModule::class,
    RestServicesModule::class,
    SchedulerModule::class,
    FileUtilModule::class,
    UriWrapperModule::class
))
interface AppComponent {
  fun inject(application: TemplateApplication)

  fun plus(splashActivityModule: SplashActivityModule): SplashActivityComponent


}