package com.mg.template.di.module.screen

import com.mg.template.cache.ApplicationCache
import com.mg.template.mvp.contract.SplashContract
import com.mg.template.mvp.presenter.splash.SplashPresenter
import com.mg.template.utility.DeviceUtil
import com.mg.template.utility.FileUtil
import com.mg.template.wrapper.UriWrapper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class SplashPresenterModule {

  @Provides
  fun providePresenter(contract: SplashContract.View,
      interactor: SplashContract.Interactor,
      uriWrapper: UriWrapper,
      compositeDisposable: CompositeDisposable,
      cache: ApplicationCache,
      fileUtil: FileUtil, deviceUtil: DeviceUtil): SplashContract.Presenter = SplashPresenter(
      contract,
      interactor, uriWrapper, compositeDisposable, cache, fileUtil, deviceUtil)

}