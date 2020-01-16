package com.farouk.exomindproject.utils.global


import android.content.Context
import com.farouk.exomindproject.data.model.user.UserResponse
import com.google.gson.Gson
import com.securepreferences.SecurePreferences

class SharedPreferences(context: Context) {

    var userResponse: UserResponse
        get() {
            val gson = Gson()
            val json = mSharedPreferences.getString(USER_FLAG, null)
            return gson.fromJson<UserResponse>(json, UserResponse::class.java!!)
        }
        set(user) {
            val editor = mSharedPreferences.edit()
            val gson = Gson()
            val json = gson.toJson(user)
            editor.putString(USER_FLAG, json)
            editor.apply()
        }


    var model: String?
        get() = mSharedPreferences.getString(MODEL_FLAG, null)
        set(model) {
            val editor = mSharedPreferences.edit()
            editor.putString(MODEL_FLAG, model)
            editor.commit()
        }


    init {
        mSharedPreferences = SecurePreferences(context, SECRET_KEY, FILE_NAME_FLAG)
    }




    fun clearSharedPreferences() {
        val editor = mSharedPreferences.edit()
        editor.clear()
        editor.commit()
    }



    companion object {

        private val USER_FLAG = "user_flag"
        private val MODEL_FLAG = "model_flag"


        private lateinit var mSharedPreferences: android.content.SharedPreferences

        private val FILE_NAME_FLAG = "bingo_file.xml"
        private val SECRET_KEY = "secret_bingo_key"

        operator fun set(key: String, value: String) {
            val editor = mSharedPreferences.edit()
            editor.putString(key, value)
            editor.commit()
        }
    }
}
