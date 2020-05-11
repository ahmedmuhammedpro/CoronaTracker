package com.example.coronatracker.data_layer

import androidx.lifecycle.LiveData
import com.example.coronatracker.data_layer.model.Country
import com.example.coronatracker.data_layer.model.CountryInfo
import com.example.coronatracker.data_layer.model.World

interface LocalRepository {

    // Country
    fun insertCountries(vararg country: Country)
    fun findCountryByName(name: String): Country
    fun getAllCountries(): LiveData<List<Country>>
    fun deleteCountries(vararg country: Country)

    // Country Info
    fun insertCountryInfo(vararg countryInfo: CountryInfo)
    fun findCountryInfoById(id: Int): CountryInfo
    fun getAllCountriesInfo(): LiveData<List<CountryInfo>>
    fun deleteCountriesInfo(vararg countryInfo: CountryInfo)

    // World
    fun insertWorldEntities(vararg world: World)
    fun findWorldEntityById(id: Int): World
    fun getAllWorldEntities(): LiveData<List<World>>
    fun deleteWorldEntities(vararg world: World)
}