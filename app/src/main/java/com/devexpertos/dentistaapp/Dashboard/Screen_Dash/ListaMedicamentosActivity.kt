package com.devexpertos.dentistaapp.Dashboard.Screen_Dash

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.devexpertos.dentistaapp.Adapters.ListaMedicamentosAdapter
import com.devexpertos.dentistaapp.Adapters.ServiciosClinicosAdapter
import com.devexpertos.dentistaapp.Data.DataListaMedicamentos
import com.devexpertos.dentistaapp.Data.DataServiciosMedicos
import com.devexpertos.dentistaapp.R
import com.devexpertos.dentistaapp.Utils.MyToolbar
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_lista_medicamentos.*
import kotlinx.android.synthetic.main.activity_servicios_clinicos.*

class ListaMedicamentosActivity : AppCompatActivity() {

    private val lista_medicamentos =  ArrayList<DataListaMedicamentos>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_medicamentos)
        ColorsStatusBar()

        Get_Data_Lista_Medicamentos(lista_medicamentos)
    }

    @SuppressLint("RestrictedApi")
    private fun ColorsStatusBar(){

        MyToolbar().MostrarToolbar(this,getString(R.string.dash), true)

        val statusBar : Window = window
        statusBar.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        statusBar.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        statusBar.statusBarColor = ContextCompat.getColor(baseContext, R.color.background_resource)
    }

    private fun Get_Data_Lista_Medicamentos(lista_servicios:ArrayList<DataListaMedicamentos>){

        Firebase
            .firestore
            .collection("Lista_Medicamentos")
            .get()
            .addOnSuccessListener { result ->

                for (document in result){
//                    comprobar si recorre los datos y si los obtiene
                    Log.d("Objetos", document.toString())

//                    guardamos los datos en una variable
                    val lista = document.toObject(DataListaMedicamentos::class.java)

//                    agregamos los datos de la variable anterior en la variable de tipo arrayList
                    lista_servicios.add(lista)

                }

//                creando recyclerview para mostrar los datos de la base de datos
                recy_lista_medicamentos!!.layoutManager = LinearLayoutManager(this)
                val lista_adapter_medicamentos = ListaMedicamentosAdapter(lista_servicios)
                recy_lista_medicamentos.adapter = lista_adapter_medicamentos
                recy_lista_medicamentos.setHasFixedSize(true)


            }

    }
}