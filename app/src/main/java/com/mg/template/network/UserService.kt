package com.mg.template.network

import com.mg.template.domain.request.GsmRequest
import com.mg.template.domain.request.NewMemberRequest
import com.mg.template.domain.response.BaseResponse
import com.mg.template.domain.response.GsmResponse
import com.mg.template.domain.response.NewMemberResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

  @POST("validatephone")
  fun validatePhoneNumber(@Body body: GsmRequest.ValidatePhoneNumber):
      Observable<BaseResponse<GsmResponse.ValidatePhoneNumber>>

  @POST("register")
  fun register(@Body body: NewMemberRequest.Register):
      Observable<BaseResponse<NewMemberResponse.Register>>
}
