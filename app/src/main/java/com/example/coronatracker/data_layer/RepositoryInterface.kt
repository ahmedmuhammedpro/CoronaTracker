package com.example.coronatracker.data_layer

import com.example.coronatracker.data_layer.model.Country
import com.example.coronatracker.data_layer.model.World

interface RepositoryInterface {
      /*sara*/

      suspend fun  getAllData(): List<Country>
      suspend fun  getWorldData(): World
      /*sara*/
      /*ahmed*/
      /*ahmed*/
}