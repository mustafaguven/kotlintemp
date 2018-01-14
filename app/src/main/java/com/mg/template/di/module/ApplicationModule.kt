package com.mg.template.di.module

import android.content.Context
import android.content.res.Resources
import com.mg.template.TemplateApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(var application: TemplateApplication) {

  @Provides
  @Singleton
  fun provideApplication() = application

  @Provides
  @Singleton
  fun provideResources(context: Context): Resources = context.resources

}