package com.farouk.exomindproject.utils.global


class Constants {


    companion object {

        const val BASE_URL: String = "http://jsonplaceholder.typicode.com/"

    }

    object Requests {
        val REQUEST_USER_CONNECTED = 0x99
        val DRAW_REQUEST = 0X11
        val PLAY_SERVICES_RESOLUTION_REQUEST = 121
        val REQUEST_CHECK_GOOGLE_SETTINGS = 321
        val REQUEST_CAMERA_SETTINGS = 3251
        val REQUEST_CALL_SETTINGS = 31
        val MY_PERMISSIONS_REQUEST_LOCATION = 99


    }


    object EndPoints {
        const val USER_ENDPOINT  = "users"
        const val ALBUM_ENDPOINT  = "users/1/albums?userId={userID}"
    }


}
