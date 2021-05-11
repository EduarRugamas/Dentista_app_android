package com.devexpertos.dentistaapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devexpertos.dentistaapp.Data.DataListaMedicos
import com.devexpertos.dentistaapp.R
import kotlinx.android.synthetic.main.item_lista_medicos.view.*

class ListaMedicosAdapter constructor(
    private val lista_Medicos: ArrayList<DataListaMedicos>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_medicos, parent,false)
        return ListaMedicosViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val medicos_lista: DataListaMedicos = lista_Medicos[position]
        (holder as ListaMedicosViewHolder).find(medicos_lista)
    }

    override fun getItemCount(): Int = lista_Medicos.size

    inner class ListaMedicosViewHolder constructor(itemView:View) : RecyclerView.ViewHolder(itemView){
        fun find(listaMedicos:DataListaMedicos){
            itemView.text_medicos_nombre.text = listaMedicos.Nombre
            itemView.text_medicos_especialidad.text = listaMedicos.Especialidad
            itemView.text_medicos_horarios.text = listaMedicos.Horario
        }
    }
}