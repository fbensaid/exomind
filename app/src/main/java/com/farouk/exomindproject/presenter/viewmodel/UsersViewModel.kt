package com.farouk.exomindproject.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.farouk.exomind.data.remoteApi.Apifactory
import com.farouk.exomindproject.data.model.user.UserResponse
import com.farouk.exomindproject.data.repository.UserRepository
import com.mtp.laboproject.global.DebugLog
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class UsersViewModel : ViewModel() {
    //create a new Job
    private val parentJob = Job()
    //create a coroutine context with the job and the dispatcher
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Default
    //create a coroutine scope with the coroutine context
    private val scope = CoroutineScope(coroutineContext)

    private val handler = CoroutineExceptionHandler { _, exception ->
        DebugLog.e("Couroutine", "Caught $exception")
    }
    //initialize news repo
    private val usersRepository: UserRepository = UserRepository(Apifactory.Api)
    //live data that will be populated as news updates
    val userLiveData = MutableLiveData<MutableList<UserResponse>>()

    fun getUsers() {
        ///launch the coroutine scope
        scope.launch(handler) {
            //get latest users from users repo
            val users = usersRepository.getUsers()
            //post the value inside live data
            userLiveData.postValue(users)
        }
    }


    fun cancelRequests() = coroutineContext.cancel()


    override fun onCleared() {
        super.onCleared()
        this.parentJob.cancel()
    }
}