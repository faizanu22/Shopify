package com.example.shopify.utils

import android.content.Context
import android.os.Message
import android.widget.Toast

object CustomDialog {
    fun showToast(context: Context, message: String){
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
    }
}