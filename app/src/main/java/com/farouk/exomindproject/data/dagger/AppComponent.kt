package com.farouk.exomindproject.data.dagger


import android.app.Application
import com.farouk.exomindproject.ExomindApplication
import com.farouk.exomindproject.data.repository.BaseRepository
import com.farouk.exomindproject.presenter.ui.activity.MainActivity
import com.farouk.exomindproject.utils.global.SharedPreferences
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, PreferencesModule::class])
interface AppComponent {


    fun inject(baseRepository: BaseRepository)
    fun inject(appComponent: ExomindApplication)
    fun inject(mainActivity: MainActivity)
    //fun userRepository(): UserRepository
    fun application(): Application
    fun getPreferences(): SharedPreferences

}