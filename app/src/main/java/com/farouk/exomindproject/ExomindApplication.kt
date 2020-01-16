/*
 * Copyright (c) 2019 - Crédit Agricole Payments & Services - All rights reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * This file can not be copied and/or distributed without the express permission of Crédit Agricole Payments & Services
 */

package com.farouk.exomindproject

import android.app.Application
import android.content.Context
import com.farouk.exomindproject.data.dagger.AppComponent
import com.farouk.exomindproject.data.dagger.AppModule
import com.farouk.exomindproject.data.dagger.DaggerAppComponent
import com.farouk.exomindproject.data.dagger.PreferencesModule

class ExomindApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var instance: Context
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initDI()
    }

    fun getAppContext(): Context {
        return instance
    }

    private fun initDI() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .preferencesModule(PreferencesModule(this))
            .build()
    }
}


