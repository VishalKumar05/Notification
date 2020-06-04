package com.example.notification

import android.content.Context
import android.database.ContentObserver
import android.database.Cursor
import android.net.Uri
import android.os.Handler
import android.util.Log

class MyObserver(private val context: Context, handler: Handler?) : ContentObserver(handler) {

    override fun onChange(selfChange: Boolean) {
        super.onChange(selfChange,null)
        Log.d("Observer","onChange 1")
        Log.d("Observer","selfChange: $selfChange")
    }

    override fun onChange(selfChange: Boolean, uri: Uri?) {
        Log.d("Observer","onChange 2")
        Log.d("Observer","selfChange: $selfChange  uri: $uri")
    }

    fun getNotificationCount(context: Context):Int{
        Log.d("Observer","Inside getNotificationCount")
        val NOTIF_COUNT_CONTENT_URI = Uri.parse(
            "content://com.android.tv.notifications.NotificationContentProvider/" +
                    "notifications/count")
        val COLUMN_COUNT = "count"
        var count: Int = 0
        val c: Cursor? = context.contentResolver.query(NOTIF_COUNT_CONTENT_URI, null, null, null, null)
        if (c != null && c.moveToFirst()) {
            val index: Int = c.getColumnIndex(COLUMN_COUNT)
            count = c.getInt(index)
        }
        Log.d("count","Count2: $count")
        c?.close()

        return count
    }

}