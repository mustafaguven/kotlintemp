package com.mg.template.network

import com.mg.template.domain.request.SplashRequest
import com.mg.template.domain.response.BaseResponse
import com.mg.template.domain.response.SplashResponse
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Streaming
import retrofit2.http.Url

interface InitService {

  @POST("init")
  fun init(@Body body: SplashRequest.Init): Observable<BaseResponse<SplashResponse.Init>>

  @Streaming
  @GET
  fun downloadCommercialLink(@Url url: String): Observable<Response<ResponseBody>>


}
