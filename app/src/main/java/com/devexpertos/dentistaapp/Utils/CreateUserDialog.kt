package com.devexpertos.dentistaapp.Utils

import android.app.Activity
import android.app.AlertDialog
import com.devexpertos.dentistaapp.R

class CreateUserDialog {

    private var activity: Activity? = null
    private var dialog: AlertDialog? = null

    //funcion de llamado donde se obtiene la actividad
    fun LoadingDialog(myActivity: Activity?) {
        activity = myActivity
    }

    //creacion de la alerta
    fun StartLoadingDialog() {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity!!.layoutInflater
        builder.setView(inflater.inflate(R.layout.custom_dialog_create_user, null))
        builder.setPositiveButton(R.string.aceptar, null)
        dialog = builder.create()
        dialog?.show()
    }

    fun dimissDialog() {
        dialog!!.dismiss()
    }
}