package com.example.gourmetberlin.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.LinearLayout
import android.util.Log
import com.example.gourmetberlin.R

class Profile @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.profile, this)

        val loginButton: Button = findViewById(R.id.login_button)
        val registerButton: Button = findViewById(R.id.register_button)

        loginButton.setOnClickListener {
            // Handle login button click
            Log.d("Profile", "Login button clicked")
            // You can also start a new activity or do other actions here
        }

        registerButton.setOnClickListener {
            // Handle register button click
            Log.d("Profile", "Register button clicked")
            // You can also start a new activity or do other actions here
        }
    }
}
