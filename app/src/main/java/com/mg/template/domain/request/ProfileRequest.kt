package com.mg.template.domain.request

import com.google.gson.annotations.SerializedName

class ProfileRequest {

  data class District(
      @SerializedName("cityID") val cityID: Int
  )

  data class Town(
      @SerializedName("districtID") val districtID: Int
  )
}