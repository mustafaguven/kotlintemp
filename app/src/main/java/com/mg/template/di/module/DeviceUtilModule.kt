package com.mg.template.di.module

import com.mg.template.TemplateApplication
import com.mg.template.utility.DeviceUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DeviceUtilModule {

  @Provides
  @Singleton
  fun provideDeviceUtil(app: TemplateApplication) = DeviceUtil(app)
}