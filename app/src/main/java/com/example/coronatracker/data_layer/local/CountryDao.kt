package com.example.coronatracker.data_layer.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.coronatracker.data_layer.model.Country

@Dao
public interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg country: Country)

    @Query("select * from country_table where country like :name")
    fun findByName(name: String): Country

    @Query("select * from country_table")
    fun getAll(): LiveData<List<Country>>

    @Delete
    fun delete(vararg country: Country)
}