package com.farouk.exomind.data.remoteApi


import com.farouk.exomindproject.ExomindApplication
import com.farouk.exomindproject.data.remoteApi.ApiInterface
import com.farouk.exomindproject.data.remoteApi.EndpointInterceptor
import com.farouk.exomindproject.utils.global.Constants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Apifactory{

    //OkhttpClient for building http request url
    private val tmdbClient = OkHttpClient().newBuilder()
        .addInterceptor(EndpointInterceptor(ExomindApplication.instance))
        .build()

    fun retrofit() : Retrofit = Retrofit.Builder()
        .client(tmdbClient)
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val Api : ApiInterface = retrofit().create(ApiInterface::class.java)

}
