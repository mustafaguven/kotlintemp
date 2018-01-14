package com.mg.template.mvp.presenter.splash

import com.mg.template.cache.ApplicationCache
import com.mg.template.mvp.contract.SplashContract
import com.mg.template.mvp.contract.SplashContract.Interactor
import com.mg.template.mvp.contract.SplashContract.View
import com.mg.template.utility.DeviceUtil
import com.mg.template.utility.FileUtil
import com.mg.template.wrapper.UriWrapper
import io.reactivex.disposables.CompositeDisposable


class SplashPresenter(
    private val view: View,
    private val interactor: Interactor,
    private val uriWrapper: UriWrapper,
    private val compositeDisposable: CompositeDisposable,
    private val cache: ApplicationCache,
    private val fileUtil: FileUtil,
    private val deviceUtil: DeviceUtil) : SplashContract.Presenter {

  private var commercialLink: String? = null

  override fun onCreate() {
  }


  override fun onDestroy() {
    if (!compositeDisposable.isDisposed) {
      compositeDisposable.dispose()
    }
  }

}
