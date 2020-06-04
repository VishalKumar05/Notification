package com.example.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val observer = MyObserver(this,Handler())
    private lateinit var mReceiver: BroadcastReceiver


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var count = observer.getNotificationCount(this)
        //Log.d("check","Count 1: $count")

        contentResolver.registerContentObserver(
            Uri.parse("content://com.android.tv.notifications.NotificationContentProvider/" + "notifications/count"),
            true,
            observer)

        //mReceiver = BroadcastChangeListener()
        //registerReceiver(mReceiver, IntentFilter("com.android.tv.action.OPEN_NOTIFICATION"))

        button.setOnClickListener {
           navigateToNotifications()
        }
    }

    override fun onStart() {
        super.onStart()
        //mReceiver = BroadcastChangeListener()
        //registerReceiver(mReceiver, IntentFilter("content://com.android.tv.notifications.NotificationContentProvider/"))
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(mReceiver)
    }

    private fun navigateToNotifications(){
        val notificationIntent = Intent("com.android.tv.NOTIFICATIONS_PANEL")
        startActivity(notificationIntent)
    }

    override fun onDestroy() {
        super.onDestroy()
        //contentResolver.unregisterContentObserver(observer)
    }

}
