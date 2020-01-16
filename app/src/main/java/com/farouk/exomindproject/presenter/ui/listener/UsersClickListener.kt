package com.farouk.exomindproject.presenter.ui.listener

import android.view.View
import com.farouk.exomindproject.data.model.user.UserResponse


interface UsersClickListener {
    fun onRecyclerViewItemClick(view: View, labo: UserResponse)
}
