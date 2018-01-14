package com.mg.template.di.module.screen

import android.app.Activity
import com.mg.template.di.module.ActivityModule
import com.mg.template.mvp.contract.SplashContract
import com.mg.template.mvp.contract.SplashContract.View
import dagger.Module
import dagger.Provides


@Module
class SplashActivityModule(activity: Activity) : ActivityModule(activity) {

  @Provides
  fun provideView(): SplashContract.View = activity as View

}