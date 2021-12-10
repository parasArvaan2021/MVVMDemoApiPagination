package com.app.mvvmdemowithapi.service

import com.app.mvvmdemowithapi.respone.main.PaginationResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitService {


    @GET("user-discussion-pagination")
    suspend fun getPaginationData(
        @Header("Authorization") inToken: String,
        @Query("page") page:String
    ): Response<PaginationResponse>


    companion object {
        var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService {
            if (retrofitService == null) {
                val builder = Retrofit.Builder()
                    .baseUrl("http://3.128.24.219/embie_testing/public/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = builder.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}