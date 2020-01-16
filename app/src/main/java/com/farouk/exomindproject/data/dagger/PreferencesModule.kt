package com.farouk.exomindproject.data.dagger

import android.app.Application
import android.content.Context
import com.farouk.exomindproject.utils.global.SharedPreferences
import dagger.Provides
import dagger.Module
import javax.inject.Singleton


@Module
class PreferencesModule(mApplication: Application) {
    private val mContext: Context = mApplication.applicationContext

    @Singleton
    @Provides
    fun sharedPreferences(): SharedPreferences {
        return SharedPreferences(mContext)
    }
}