package com.devexpertos.dentistaapp.Utils

import android.app.Activity
import android.app.AlertDialog
import com.devexpertos.dentistaapp.R

class CreateUserDialog {

    private var activity: Activity? = null
    private var dialog: AlertDialog? = null

    fun LoadingDialog(myActivity: Activity?) {
        activity = myActivity
    }


    fun StartLoadingDialog() {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity!!.layoutInflater
        builder.setView(inflater.inflate(R.layout.custom_dialog_create_user, null))
        dialog = builder.create()
        dialog?.show()
    }

    fun dimissDialog() {
        dialog!!.dismiss()
    }
}