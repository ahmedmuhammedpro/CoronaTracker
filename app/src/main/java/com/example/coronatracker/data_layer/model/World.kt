package com.example.coronatracker.data_layer.model

import com.example.mvvmdemo.data_layer.model.CountryInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class World(
    @SerializedName("updated")
    @Expose
    val updated: Long,
    @SerializedName("cases")
    @Expose
    val cases: Long,
    @SerializedName("todayCases")
    @Expose
    val todayCases: Long,
    @SerializedName("deaths")
    @Expose
    val deaths: Long,
    @SerializedName("todayDeaths")
    @Expose
    val todayDeaths: Long,
    @SerializedName("recovered")
    @Expose
    val recovered: Long,
    @SerializedName("active")
    @Expose
    val active: Long,
    @SerializedName("critical")
    @Expose
    val critical: Long,
    @SerializedName("casesPerOneMillion")
    @Expose
    val casesPerOneMillion: Double,
    @SerializedName("deathsPerOneMillion")
    @Expose
    val deathsPerOneMillion: Double,
    @SerializedName("tests")
    @Expose
    val tests: Long,
    @SerializedName("testsPerOneMillion")
    @Expose
    val testsPerOneMillion: Double,
    @SerializedName("affectedCountries")
    @Expose
    val affectedCountries: Long
)