package com.mg.template.domain.response

import com.google.gson.annotations.SerializedName

class ProfileResponse {

  data class Cities(
      @SerializedName("Cities") val cities: Array<City>)

  data class City(
      @SerializedName("cityName") val cityName: String,
      @SerializedName("cityID") val cityID: Int
  )

  data class Districts(
      @SerializedName("Districts") val districts: Array<District>)

  data class District(
      @SerializedName("districtID") val districtID: Int,
      @SerializedName("districtName") val districtName: String,
      @SerializedName("cityID") val cityID: Int
  )

  data class Towns(
      @SerializedName("Towns") val towns: Array<Town>)

  data class Town(
      @SerializedName("districtID") val districtID: Int,
      @SerializedName("townName") val townName: String,
      @SerializedName("townID") val townID: Int
  )

}