package com.farouk.exomindproject.presenter.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.farouk.exomindproject.ExomindApplication
import com.farouk.exomindproject.R
import com.farouk.exomindproject.presenter.ui.fragment.UsersFragment

class MainActivity : AppCompatActivity() {
    private var usersFragment= UsersFragment()
    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ExomindApplication.appComponent.inject(this)
        ExomindApplication.instance=this

        replaceMainLayout(usersFragment)

    }

    private fun replaceMainLayout(fragment: Fragment) {
        fragmentManager.beginTransaction()
            .replace(R.id.layoutSlidingHome, fragment)
            .addToBackStack(null)
            .commit()

    }
}
