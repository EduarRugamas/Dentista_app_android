package com.devexpertos.dentistaapp.Dashboard.Screen_Dash

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.devexpertos.dentistaapp.R
import com.devexpertos.dentistaapp.Utils.MyToolbar

class ContactosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactos)
        ColorsStatusBar()
    }

    @SuppressLint("RestrictedApi")
    private fun ColorsStatusBar(){

        MyToolbar().MostrarToolbar(this,"Contactos", true)

        val statusBar : Window = window
        statusBar.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        statusBar.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        statusBar.statusBarColor = ContextCompat.getColor(baseContext, R.color.background_resource)


    }
}