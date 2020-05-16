package com.example.coronatracker.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.coronatracker.data_layer.LocalRepositoryImp
import com.example.coronatracker.data_layer.Repositry
import com.example.coronatracker.data_layer.model.Country
import com.example.coronatracker.utils.CountryNotification
import kotlinx.coroutines.*

class WorkerHandler(val context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {

    private lateinit var localCountries: List<Country>
    private lateinit var remoteCountries: List<Country>
    private var countyNames = ""

    override fun doWork(): Result = runBlocking {
        val deferredLocal = async {
            Log.i("ahmed", "WorkerHandler")
            val localRepo = LocalRepositoryImp(context)
            localCountries = localRepo.getAllCountriesWithoutLiveData()
            for (i in localCountries.indices) {
                countyNames += localCountries[i].country + ","
            }

            Log.i("ahmed", "local countries $countyNames")
        }

        val deferredRemote = async {
            val remoteRepo = Repositry()
            remoteCountries = remoteRepo.getCountriesData(countyNames)
        }

        deferredLocal.await()
        deferredRemote.await()

        if (localCountries != null && remoteCountries != null) {
            showNotification(localCountries, remoteCountries)
        }

        Result.success()
    }

    private fun showNotification(oldCountries: List<Country>, newCountries: List<Country>) {
        val notification = CountryNotification(context)
        // I change data for testing only
//        var count: Long = 5
//        newCountries.forEach {
//            count += 5
//            it.cases = count
//        }
        for (i in oldCountries.indices) {
            if (!oldCountries[i].equals(newCountries[i])) {
                notification.showNotification(newCountries[i])
            }
        }
    }

}