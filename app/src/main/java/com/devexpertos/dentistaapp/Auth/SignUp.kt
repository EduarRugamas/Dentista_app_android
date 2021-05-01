package com.devexpertos.dentistaapp.Auth


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.devexpertos.dentistaapp.Dashboard.DashBoardActivity
import com.devexpertos.dentistaapp.R
import com.devexpertos.dentistaapp.Utils.CreateUserDialog
import com.devexpertos.dentistaapp.Utils.DialogValidationAlert
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        btn_crear_usuario.setOnClickListener {
            val email = getcorreo.text.toString()
            val contra = getcontra.text.toString()

            val alerta = DialogValidationAlert()

            if(email.isEmpty() && contra.isEmpty()){

                alerta.Loading_Alert_Validation(this)

            }else{
                CrearUsuario(email,contra)
            }

        }

        btn_iniciar_la_sesion.setOnClickListener {
            val nav = Intent(this, LogIn::class.java)
            startActivity(nav)
        }


    }


    private fun CrearUsuario(Correo:String, Password:String){
            FirebaseCreateUser(Correo,Password)
    }

    private fun FirebaseCreateUser(email:String, password:String){

        val loading = CreateUserDialog()

        FirebaseAuth
            .getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { result ->
                if (result.isSuccessful){

                    loading.Crear_Usuario_Aler_tDialog(this)

                    val nav = Intent(this, DashBoardActivity::class.java).apply {
                        finish()
                    }
                    startActivity(nav)

                }
            }
            .addOnFailureListener {
                Log.d("error_crear_usuario",it.message.toString())
            }
    }
}