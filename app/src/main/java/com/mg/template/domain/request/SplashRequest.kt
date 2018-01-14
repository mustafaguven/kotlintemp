package com.mg.template.domain.request

import com.google.gson.annotations.SerializedName

class SplashRequest {

  data class Init(
      @SerializedName("os") val os: String,
      @SerializedName("appVersion") val appVersion: String,
      @SerializedName("osVersion") val osVersion: String)
}