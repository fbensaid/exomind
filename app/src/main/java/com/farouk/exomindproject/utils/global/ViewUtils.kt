package com.farouk.exomindproject.utils.global

import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast

fun Context.toast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_LONG ).show()
}

fun ProgressBar.show(){
    visibility = View.VISIBLE
}

fun ProgressBar.hide(){
    visibility = View.GONE
}


 fun EditText.validateForm(): Boolean {
    var valid = true

    if (TextUtils.isEmpty(this.text)) {
        this.error = "Required."
        valid = false
    } else {
        this.error = null
    }
    return valid
}




