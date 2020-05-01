package com.example.mvvmdemo.data_layer.remote

import com.example.mvvmdemo.data_layer.model.Country
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface CounrtyApi {
    /*sara*/
    @GET("/v2/countries")
    fun getAllCountryData(): Deferred<List<Country>>
    /*sara*/
    /*ahmed*/
    /*ahmed*/
}