package com.mg.template.mvp.view.splash

import android.os.Bundle
import com.mg.template.R
import com.mg.template.cache.ApplicationCache
import com.mg.template.di.module.screen.SplashActivityModule
import com.mg.template.mvp.contract.SplashContract
import com.mg.template.mvp.view.AbstractBaseActivity
import javax.inject.Inject


@Suppress("DIFFERENT_NAMES_FOR_THE_SAME_PARAMETER_IN_SUPERTYPES")
class SplashActivity : AbstractBaseActivity(), SplashContract.View {

  override fun inject() {
    templateApplication.appComponent.plus(SplashActivityModule(this)).inject(this)
  }

  @Inject lateinit var presenter: SplashContract.Presenter
  @Inject lateinit var cache: ApplicationCache


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)
  }

}
