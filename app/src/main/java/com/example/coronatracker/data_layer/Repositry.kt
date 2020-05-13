package com.example.coronatracker.data_layer

import com.example.coronatracker.data_layer.model.Country
import com.example.coronatracker.data_layer.model.World
import com.example.coronatracker.data_layer.remote.RetrofitClient
import okhttp3.OkHttpClient

class Repositry :RepositoryInterface{
    /*sara*/
    private var retrofitClient: RetrofitClient? = null
    var okHttpClient :OkHttpClient = OkHttpClient()

    init  {
        retrofitClient = RetrofitClient.getInstance(okHttpClient)
    }
    override suspend fun getAllData(): List<Country> {
        return retrofitClient?.getAllData()!!
    }
    override suspend fun getWorldData(): World {
        return retrofitClient?.getWorldData()!!
    }

    override suspend fun getCountriesData(names: String): List<Country> {
        return retrofitClient?.getCountriesData(names)!!
    }
    /*ahmed*/

}