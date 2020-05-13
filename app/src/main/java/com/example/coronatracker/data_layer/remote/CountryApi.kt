package com.example.coronatracker.data_layer.remote


import com.example.coronatracker.data_layer.model.Country
import com.example.coronatracker.data_layer.model.World
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CounrtyApi {
    /*sara*/
    @GET("/v2/countries")
    fun getAllCountryData(): Deferred<List<Country>>

    @GET("/v2/all")
    fun getWorldData(): Deferred<World>
    /*sara*/
    /*ahmed*/

    @GET("/v2/countries/{names}")
    fun getCountriesData(@Path("names") names: String): Deferred<List<Country>>
    /*ahmed*/
}