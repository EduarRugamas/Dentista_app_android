package com.devexpertos.dentistaapp.Dashboard.Screen_Dash

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isInvisible
import com.devexpertos.dentistaapp.R
import com.devexpertos.dentistaapp.Utils.MyToolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_crear_cita.*

class CrearCitaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cita)
        ColorsStatusBar()

//        lista de elemtos del spinner
        val lista = resources.getStringArray(R.array.opciones_servicios)
//        adaptador del spinner
        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item, lista)
        spinner_opciones_servicios.adapter = adaptador
//        para las opciones seleccionada

        spinner_opciones_servicios.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {


            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                ninguna opcion seleccionada
                if (position == 0){
                    linearlayout_crear_cita.visibility = View.INVISIBLE
                    Btn_formulario.setOnClickListener {
                        Toast.makeText(this@CrearCitaActivity, "Seleccione una opcion valida", Toast.LENGTH_SHORT).show()

                    }
//                    frenos
                }else if (position == 1){
                    nombre_procedimiento.text = lista[position].toString()
                   Btn_formulario.setOnClickListener {

                       linearlayout_crear_cita.visibility = View.VISIBLE

                       val lista_semana = resources.getStringArray(R.array.opciones_dias)
                       val adapter_semana = ArrayAdapter(this@CrearCitaActivity,android.R.layout.simple_spinner_item, lista_semana)
                       spinner_dias_semana.adapter = adapter_semana
                       spinner_dias_semana.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                           override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                               no selecciona dia
                               if (position == 0){
                                   hora_procedimiento.text = getString(R.string.sin_horario)

                                   Toast.makeText(this@CrearCitaActivity, "Seleccione un dia de la semana", Toast.LENGTH_SHORT).show()
                                   btn_agendar_la_cita.setOnClickListener {
                                       Toast.makeText(this@CrearCitaActivity, "Seleccine un dia de la semana", Toast.LENGTH_SHORT).show()
                                   }
                               }
//                              Lunes
                               else if (position == 1 ){
                                   hora_procedimiento.text = getString(R.string.hora_frenos)
                                   btn_agendar_la_cita.setOnClickListener {
                                       val nombre_apellido = GetNombre_Apellido.text.toString()
                                       val hora_frenos:String = getString(R.string.hora_frenos)
                                       val dia_semana = lista_semana[position].toString()
                                       GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                       linearlayout_crear_cita.visibility = View.INVISIBLE
                                   }


                               }
//                               Martes
                               else if (position == 2 ){
                                  hora_procedimiento.text = getString(R.string.hora_frenos)

                                   btn_agendar_la_cita.setOnClickListener {
                                       val nombre_apellido = GetNombre_Apellido.text.toString()
                                       val hora_frenos:String = getString(R.string.hora_frenos)
                                       val dia_semana = lista_semana[position].toString()
                                       GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                       linearlayout_crear_cita.visibility = View.INVISIBLE
                                   }

                               }
//                               miercoles
                               else if (position == 3 ){
                                   hora_procedimiento.text = getString(R.string.hora_frenos)

                                   btn_agendar_la_cita.setOnClickListener {
                                       val nombre_apellido = GetNombre_Apellido.text.toString()
                                       val hora_frenos:String = getString(R.string.hora_frenos)
                                       val dia_semana = lista_semana[position].toString()
                                       GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                       linearlayout_crear_cita.visibility = View.INVISIBLE
                                   }

                               }
//                               jueves
                               else if (position == 4 ){
                                   hora_procedimiento.text = getString(R.string.hora_frenos)

                                   btn_agendar_la_cita.setOnClickListener {
                                       val nombre_apellido = GetNombre_Apellido.text.toString()
                                       val hora_frenos:String = getString(R.string.hora_frenos)
                                       val dia_semana = lista_semana[position].toString()
                                       GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                       linearlayout_crear_cita.visibility = View.INVISIBLE
                                   }

                               }
//                               viernes
                               else if (position == 5 ){
                                   hora_procedimiento.text = getString(R.string.hora_frenos)

                                   btn_agendar_la_cita.setOnClickListener {
                                       val nombre_apellido = GetNombre_Apellido.text.toString()
                                       val hora_frenos:String = getString(R.string.hora_frenos)
                                       val dia_semana = lista_semana[position].toString()
                                       GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                       linearlayout_crear_cita.visibility = View.INVISIBLE
                                   }

                               }
                           }
                           override fun onNothingSelected(parent: AdapterView<*>?) {
                               TODO("Not yet implemented")
                           }
                       }

                   }
//                    coronas
                }else if (position == 2){
                  nombre_procedimiento.text = lista[position].toString()
                   Btn_formulario.setOnClickListener {

                       linearlayout_crear_cita.visibility = View.VISIBLE



                       val lista_semana = resources.getStringArray(R.array.opciones_dias)
                       val adapter_semana = ArrayAdapter(this@CrearCitaActivity,android.R.layout.simple_spinner_item, lista_semana)
                       spinner_dias_semana.adapter = adapter_semana
                       spinner_dias_semana.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                           override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                               no selecciona dia
                               if (position == 0){
                                   hora_procedimiento.text = getString(R.string.sin_horario)

                                   Toast.makeText(this@CrearCitaActivity, "Seleccione un dia de la semana", Toast.LENGTH_SHORT).show()
                               }
//                              Lunes
                               else if (position == 1 ){
                                   hora_procedimiento.text = getString(R.string.hora_coronas)
                                   btn_agendar_la_cita.setOnClickListener {
                                       val nombre_apellido = GetNombre_Apellido.text.toString()
                                       val hora_frenos:String = getString(R.string.hora_coronas)
                                       val dia_semana = lista_semana[position].toString()
                                       GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                       linearlayout_crear_cita.visibility = View.INVISIBLE
                                   }

                               }
//                               Martes
                               else if (position == 2 ){
                                   hora_procedimiento.text = getString(R.string.hora_coronas)
                                   btn_agendar_la_cita.setOnClickListener {
                                       val nombre_apellido = GetNombre_Apellido.text.toString()
                                       val hora_frenos:String = getString(R.string.hora_coronas)
                                       val dia_semana = lista_semana[position].toString()
                                       GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                       linearlayout_crear_cita.visibility = View.INVISIBLE
                                   }

                               }
//                               miercoles
                               else if (position == 3 ){
                                   hora_procedimiento.text = getString(R.string.hora_coronas)
                                   btn_agendar_la_cita.setOnClickListener {
                                       val nombre_apellido = GetNombre_Apellido.text.toString()
                                       val hora_frenos:String = getString(R.string.hora_coronas)
                                       val dia_semana = lista_semana[position].toString()
                                       GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                       linearlayout_crear_cita.visibility = View.INVISIBLE
                                   }

                               }
//                               jueves
                               else if (position == 4 ){
                                   hora_procedimiento.text = getString(R.string.hora_coronas)
                                   btn_agendar_la_cita.setOnClickListener {
                                       val nombre_apellido = GetNombre_Apellido.text.toString()
                                       val hora_frenos:String = getString(R.string.hora_coronas)
                                       val dia_semana = lista_semana[position].toString()
                                       GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                       linearlayout_crear_cita.visibility = View.INVISIBLE
                                   }

                               }
//                               viernes
                               else if (position == 5 ){
                                   hora_procedimiento.text = getString(R.string.hora_coronas)
                                   btn_agendar_la_cita.setOnClickListener {
                                       val nombre_apellido = GetNombre_Apellido.text.toString()
                                       val hora_frenos:String = getString(R.string.hora_coronas)
                                       val dia_semana = lista_semana[position].toString()
                                       GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                       linearlayout_crear_cita.visibility = View.INVISIBLE
                                   }

                               }
                           }
                           override fun onNothingSelected(parent: AdapterView<*>?) {
                               TODO("Not yet implemented")
                           }
                       }
                    }
                }
//                rellernos
                else if (position == 3){
                    nombre_procedimiento.text = lista[position].toString()
                    Btn_formulario.setOnClickListener {

                        linearlayout_crear_cita.visibility = View.VISIBLE



                        val lista_semana = resources.getStringArray(R.array.opciones_dias)
                        val adapter_semana = ArrayAdapter(this@CrearCitaActivity,android.R.layout.simple_spinner_item, lista_semana)
                        spinner_dias_semana.adapter = adapter_semana
                        spinner_dias_semana.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                               no selecciona dia
                                if (position == 0){
                                    hora_procedimiento.text = getString(R.string.sin_horario)

                                    Toast.makeText(this@CrearCitaActivity, "Seleccione un dia de la semana", Toast.LENGTH_SHORT).show()
                                }
//                              Lunes
                                else if (position == 1 ){
                                    hora_procedimiento.text = getString(R.string.hora_relleno)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_relleno)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               Martes
                                else if (position == 2 ){
                                    hora_procedimiento.text = getString(R.string.hora_relleno)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_relleno)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               miercoles
                                else if (position == 3 ){
                                    hora_procedimiento.text = getString(R.string.hora_relleno)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_relleno)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               jueves
                                else if (position == 4 ){
                                    hora_procedimiento.text = getString(R.string.hora_relleno)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_relleno)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               viernes
                                else if (position == 5 ){
                                    hora_procedimiento.text = getString(R.string.hora_relleno)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_relleno)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
                            }
                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                TODO("Not yet implemented")
                            }
                        }
                    }
                }
//                extracciones
                else if (position == 4){
                    nombre_procedimiento.text = lista[position].toString()
                    Btn_formulario.setOnClickListener {

                        linearlayout_crear_cita.visibility = View.VISIBLE



                        val lista_semana = resources.getStringArray(R.array.opciones_dias)
                        val adapter_semana = ArrayAdapter(this@CrearCitaActivity,android.R.layout.simple_spinner_item, lista_semana)
                        spinner_dias_semana.adapter = adapter_semana
                        spinner_dias_semana.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                               no selecciona dia
                                if (position == 0){
                                    hora_procedimiento.text = getString(R.string.sin_horario)

                                    Toast.makeText(this@CrearCitaActivity, "Seleccione un dia de la semana", Toast.LENGTH_SHORT).show()
                                }
//                              Lunes
                                else if (position == 1 ){
                                    hora_procedimiento.text = getString(R.string.hora_extraciones)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_extraciones)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               Martes
                                else if (position == 2 ){
                                    hora_procedimiento.text = getString(R.string.hora_extraciones)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_extraciones)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               miercoles
                                else if (position == 3 ){
                                    hora_procedimiento.text = getString(R.string.hora_extraciones)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_extraciones)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               jueves
                                else if (position == 4 ){
                                    hora_procedimiento.text = getString(R.string.hora_extraciones)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_extraciones)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               viernes
                                else if (position == 5 ){
                                    hora_procedimiento.text = getString(R.string.hora_extraciones)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_extraciones)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
                            }
                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                TODO("Not yet implemented")
                            }
                        }
                    }
                }
//                protesis
                else if (position == 5){
                    nombre_procedimiento.text = lista[position].toString()
                    Btn_formulario.setOnClickListener {

                        linearlayout_crear_cita.visibility = View.VISIBLE

                        var dato_semana:String = ""

                        val lista_semana = resources.getStringArray(R.array.opciones_dias)
                        val adapter_semana = ArrayAdapter(this@CrearCitaActivity,android.R.layout.simple_spinner_item, lista_semana)
                        spinner_dias_semana.adapter = adapter_semana
                        spinner_dias_semana.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                               no selecciona dia
                                if (position == 0){
                                    hora_procedimiento.text = getString(R.string.sin_horario)
                                    Log.d("semana", dato_semana)
                                    Toast.makeText(this@CrearCitaActivity, "Seleccione un dia de la semana", Toast.LENGTH_SHORT).show()
                                }
//                              Lunes
                                else if (position == 1 ){
                                    hora_procedimiento.text = getString(R.string.hora_protesis)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_protesis)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               Martes
                                else if (position == 2 ){
                                    hora_procedimiento.text = getString(R.string.hora_protesis)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_protesis)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               miercoles
                                else if (position == 3 ){
                                    hora_procedimiento.text = getString(R.string.hora_protesis)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_protesis)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               jueves
                                else if (position == 4 ){
                                    hora_procedimiento.text = getString(R.string.hora_protesis)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_protesis)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               viernes
                                else if (position == 5 ){
                                    hora_procedimiento.text = getString(R.string.hora_protesis)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_protesis)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
                            }
                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                TODO("Not yet implemented")
                            }
                        }
                    }
                }
//                endodoncias
                else if (position == 6){
                    nombre_procedimiento.text = lista[position].toString()
                    Btn_formulario.setOnClickListener {

                        linearlayout_crear_cita.visibility = View.VISIBLE

                        var dato_semana:String = ""

                        val lista_semana = resources.getStringArray(R.array.opciones_dias)
                        val adapter_semana = ArrayAdapter(this@CrearCitaActivity,android.R.layout.simple_spinner_item, lista_semana)
                        spinner_dias_semana.adapter = adapter_semana
                        spinner_dias_semana.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                               no selecciona dia
                                if (position == 0){
                                    hora_procedimiento.text = getString(R.string.sin_horario)
                                    Log.d("semana", dato_semana)
                                    Toast.makeText(this@CrearCitaActivity, "Seleccione un dia de la semana", Toast.LENGTH_SHORT).show()
                                }
//                              Lunes
                                else if (position == 1 ){
                                    hora_procedimiento.text = getString(R.string.hora_endodoncias)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_endodoncias)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               Martes
                                else if (position == 2 ){
                                    hora_procedimiento.text = getString(R.string.hora_endodoncias)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_endodoncias)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               miercoles
                                else if (position == 3 ){
                                    hora_procedimiento.text = getString(R.string.hora_endodoncias)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_endodoncias)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               jueves
                                else if (position == 4 ){
                                    hora_procedimiento.text = getString(R.string.hora_endodoncias)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_endodoncias)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               viernes
                                else if (position == 5 ){
                                    hora_procedimiento.text = getString(R.string.hora_endodoncias)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_endodoncias)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
                            }
                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                TODO("Not yet implemented")
                            }
                        }
                    }
                }
//                limpieza
                else if (position == 7){
                    nombre_procedimiento.text = lista[position].toString()
                    Btn_formulario.setOnClickListener {

                        linearlayout_crear_cita.visibility = View.VISIBLE

                        var dato_semana:String = ""

                        val lista_semana = resources.getStringArray(R.array.opciones_dias)
                        val adapter_semana = ArrayAdapter(this@CrearCitaActivity,android.R.layout.simple_spinner_item, lista_semana)
                        spinner_dias_semana.adapter = adapter_semana
                        spinner_dias_semana.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                               no selecciona dia
                                if (position == 0){
                                    hora_procedimiento.text = getString(R.string.sin_horario)
                                    Log.d("semana", dato_semana)
                                    Toast.makeText(this@CrearCitaActivity, "Seleccione un dia de la semana", Toast.LENGTH_SHORT).show()
                                }
//                              Lunes
                                else if (position == 1 ){
                                    hora_procedimiento.text = getString(R.string.hora_limpieza)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_limpieza)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               Martes
                                else if (position == 2 ){
                                    hora_procedimiento.text = getString(R.string.hora_limpieza)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_limpieza)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               miercoles
                                else if (position == 3 ){
                                    hora_procedimiento.text = getString(R.string.hora_limpieza)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_limpieza)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               jueves
                                else if (position == 4 ){
                                    hora_procedimiento.text = getString(R.string.hora_limpieza)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_limpieza)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               viernes
                                else if (position == 5 ){
                                    hora_procedimiento.text = getString(R.string.hora_limpieza)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_limpieza)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
                            }
                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                TODO("Not yet implemented")
                            }
                        }
                    }
                }
//                radiografias
                else if (position == 8){
                    nombre_procedimiento.text = lista[position].toString()
                    Btn_formulario.setOnClickListener {

                        linearlayout_crear_cita.visibility = View.VISIBLE

                        var dato_semana:String = ""

                        val lista_semana = resources.getStringArray(R.array.opciones_dias)
                        val adapter_semana = ArrayAdapter(this@CrearCitaActivity,android.R.layout.simple_spinner_item, lista_semana)
                        spinner_dias_semana.adapter = adapter_semana
                        spinner_dias_semana.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                               no selecciona dia
                                if (position == 0){
                                    hora_procedimiento.text = getString(R.string.sin_horario)

                                    Toast.makeText(this@CrearCitaActivity, "Seleccione un dia de la semana", Toast.LENGTH_SHORT).show()
                                }
//                              Lunes
                                else if (position == 1 ){
                                    hora_procedimiento.text = getString(R.string.hora_radiografias)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_radiografias)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               Martes
                                else if (position == 2 ){
                                    hora_procedimiento.text = getString(R.string.hora_radiografias)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_radiografias)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               miercoles
                                else if (position == 3 ){
                                    hora_procedimiento.text = getString(R.string.hora_radiografias)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_radiografias)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               jueves
                                else if (position == 4 ){
                                    hora_procedimiento.text = getString(R.string.hora_radiografias)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_radiografias)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }
//                               viernes
                                else if (position == 5 ){
                                    hora_procedimiento.text = getString(R.string.hora_radiografias)
                                    btn_agendar_la_cita.setOnClickListener {
                                        val nombre_apellido = GetNombre_Apellido.text.toString()
                                        val hora_frenos:String = getString(R.string.hora_radiografias)
                                        val dia_semana = lista_semana[position].toString()
                                        GuardaDatosFirebase(nombre_apellido, dia_semana, hora_frenos, lista[position].toString())
                                        linearlayout_crear_cita.visibility = View.INVISIBLE
                                    }

                                }



                            }
                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                TODO("Not yet implemented")
                            }
                        }
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }




    }




    @SuppressLint("RestrictedApi")
    private fun ColorsStatusBar(){

        MyToolbar().MostrarToolbar(this@CrearCitaActivity, getString(R.string.agregar_cita), true)

        val statusBar : Window = window
        statusBar.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        statusBar.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        statusBar.statusBarColor = ContextCompat.getColor(baseContext, R.color.background_resource)
    }

    private fun GuardaDatosFirebase(Nombre_apellido:String, Fecha:String, Hora:String, Procedimiento:String){

            val user_id = FirebaseAuth.getInstance().currentUser?.email

        val data_cita = hashMapOf(
                "id_user" to user_id,
                "Nombre_Apellido" to Nombre_apellido,
                "Fecha" to Fecha,
                "Hora" to Hora,
                "Procedimiento" to Procedimiento
        )

        if (Nombre_apellido.isEmpty() && Fecha.isEmpty() && Hora.isEmpty() && Procedimiento.isEmpty() ){
            Toast.makeText(this,"Los campos no deben estar vacios", Toast.LENGTH_SHORT).show()
        }else {
            FirebaseFirestore.getInstance()
                    .collection("Creacion_Control_Citas")
                    .add(data_cita)
                    .addOnCompleteListener { result ->
                        if (result.isSuccessful){
                            Toast.makeText(this, "Cita Creada", Toast.LENGTH_SHORT).show()
                        }
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "No se pudo crear la cita", Toast.LENGTH_SHORT).show()
                        Log.d("error_Firebase", it.message.toString())
                    }
        }


    }
}