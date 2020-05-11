package com.example.coronatracker.data_layer

import androidx.lifecycle.LiveData
import com.example.coronatracker.data_layer.model.Country
import com.example.coronatracker.data_layer.model.CountryInfo
import com.example.coronatracker.data_layer.model.World

interface LocalRepository {

    // Country
    suspend fun insertCountries(vararg country: Country)
    suspend fun findCountryByName(name: String): Country
    suspend fun getAllCountries(): LiveData<List<Country>>
    suspend fun deleteCountries(vararg country: Country)

    // Country Info
    suspend fun insertCountryInfo(vararg countryInfo: CountryInfo)
    suspend fun findCountryInfoById(id: Int): CountryInfo
    suspend fun getAllCountriesInfo(): LiveData<List<CountryInfo>>
    suspend fun deleteCountriesInfo(vararg countryInfo: CountryInfo)

    // World
    suspend fun insertWorldEntities(vararg world: World)
    suspend fun findWorldEntityById(id: Int): World
    suspend fun getAllWorldEntities(): LiveData<List<World>>
    suspend fun deleteWorldEntities(vararg world: World)
}