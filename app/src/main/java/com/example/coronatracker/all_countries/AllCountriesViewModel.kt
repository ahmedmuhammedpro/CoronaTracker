package com.example.coronatracker.all_countries

import androidx.lifecycle.ViewModel
import com.example.coronatracker.data_layer.RepositoryInterface
import com.example.coronatracker.data_layer.Repositry
import com.example.coronatracker.data_layer.model.Country
import com.example.coronatracker.data_layer.model.World


class AllCountriesViewModel : ViewModel() {
    var  allCountryList :List<Country>? = null
    var world :World? = null
    val repository: RepositoryInterface = Repositry()
    suspend  fun  getAllCountriesDataList(): List<Country>{
        allCountryList  = repository.getAllData()
        return allCountryList!!
    }
    suspend  fun  getWorldData(): World{
        world  = repository.getWorldData()

        return world!!
    }
}
