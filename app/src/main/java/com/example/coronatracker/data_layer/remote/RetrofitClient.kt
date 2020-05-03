package com.example.mvvmdemo.data_layer.remote

import com.example.coronatracker.data_layer.model.World
import com.example.mvvmdemo.data_layer.model.Country
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor(){
    companion object {
        fun getInstance(okHttpClient: OkHttpClient): RetrofitClient {
            if (INSTANCE == null) {
                INSTANCE = RetrofitClient()
                val retrofit = Retrofit.Builder()
                    .baseUrl(API_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .build()
                counrtyApi = retrofit.create(CounrtyApi::class.java)
            }
            return INSTANCE as RetrofitClient
        }

        val API_URL = "https://disease.sh"
        private var counrtyApi: CounrtyApi? = null
        private var INSTANCE: RetrofitClient? = null
    }
    fun getCountryApi(): CounrtyApi? {
        return counrtyApi
    }
/*sara*/
     suspend fun getAllData(): List<Country> {
         var list : List<Country>? = null
        val result = counrtyApi?.getAllCountryData()?.await()
         if (result != null)
         {   list = result.map { it }
         }
         return list!!
         }
    suspend fun getWorldData(): World {
        var data : World? = null
        val result = counrtyApi?.getWorldData()?.await()
        if (result != null)
        {   data = result
        }
        return data!!
    }
    /*sara*/
    /*ahmed*/
    /*ahmed*/
    }
