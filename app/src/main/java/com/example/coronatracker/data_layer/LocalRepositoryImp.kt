package com.example.coronatracker.data_layer

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.coronatracker.data_layer.local.CountryDatabase
import com.example.coronatracker.data_layer.local.CountryInfoDatabase
import com.example.coronatracker.data_layer.local.WorldEntityDatabase
import com.example.coronatracker.data_layer.model.Country
import com.example.coronatracker.data_layer.model.CountryInfo
import com.example.coronatracker.data_layer.model.World
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.UnsupportedOperationException

public class LocalRepositoryImp(context: Context) : LocalRepository {

    private val countryDao = CountryDatabase.getInstance(context).countryDao()
    private val countryInfoDao = CountryInfoDatabase.getInstance(context).countryInfoDao()
    private val worldEntityDao = WorldEntityDatabase.getInstance(context).worldEntityDao()

    // Country functions
    override fun insertCountries(vararg country: Country) {
        CoroutineScope(Dispatchers.IO).launch {
            countryDao.insert(*country)
        }
    }

    override fun findCountryByName(name: String): Country {
        return countryDao.findByName(name)
    }

    override fun getAllCountries(): LiveData<List<Country>> {
        return countryDao.getAll()
    }

    override fun getAllCountriesWithoutLiveData(): List<Country> {
        return countryDao.getAllWithoutLiveData()
    }

    override fun deleteCountries(vararg country: Country) {
        CoroutineScope(Dispatchers.IO).launch {
            countryDao.delete(*country)
        }
    }

    ////////////////////////////////////////////////////////////////////////////////

    // Country Info functions
    override fun insertCountryInfo(vararg countryInfo: CountryInfo) {
        CoroutineScope(Dispatchers.IO).launch {
            countryInfoDao.insert(*countryInfo)
        }
    }

    override fun findCountryInfoById(id: Int): CountryInfo {
        return countryInfoDao.findById(id)
    }

    override fun getAllCountriesInfo(): LiveData<List<CountryInfo>> {
        return countryInfoDao.getAll()
    }

    override fun deleteCountriesInfo(vararg countryInfo: CountryInfo) {
        CoroutineScope(Dispatchers.IO).launch {
            countryInfoDao.delete(*countryInfo)
        }
    }

    ////////////////////////////////////////////////////////////////////////////

    // World Entity functions
    override fun insertWorldEntities(vararg world: World) {
        CoroutineScope(Dispatchers.IO).launch {
            worldEntityDao.insert(*world)
        }
    }

    override fun findWorldEntityById(id: Int): World {
        return findWorldEntityById(id)
    }

    override fun getAllWorldEntities(): LiveData<List<World>> {
        throw UnsupportedOperationException()
    }

    override fun deleteWorldEntities(vararg world: World) {
        CoroutineScope(Dispatchers.IO).launch {
            worldEntityDao.delete(*world)
        }
    }
}