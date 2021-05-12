package com.devexpertos.dentistaapp.Dashboard.Screen_Dash

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.devexpertos.dentistaapp.Adapters.ListaMedicosAdapter
import com.devexpertos.dentistaapp.Adapters.ServiciosClinicosAdapter
import com.devexpertos.dentistaapp.Data.DataListaMedicos
import com.devexpertos.dentistaapp.Data.DataServiciosMedicos
import com.devexpertos.dentistaapp.R
import com.devexpertos.dentistaapp.Utils.MyToolbar
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_lista_medicos.*
import kotlinx.android.synthetic.main.activity_servicios_clinicos.*

class ListaMedicosActivity : AppCompatActivity() {

    private val Lista_Medicos = ArrayList<DataListaMedicos>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_medicos)
        ColorsStatusBar()

        Get_Data_Lista_Medicos(Lista_Medicos)

    }
    @SuppressLint("RestrictedApi")
    private fun ColorsStatusBar(){

        MyToolbar().MostrarToolbar(this,"Medicos", true)

        val statusBar : Window = window
        statusBar.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        statusBar.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        statusBar.statusBarColor = ContextCompat.getColor(baseContext, R.color.background_resource)
    }

    private fun Get_Data_Lista_Medicos(lista_servicios:ArrayList<DataListaMedicos>){

        Firebase
            .firestore
            .collection("Lista_Medicos")
            .get()
            .addOnSuccessListener { result ->

                for (document in result){
//                    comprobar si recorre los datos y si los obtiene
                    Log.d("Objetos", document.toString())

//                    guardamos los datos en una variable
                    val lista = document.toObject(DataListaMedicos::class.java)

//                    agregamos los datos de la variable anterior en la variable de tipo arrayList
                    lista_servicios.add(lista)

                }

//                creando recyclerview para mostrar los datos de la base de datos
                recy_lista_medicos!!.layoutManager = LinearLayoutManager(this)
                val lista_adapter_medicos = ListaMedicosAdapter(lista_servicios)
                recy_lista_medicos.adapter = lista_adapter_medicos
               recy_lista_medicos.setHasFixedSize(true)


            }

    }

}