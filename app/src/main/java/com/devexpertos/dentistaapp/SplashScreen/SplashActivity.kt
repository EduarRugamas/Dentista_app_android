package com.devexpertos.dentistaapp.SplashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.airbnb.lottie.LottieAnimationView
import com.devexpertos.dentistaapp.Auth.LogIn
import com.devexpertos.dentistaapp.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        animation(splash_animation,R.raw.animacion_new)
        Handler().postDelayed({
            startActivity(Intent(this, LogIn::class.java))
            finish()
        },7000)


    }

    private fun animation(imageView:LottieAnimationView,animation:Int){
        imageView.setAnimation(animation)
        imageView.repeatCount = 2
        imageView.playAnimation()
    }
}