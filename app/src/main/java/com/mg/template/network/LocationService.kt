package com.mg.template.network

import com.mg.template.domain.request.ProfileRequest
import com.mg.template.domain.response.BaseResponse
import com.mg.template.domain.response.ProfileResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LocationService {

  @GET("getcitylist")
  fun getCityList():
      Observable<BaseResponse<ProfileResponse.Cities>>

  @POST("getdistrictlist")
  fun getDistrictList(@Body body: ProfileRequest.District):
      Observable<BaseResponse<ProfileResponse.Districts>>

  @POST("gettownlist")
  fun getTownList(@Body body: ProfileRequest.Town):
      Observable<BaseResponse<ProfileResponse.Towns>>
}
