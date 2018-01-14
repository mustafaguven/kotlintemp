package com.mg.template.di.module

import com.mg.template.utility.rx.AppSchedulerProvider
import com.mg.template.utility.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SchedulerModule {

  @Provides
  @Singleton
  fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

}