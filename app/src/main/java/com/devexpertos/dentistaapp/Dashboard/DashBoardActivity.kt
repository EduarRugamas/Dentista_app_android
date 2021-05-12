package com.devexpertos.dentistaapp.Dashboard

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager.LayoutParams.*
import androidx.core.content.ContextCompat
import com.devexpertos.dentistaapp.Auth.LogIn
import com.devexpertos.dentistaapp.Dashboard.Screen_Dash.*
import com.devexpertos.dentistaapp.R
import com.devexpertos.dentistaapp.Utils.MyToolbar
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

        Save_Session(email_user.toString())

        View_crear_cita.setOnClickListener {
            Nav_action(this, CrearCitaActivity::class.java)
        }
        View_control_cita.setOnClickListener {
            Nav_action(this, ControlCitasActivity::class.java)
        }
        View_servicios_clinicos.setOnClickListener {
            Nav_action(this, ServiciosClinicosActivity::class.java)
        }
        View_lista_medicos.setOnClickListener {
            Nav_action(this, ListaMedicosActivity::class.java)
        }
        View_lista_medicamentos.setOnClickListener {
            Nav_action(this, ListaMedicamentosActivity::class.java)
        }
        View_contactos.setOnClickListener {
            Nav_action(this, ContactosActivity::class.java)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.dash_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.cerrar_sesion){
            CerrarSession()
        }

        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("RestrictedApi")
    private fun ColorsStatusBar(){

        MyToolbar().MostrarToolbar(this,getString(R.string.dash), false)

        val statusBar : Window = window
        statusBar.clearFlags(FLAG_TRANSLUCENT_STATUS)
        statusBar.addFlags(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        statusBar.statusBarColor = ContextCompat.getColor(baseContext, R.color.background_resource)


    }

    private fun CerrarSession(){

        val alerta = SignOutAlert()

        val prefs = getSharedPreferences("KEY_PREFS", Context.MODE_PRIVATE).edit()
        prefs.clear()
        prefs.apply()

        val nav = Intent(this, LogIn::class.java).apply {
            alerta.Loading_Alert_SignOut(this@DashBoardActivity)
            FirebaseAuth.getInstance().signOut()
            finish()
        }
        startActivity(nav)
    }

    private fun Save_Session(email:String){
        //Guardado de datos
        val prefs = getSharedPreferences("KEY_PREFS", Context.MODE_PRIVATE).edit()
        prefs.putString("User_Email", email)
        prefs.apply()

    }

    private fun Nav_action(MyActivity:AppCompatActivity, SecondActivity: Class<*>? ) {
        startActivity(Intent(MyActivity, SecondActivity))
    }



}