package com.mg.template.domain.response

import com.google.gson.annotations.SerializedName

class SplashResponse {

  data class Init(
      @SerializedName("isUpdateExist") val isUpdateExist: Boolean,
      @SerializedName("isForceUpdate") val isForceUpdate: Boolean,
      @SerializedName("updateLink") val updateLink: String,
      @SerializedName("message") val message: String,
      @SerializedName("userAgreementLink") val userAgreementLink: String,
      @SerializedName("commercialLink") val commercialLink: String)
}

