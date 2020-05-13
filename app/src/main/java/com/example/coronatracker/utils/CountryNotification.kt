package com.example.coronatracker.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.coronatracker.MainActivity
import com.example.coronatracker.R
import com.example.coronatracker.data_layer.model.Country

class CountryNotification(val context: Context) {

    companion object {
        const val NOTIFICATION_CHANNEL_ID = "countryNotificationChannel"
    }

    init {
        createNotificationChannel()
    }

    private lateinit var notificationManager: NotificationManager

    fun showNotification(country: Country) {
        notificationManager.notify(country.hashCode(), getNotificationBuilder(country).build())
    }

    private fun createNotificationChannel() {
        notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(NOTIFICATION_CHANNEL_ID,
                "Corona Tracker", NotificationManager.IMPORTANCE_HIGH)

            notificationChannel.enableLights(true)
            notificationChannel.enableVibration(true)
            notificationChannel.lightColor = Color.RED
            notificationChannel.description = "Corona Tracker Notification"
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }

    private fun getNotificationBuilder(country: Country): NotificationCompat.Builder {
        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, country.hashCode(),
            intent, PendingIntent.FLAG_ONE_SHOT)

        return NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
            .setContentIntent(pendingIntent)
            .setContentTitle("Corona Tracker")
            .setContentText("${country.country} cases: ${country.cases}, " +
                    "deaths: ${country.deaths}, recovered: ${country.recovered}")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setSmallIcon(R.drawable.ic_notifications)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
    }
}