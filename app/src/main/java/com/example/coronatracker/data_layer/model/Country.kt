package com.example.coronatracker.data_layer.model
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "country_table")
data class Country (
    @SerializedName("updated")
    @Expose
    val updated: Long,
    @SerializedName("country")
    @Expose
    @PrimaryKey
    @NonNull
    val country: String,
    @SerializedName("countryInfo")
    @Expose
    val countryInfo: CountryInfo,
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
    val casesPerOneMillion: Long,
    @SerializedName("deathsPerOneMillion")
    @Expose
    val deathsPerOneMillion: Long,
    @SerializedName("tests")
    @Expose
    val tests: Long,
    @SerializedName("testsPerOneMillion")
    @Expose
    val testsPerOneMillion: Long,
    @SerializedName("continent")
    @Expose
    val continent: String

)

@Entity(tableName = "country_info_table")
data class CountryInfo (
    @SerializedName("_id")
    @Expose
    @PrimaryKey
    @NonNull
    val id: Long,
    @SerializedName("iso2")
    @Expose
    val iso2: String,
    @SerializedName("iso3")
    @Expose
    val iso3: String,
    @SerializedName("lat")
    @Expose
    val lat: Double,
    @SerializedName("long")
    @Expose
    val long: Double,
    @SerializedName("flag")
    @Expose
    val flag: String
)