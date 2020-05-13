package com.example.coronatracker.data_layer

import com.example.coronatracker.data_layer.model.Country
import com.example.coronatracker.data_layer.model.World

interface RepositoryInterface {
      /*sara*/

      suspend fun  getAllData(): List<Country>
      suspend fun  getWorldData(): World
      suspend fun getCountriesData(names: String): List<Country>
      /*sara*/
      /*ahmed*/
      /*ahmed*/
}