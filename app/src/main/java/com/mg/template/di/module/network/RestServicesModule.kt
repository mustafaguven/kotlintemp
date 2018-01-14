package com.mg.template.di.module.network

import com.mg.template.BuildConfig
import com.mg.template.network.EndPoints
import com.mg.template.network.InitService
import com.mg.template.network.LocationService
import com.mg.template.network.UserService
import com.mg.template.utility.DeviceUtil
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class RestServicesModule {

  companion object {
    private val CONNECT_TIMEOUT = 60L
    private val READ_TIMEOUT = 60L
  }

  @Provides
  @Singleton internal fun provideRxCallAdapterFactory(): CallAdapter.Factory =
      RxJava2CallAdapterFactory.create()

  @Provides
  @Singleton
  fun provideOkHttpClient(@HeaderInterceptor headerInterceptor: Interceptor,
      @LoggingInterceptor loggingInterceptor: Interceptor): OkHttpClient {
    return OkHttpClient.Builder().addInterceptor(headerInterceptor)
        .addInterceptor(loggingInterceptor)
        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()
  }

  @Provides
  @Singleton
  @LoggingInterceptor
  fun provideLoggingInterceptor(): Interceptor {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = if (BuildConfig.DEBUG) {
      HttpLoggingInterceptor.Level.BODY
    } else {
      HttpLoggingInterceptor.Level.NONE
    }

    return interceptor
  }

  @Provides
  @Singleton
  fun provideInitService(callAdapterFactory: CallAdapter.Factory,
      converterFactory: Converter.Factory, okHttpClient: OkHttpClient): InitService {
    val retrofit = Retrofit.Builder().baseUrl(EndPoints.BASE_URL)
        .addCallAdapterFactory(callAdapterFactory)
        .addConverterFactory(converterFactory)
        .client(okHttpClient)
        .build()
    return retrofit.create(InitService::class.java)
  }

  @Provides
  @Singleton
  fun provideUserService(callAdapterFactory: CallAdapter.Factory,
      converterFactory: Converter.Factory, okHttpClient: OkHttpClient): UserService {
    val retrofit = Retrofit.Builder().baseUrl(EndPoints.USER_SERVICE_URL)
        .addCallAdapterFactory(callAdapterFactory)
        .addConverterFactory(converterFactory)
        .client(okHttpClient)
        .build()
    return retrofit.create(UserService::class.java)
  }


  @Provides
  @Singleton
  fun provideLocationService(callAdapterFactory: CallAdapter.Factory,
      converterFactory: Converter.Factory, okHttpClient: OkHttpClient): LocationService {
    val retrofit = Retrofit.Builder().baseUrl(EndPoints.LOCATION_SERVICE_URL)
        .addCallAdapterFactory(callAdapterFactory)
        .addConverterFactory(converterFactory)
        .client(okHttpClient)
        .build()
    return retrofit.create(LocationService::class.java)
  }

  @Provides
  @Singleton
  @HeaderInterceptor
  fun provideHeaderInterceptor(deviceUtil: DeviceUtil): Interceptor {
    return Interceptor { chain ->
      val request = chain.request()
      val newRequest: Request
      val builder = request.newBuilder()
          .addHeader("x-api-key", deviceUtil.apiKey)
          .addHeader("Content-Type", "application/json")
          .addHeader("User-Agent", System.getProperty("http.agent"))
          .addHeader("Accept", "application/json")
          .addHeader("version", deviceUtil.versionCode.toString())
      newRequest = builder.build()
      chain.proceed(newRequest)
    }
  }
}
