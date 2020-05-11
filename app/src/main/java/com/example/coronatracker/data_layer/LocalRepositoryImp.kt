package com.example.coronatracker.data_layer

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.coronatracker.data_layer.local.CountryDatabase
import com.example.coronatracker.data_layer.local.CountryInfoDatabase
import com.example.coronatracker.data_layer.local.WorldEntityDatabase
import com.example.coronatracker.data_layer.model.Country
import com.example.coronatracker.data_layer.model.CountryInfo
import com.example.coronatracker.data_layer.model.World
import java.lang.UnsupportedOperationException

public class LocalRepositoryImp(application: Application) : LocalRepository {

    private val countryDao = CountryDatabase.getInstance(application).countryDao()
    private val countryInfoDao = CountryInfoDatabase.getInstance(application).countryInfoDao()
    private val worldEntityDao = WorldEntityDatabase.getInstance(application).worldEntityDao()

    // Country functions
    override suspend fun insertCountries(vararg country: Country) {
        countryDao.insert(*country)
    }

    override suspend fun findCountryByName(name: String): Country {
        return countryDao.findByName(name)
    }

    override suspend fun getAllCountries(): LiveData<List<Country>> {
        return countryDao.getAll()
    }

    override suspend fun deleteCountries(vararg country: Country) {
        countryDao.delete(*country)
    }

    ////////////////////////////////////////////////////////////////////////////////

    // Country Info functions
    override suspend fun insertCountryInfo(vararg countryInfo: CountryInfo) {
        countryInfoDao.insert(*countryInfo)
    }

    override suspend fun findCountryInfoById(id: Int): CountryInfo {
        return countryInfoDao.findById(id)
    }

    override suspend fun getAllCountriesInfo(): LiveData<List<CountryInfo>> {
        return countryInfoDao.getAll()
    }

    override suspend fun deleteCountriesInfo(vararg countryInfo: CountryInfo) {
        countryInfoDao.delete(*countryInfo)
    }

    ////////////////////////////////////////////////////////////////////////////

    // World Entity functions
    override suspend fun insertWorldEntities(vararg world: World) {
        worldEntityDao.insert(*world)
    }

    override suspend fun findWorldEntityById(id: Int): World {
        return findWorldEntityById(id)
    }

    override suspend fun getAllWorldEntities(): LiveData<List<World>> {
        throw UnsupportedOperationException()
    }

    override suspend fun deleteWorldEntities(vararg world: World) {
        worldEntityDao.delete(*world)
    }
}