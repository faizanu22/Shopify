package com.example.shopify.ui.base

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.shopify.R
import com.example.shopify.ui.home.HomeMainActivity
import com.example.shopify.ui.login.LoginActivity
import com.example.shopify.utils.PreferenceHelper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            if (PreferenceHelper.isUserLoggedIn(this)) {
                startActivity(Intent(this, HomeMainActivity::class.java))
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish() // Closes splash activity so user can't return to it
        }, 2000)
    }
}