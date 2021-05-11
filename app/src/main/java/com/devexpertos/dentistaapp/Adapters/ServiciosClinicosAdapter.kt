package com.devexpertos.dentistaapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devexpertos.dentistaapp.Data.DataServiciosMedicos
import com.devexpertos.dentistaapp.R
import kotlinx.android.synthetic.main.item_servicios_clinicos.view.*

class ServiciosClinicosAdapter constructor(
        private val lista_servicios_clinicos:ArrayList<DataServiciosMedicos>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_servicios_clinicos,parent,false)

        return ServiciosClinicosViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val serviciosClinicos_lista: DataServiciosMedicos = lista_servicios_clinicos[position]
        (holder as ServiciosClinicosViewHolder).bind(serviciosClinicos_lista)

    }

    override fun getItemCount(): Int = lista_servicios_clinicos.size

    inner class ServiciosClinicosViewHolder constructor(itemView:View) : RecyclerView.ViewHolder(itemView) {
            fun bind(serviciosClinicos:DataServiciosMedicos ){
                itemView.text_nombre.text = serviciosClinicos.Nombre
                itemView.text_horario.text = serviciosClinicos.Horario
                itemView.text_precio.text = serviciosClinicos.Precio

            }
    }
}