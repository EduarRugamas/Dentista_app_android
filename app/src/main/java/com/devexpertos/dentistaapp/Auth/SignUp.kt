package com.devexpertos.dentistaapp.Auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.devexpertos.dentistaapp.R

class SignUp : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        button = findViewById(R.id.btnSignUp)
        button.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)

        }
    }
}