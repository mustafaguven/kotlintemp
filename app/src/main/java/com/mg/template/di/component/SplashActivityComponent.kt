package com.mg.template.di.component

import com.mg.template.di.module.screen.SplashActivityModule
import com.mg.template.di.module.screen.SplashInteractorModule
import com.mg.template.di.module.screen.SplashPresenterModule
import com.mg.template.mvp.view.splash.SplashActivity
import dagger.Subcomponent

@Subcomponent(
    modules = [(SplashActivityModule::class), (SplashPresenterModule::class), (SplashInteractorModule::class)])
interface SplashActivityComponent {
  fun inject(splashActivity: SplashActivity)
}