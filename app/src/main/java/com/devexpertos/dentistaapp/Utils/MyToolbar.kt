package com.devexpertos.dentistaapp.Utils

import androidx.appcompat.app.AppCompatActivity
import com.devexpertos.dentistaapp.R
import kotlinx.android.synthetic.main.action_bar_toolbar.view.*

class MyToolbar {

    fun MostrarToolbar(MyActivity: AppCompatActivity, titulo:String?, BtnAtras:Boolean?){
        MyActivity.setSupportActionBar(MyActivity.findViewById(R.id.action_toolbar))
        MyActivity.supportActionBar?.title = titulo
        MyActivity.supportActionBar?.setDisplayHomeAsUpEnabled(BtnAtras!!)

    }
}