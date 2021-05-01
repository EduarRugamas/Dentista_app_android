package com.devexpertos.dentistaapp.Utils

import android.app.Activity
import android.app.AlertDialog
import com.devexpertos.dentistaapp.R

class SignOutAlert {

    private var activity: Activity? = null
    private var dialog: AlertDialog? = null

    fun Loading_Alert_SignOut(myActivity: Activity?) {
        activity = myActivity
        val builder = AlertDialog.Builder(activity)
        val inflater = activity!!.layoutInflater
        builder.setView(inflater.inflate(R.layout.custom_alert_signout, null))
        dialog = builder.create()
        dialog?.show()
    }
}