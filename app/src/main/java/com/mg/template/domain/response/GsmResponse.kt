package com.mg.template.domain.response

import com.google.gson.annotations.SerializedName

class GsmResponse {

  data class ValidatePhoneNumber(
      @SerializedName("cardNumber") val cardNumber: String?,
      @SerializedName("smsCode") val smsCode: Int,
      @SerializedName("reason") val reason: String)
}

