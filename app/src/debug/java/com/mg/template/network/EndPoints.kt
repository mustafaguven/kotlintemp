package com.mg.template.network

import com.mg.template.BuildConfig

object EndPoints {
  val BASE_URL = "https://abc.com/test/${BuildConfig.API_VERSION}/"
  val USER_SERVICE_URL = "https://abc.com/test/${BuildConfig.API_VERSION}/user/"
  val LOCATION_SERVICE_URL = "https://abc.com/test/${BuildConfig.API_VERSION}/location/"
}