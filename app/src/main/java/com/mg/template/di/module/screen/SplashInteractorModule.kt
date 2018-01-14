package com.mg.template.di.module.screen

import com.mg.template.mvp.contract.SplashContract
import com.mg.template.mvp.interactor.splash.SplashInteractor
import com.mg.template.network.InitService
import com.mg.template.utility.rx.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class SplashInteractorModule {

  @Provides
  fun provideInteractor(initService: InitService,
      schedulerProvider: SchedulerProvider):
      SplashContract.Interactor = SplashInteractor(
      initService, schedulerProvider)

}