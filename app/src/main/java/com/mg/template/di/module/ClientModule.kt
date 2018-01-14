package com.mg.template.di.module

import com.mg.template.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ClientModule {

  @Provides
  @Singleton
  fun provideClient(networkTimeoutSecond: Long, logger: HttpLoggingInterceptor): OkHttpClient {

    val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
    okHttpClientBuilder.readTimeout(networkTimeoutSecond, TimeUnit.SECONDS)
    okHttpClientBuilder.connectTimeout(networkTimeoutSecond, TimeUnit.SECONDS)

    if (BuildConfig.DEBUG) {

      logger.level = HttpLoggingInterceptor.Level.BODY
      okHttpClientBuilder.addInterceptor(logger)
    }

    return okHttpClientBuilder.build()

  }

}