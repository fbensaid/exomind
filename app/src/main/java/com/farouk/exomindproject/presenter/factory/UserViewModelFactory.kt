package com.farouk.exomindproject.presenter.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.farouk.exomindproject.presenter.viewmodel.UsersViewModel

@Suppress("UNCHECKED_CAST")
class UserViewModelFactory : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UsersViewModel() as T
    }
}