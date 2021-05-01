package com.devexpertos.dentistaapp.Auth

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.devexpertos.dentistaapp.Dashboard.DashBoardActivity
import com.devexpertos.dentistaapp.R
import com.devexpertos.dentistaapp.Utils.DialogValidationAlert
import com.devexpertos.dentistaapp.Utils.LogInAlert
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LogIn : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        session()

        Btn_iniciar_sesion.setOnClickListener {

            val correo = Getcorreo.text.toString()
            val contra = Getcontra.text.toString()

            val alerta = DialogValidationAlert()

            if(correo.isEmpty() && contra.isEmpty()){

                alerta.Loading_Alert_Validation(this)

            }else{
                IniciarSesion(correo,contra)
            }

        }
            Btn_crear_usuario.setOnClickListener {
                CrearUsuario()
            }
    }

    private fun session(){
        val prefs = getSharedPreferences("KEY_PREFS", Context.MODE_PRIVATE)
        val email = prefs.getString("User_Email", null)

        if (email != null){
            val nav = Intent(this, DashBoardActivity::class.java)
            startActivity(nav)
        }
    }

    private fun IniciarSesion(email:String, password:String){

        val logIn = LogInAlert()

          FirebaseAuth
              .getInstance()
              .signInWithEmailAndPassword(email,password)
              .addOnCompleteListener { completado ->
                  if (completado.isSuccessful){

                      logIn.Loading_Alert_LogIn(this)

                      ShowDashboard(email)
                  }else{
                      Toast.makeText(this, "Usuario o Contraseña incorrectos intentelo nuevamente", Toast.LENGTH_SHORT).show()
                  }
              }
              .addOnFailureListener {
                  Log.d("Erro_Inicio_sesion",it.message.toString())
              }


    }

    private fun ShowDashboard(userEmail:String){
       val nav = Intent(this, DashBoardActivity::class.java).apply {
            putExtra("Correo_electronico", userEmail)
           finish()
       }
        startActivity(nav)
    }

    private fun CrearUsuario(){
        startActivity(Intent(this, SignUp::class.java))
    }
}
