package com.example.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BroadcastChangeListener : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("check","Action: ${intent?.action}")
    }

}