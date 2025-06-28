package com.example.shopify.ui.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.shopify.databinding.ActivityOnBoardingBinding
import com.example.shopify.ui.home.HomeMainActivity
import com.example.shopify.ui.login.LoginActivity
import com.example.shopify.utils.PreferenceHelper

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonGetStarted.setOnClickListener {
           startActivity(Intent(this, LoginActivity::class.java))
            PreferenceHelper.setOnBoardShow(this,true)
        }
    }
}