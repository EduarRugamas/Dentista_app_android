package com.devexpertos.dentistaapp.Auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.devexpertos.dentistaapp.Dashboard.DashBoardActivity
import com.devexpertos.dentistaapp.R
import com.devexpertos.dentistaapp.Utils.DialogAlertCustom
import com.devexpertos.dentistaapp.Utils.LogInDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class LogIn : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        Btn_iniciar_sesion.setOnClickListener {

            val correo = Getcorreo.text.toString()
            val contra = Getcontra.text.toString()

            val alerta = DialogAlertCustom()

            if(correo.isEmpty() && contra.isEmpty()){

                alerta.LoadingDialog(this)
                alerta.StartLoadingDialog()

            }else{
                IniciarSesion(correo,contra)
            }

        }


            Btn_crear_usuario.setOnClickListener {
                CrearUsuario()
            }
    }

    private fun IniciarSesion(email:String, password:String){

        val logIn = LogInDialog()

          FirebaseAuth
              .getInstance()
              .signInWithEmailAndPassword(email,password)
              .addOnCompleteListener { completado ->
                  if (completado.isSuccessful){
                      logIn.LoadingDialog(this)
                      logIn.StartLoadingDialog()
                      ShowDashboard()
                  }else{
                      Toast.makeText(this, "Usuario o Contraseña incorrectos intentelo nuevamente", Toast.LENGTH_SHORT).show()
                  }
              }
              .addOnFailureListener {
                  Log.d("Erro_Inicio_sesion",it.message.toString())
              }


    }

    private fun ShowDashboard(){
       val nav = Intent(this, DashBoardActivity::class.java).apply {
           finish()
       }
        startActivity(nav)
    }

    private fun CrearUsuario(){
        startActivity(Intent(this, SignUp::class.java))

    }
}
