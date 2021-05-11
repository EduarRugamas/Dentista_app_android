package com.devexpertos.dentistaapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devexpertos.dentistaapp.Data.DataListaMedicamentos
import com.devexpertos.dentistaapp.R
import kotlinx.android.synthetic.main.item_lista_medicamentos.view.*

class ListaMedicamentosAdapter constructor(
    private val lista_medicamentos: ArrayList<DataListaMedicamentos>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_medicamentos, parent, false)

        return ListaMedicamentosViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val medicamentos_lista: DataListaMedicamentos = lista_medicamentos[position]
        (holder as ListaMedicamentosViewHolder).bind(medicamentos_lista)
    }

    override fun getItemCount(): Int = lista_medicamentos.size

    inner class ListaMedicamentosViewHolder
    constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(medicamentos:DataListaMedicamentos){
            itemView.text_medicamento_nombre.text = medicamentos.Nombre
            itemView.text_medicamentos_descripcion.text = medicamentos.Descripcion
            itemView.text_medicamento_precio.text = medicamentos.Precio
            Glide.with(itemView.context).load(medicamentos.Imagen).into(itemView.image_lista_medicamentos)
        }
    }
}