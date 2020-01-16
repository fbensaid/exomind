package com.farouk.exomindproject.data.remoteApi


import android.content.Context
import com.farouk.exomindproject.data.dagger.ApplicationContext
import com.farouk.exomindproject.utils.global.AppUtils
import com.farouk.exomindproject.utils.global.Constants
import java.io.IOException

import okhttp3.Interceptor
import okhttp3.Response

class EndpointInterceptor(@param:ApplicationContext private val mContext: Context) :
    Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        var response: Response? = null

        val url = request.url().toString()
        if (url.contains(Constants.BASE_URL)) {
            if (AppUtils.isNetworkAvailable(mContext)) {
               /* if (mPreferences.isConnected()) {
                    request = request.newBuilder()
                        .method(request.method(), request.body())
                        .addHeader("Authorization", "Bearer " + mPreferences.getToken())
                        .build()
                }*/
            } else {
                throw IOException("No network available")
            }
        }
        response=chain.proceed(request)

        return response
    }

    companion object {

        private val TAG = EndpointInterceptor::class.java.simpleName
    }
}
