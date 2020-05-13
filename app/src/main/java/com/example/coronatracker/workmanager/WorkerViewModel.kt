package com.example.coronatracker.workmanager

import android.content.Context
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class WorkerViewModel(val context: Context) {

    private val workerManager = WorkManager.getInstance(context)

    fun requestNewData(number: Long, unit: TimeUnit) {
        val request = PeriodicWorkRequest
            .Builder(WorkerHandler::class.java, number, unit)
            .build()

        workerManager.enqueueUniquePeriodicWork("coronaWorker",
            ExistingPeriodicWorkPolicy.REPLACE, request)
    }
}