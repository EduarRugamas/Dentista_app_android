package com.devexpertos.dentistaapp.Dashboard

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager.LayoutParams.*
import androidx.core.content.ContextCompat
import com.devexpertos.dentistaapp.Auth.LogIn
import com.devexpertos.dentistaapp.R
import com.devexpertos.dentistaapp.Utils.SignOutAlert
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashBoardActivity : AppCompatActivity() {
    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        ColorsStatusBar()

        val email_user = FirebaseAuth.getInstance().currentUser?.email


        text_email_user.text = email_user

        //Guardado de datos
        val prefs = getSharedPreferences("KEY_PREFS", Context.MODE_PRIVATE).edit()
        prefs.putString("User_Email", email_user)
        prefs.apply()


        btn_cerrar_sesion.setOnClickListener {
            CerrarSession()
        }

    }

    private fun ColorsStatusBar(){
        val statusBar : Window = window
        statusBar.clearFlags(FLAG_TRANSLUCENT_STATUS)
        statusBar.addFlags(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        statusBar.statusBarColor = ContextCompat.getColor(baseContext, R.color.background_resource)


    }

    private fun CerrarSession(){

        val signout = SignOutAlert()

        val prefs = getSharedPreferences("KEY_PREFS", Context.MODE_PRIVATE).edit()
        prefs.clear()
        prefs.apply()

        val nav = Intent(this, LogIn::class.java).apply {
            signout.Loading_Alert_SignOut(this@DashBoardActivity)
            FirebaseAuth.getInstance().signOut()
            finish()
        }
        startActivity(nav)
    }


}