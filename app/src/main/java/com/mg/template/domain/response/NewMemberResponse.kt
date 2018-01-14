package com.mg.template.domain.response

import com.google.gson.annotations.SerializedName

class NewMemberResponse {

  data class Register(
      @SerializedName("cardNumber") val cardNumber: String
  )
}

