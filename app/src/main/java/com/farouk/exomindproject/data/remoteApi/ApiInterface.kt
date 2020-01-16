package com.farouk.exomindproject.data.remoteApi

import com.farouk.exomindproject.data.model.user.UserResponse
import com.farouk.exomindproject.utils.global.Constants
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET(Constants.EndPoints.USER_ENDPOINT)
    fun getUsersList(): Deferred<Response<List<UserResponse>>>



}