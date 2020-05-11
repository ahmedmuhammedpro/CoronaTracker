package com.example.coronatracker.data_layer.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.coronatracker.data_layer.model.CountryInfo

@Dao
public interface CountryInfoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg countryInfo: CountryInfo)

    @Query("select * from country_info_table where id like :id")
    fun findById(id: Int): CountryInfo

    @Query("select * from country_info_table")
    fun getAll(): LiveData<List<CountryInfo>>

    @Delete
    fun delete(vararg country: CountryInfo)
}