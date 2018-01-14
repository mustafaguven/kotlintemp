package com.mg.template.domain.request

import com.google.gson.annotations.SerializedName

class NewMemberRequest {

  companion object {
    val CHANNEL: Int = 2
  }

  data class Register(
      @SerializedName("name") val name: String,
      @SerializedName("surname") val surname: String,
      @SerializedName("phoneNumber") val phoneNumber: String,
      @SerializedName("channel") val channel: Int = CHANNEL,
      @SerializedName("hybrisCustCode") val hybrisCustCode: String = "",
      @SerializedName("address") val address: Address,
      @SerializedName("permissions") val permissions: Permissions,
      @SerializedName("additional") val additional: Additional
  )

  data class Address(
      @SerializedName("birthDate") val birthDate: String,
      @SerializedName("gender") val gender: Int,
      @SerializedName("addressLine") val addressLine: String = "",
      @SerializedName("zipCode") val zipCode: String = "",
      @SerializedName("province") val province: String = "",
      @SerializedName("district") val district: String = "",
      @SerializedName("city") val city: String = "",
      @SerializedName("email") val email: String = "",
      @SerializedName("modifyUser") val modifyUser: String = "",
      @SerializedName("modifyTim") val modifyTim: String = ""
  )

  data class Permissions(
      @SerializedName("smsPermission") val smsPermission: Int,
      @SerializedName("mailPermission") val mailPermission: Int
  )

  data class Additional(
      @SerializedName("profileImageURL") val profileImageURL: String = "",
      @SerializedName("createDate") val createDate: String = "",
      @SerializedName("updateDate") val updateDate: String = "",
      @SerializedName("phoneModel") val phoneModel: String = "",
      @SerializedName("phoneBrand") val phoneBrand: String = "",
      @SerializedName("appVersion") val appVersion: String = "",
      @SerializedName("deviceID") val deviceID: String = "",
      @SerializedName("os") val os: String = "",
      @SerializedName("relation") val relation: String = "",
      @SerializedName("inhabitCity") val inhabitCity: String = "",
      @SerializedName("inhabitPlace") val inhabitPlace: String = "",
      @SerializedName("job") val job: String = "",
      @SerializedName("school") val school: String = "",
      @SerializedName("twitterFollowerCount") val twitterFollowerCount: String = "",
      @SerializedName("tweetCount") val tweetCount: String = "",
      @SerializedName("contractVersion") val contractVersion: String = "",
      @SerializedName("userIP") val userIP: String = "",
      @SerializedName("bluetoothAddress") val bluetoothAddress: String = "",
      @SerializedName("wifiAddress") val wifiAddress: String = ""
  )

}