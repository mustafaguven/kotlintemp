package com.mg.template.di.module

import com.mg.template.wrapper.UriWrapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UriWrapperModule {

  @Singleton
  @Provides
  fun providesUriWrapper(): UriWrapper = UriWrapper()

}