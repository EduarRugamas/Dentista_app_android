package com.devexpertos.dentistaapp.Dashboard.Screen_Dash

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.devexpertos.dentistaapp.Adapters.ServiciosClinicosAdapter
import com.devexpertos.dentistaapp.Data.DataServiciosMedicos
import com.devexpertos.dentistaapp.R
import com.devexpertos.dentistaapp.Utils.MyToolbar
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_servicios_clinicos.*

class ServiciosClinicosActivity : AppCompatActivity() {

    val Lista_Serivicios_medicos = ArrayList<DataServiciosMedicos>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicios_clinicos)
        ColorsStatusBar()

        Get_Data_Servicios_Medicos(Lista_Serivicios_medicos)
    }

    @SuppressLint("RestrictedApi")
    private fun ColorsStatusBar(){

        MyToolbar().MostrarToolbar(this,getString(R.string.servicios_de_la_clinica), true)

        val statusBar : Window = window
        statusBar.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        statusBar.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        statusBar.statusBarColor = ContextCompat.getColor(baseContext, R.color.background_resource)
    }

    private fun Get_Data_Servicios_Medicos(lista_servicios:ArrayList<DataServiciosMedicos>){

        Firebase
            .firestore
            .collection("Lista_Servicios_Medicos")
            .get()
            .addOnSuccessListener { result ->

                for (document in result){
//                    comprobar si recorre los datos y si los obtiene
                    Log.d("Objetos", document.toString())

//                    guardamos los datos en una variable
                    val lista = document.toObject(DataServiciosMedicos::class.java)

//                    agregamos los datos de la variable anterior en la variable de tipo arrayList
                    lista_servicios.add(lista)

                }

//                creando recyclerview para mostrar los datos de la base de datos
                recy_servicios_clinicos!!.layoutManager = LinearLayoutManager(this)
                val lista_adapter_servicios_clinicos = ServiciosClinicosAdapter(lista_servicios)
                recy_servicios_clinicos.adapter = lista_adapter_servicios_clinicos
                recy_servicios_clinicos.setHasFixedSize(true)


            }

    }
}