package com.example.mvvmdemo.data_layer

import com.example.coronatracker.data_layer.model.World
import com.example.mvvmdemo.data_layer.model.Country

interface RepositoryInterface {
      /*sara*/

      suspend fun  getAllData(): List<Country>
      suspend fun  getWorldData(): World
      /*sara*/
      /*ahmed*/
      /*ahmed*/
}