package com.devexpertos.dentistaapp.Auth


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.devexpertos.dentistaapp.Dashboard.DashBoardActivity
import com.devexpertos.dentistaapp.R
import com.devexpertos.dentistaapp.Utils.CreateUserDialog
import com.devexpertos.dentistaapp.Utils.DialogAlertCustom
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        btn_crear_usuario.setOnClickListener {
            val email = getcorreo.text.toString()
            val contra = getcontra.text.toString()
            val alerta = DialogAlertCustom()
            if(email.isEmpty() && contra.isEmpty()){
                alerta.LoadingDialog(this)
                alerta.StartLoadingDialog()
            }else{
                CrearUsuario(email,contra)
            }

        }
    }

    private fun CrearUsuario(Correo:String,Password:String){
        if (Correo.isNotEmpty() && Password.isNotEmpty()){
            FirebaseCreateUser(Correo,Password)
        }else{
            Toast.makeText(this, "Los Campos Son Requeridos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun FirebaseCreateUser(email:String,password:String){
        val loading = CreateUserDialog()
        FirebaseAuth
            .getInstance()
            .createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener { result ->
                if (result.isSuccessful){
                    loading.LoadingDialog(this)
                    loading.StartLoadingDialog()
                    startActivity(Intent(this,DashBoardActivity::class.java))
                }
            }
            .addOnFailureListener {
                Log.d("error_crear_usuario",it.message.toString())
            }
    }
}