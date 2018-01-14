package com.mg.template.di.module

import android.app.Activity
import android.view.LayoutInflater
import com.mg.template.di.scope.PerActivity
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
open class ActivityModule(protected val activity: Activity) {

  @Provides
  @PerActivity
  fun provideActivityContext(): Activity = activity

  @Provides
  @PerActivity
  fun provideLayoutInflater() = LayoutInflater.from(this.activity)

  @Provides
      //@PerActivity
  fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

  @Provides
  @PerActivity
  fun providePicasso(): Picasso = Picasso.with(provideActivityContext())

}