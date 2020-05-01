package com.example.mvvmdemo.data_layer

import com.example.mvvmdemo.data_layer.model.Country
import com.example.mvvmdemo.data_layer.remote.RetrofitClient
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

     /*sara*/
    /*ahmed*/
    /*ahmed*/

}