package com.mg.template.di.module

import com.mg.template.utility.FileUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FileUtilModule {

  @Singleton
  @Provides
  fun providesFileUtil(): FileUtil = FileUtil()

}