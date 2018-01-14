package com.mg.template.di.module

import com.mg.template.bus.RxEventBus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RxEventBusModule {

  @Singleton
  @Provides
  fun provideRxBus(): RxEventBus = RxEventBus()
}