package com.devexpertos.dentistaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignUp : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        button = findViewById(R.id.btnSignUp)
        button.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)

        }
    }
}