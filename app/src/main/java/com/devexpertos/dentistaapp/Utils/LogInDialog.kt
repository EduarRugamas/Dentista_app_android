package com.devexpertos.dentistaapp.Utils

import android.app.Activity
import android.app.AlertDialog
import com.devexpertos.dentistaapp.R

class LogInDialog {

    private var activity: Activity? = null
    private var dialog: AlertDialog? = null

    fun LoadingDialog(myActivity: Activity?) {
        activity = myActivity
    }


    fun StartLoadingDialog() {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity!!.layoutInflater
        builder.setView(inflater.inflate(R.layout.custom_log_in_dialog, null))
        dialog = builder.create()
        dialog?.show()
    }

    fun dimissDialog() {
        dialog!!.dismiss()
    }
}