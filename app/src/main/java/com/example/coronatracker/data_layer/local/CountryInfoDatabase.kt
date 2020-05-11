package com.example.coronatracker.data_layer.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coronatracker.data_layer.model.CountryInfo

@Database(entities = [CountryInfo::class], version = 1, exportSchema = false)
public abstract class CountryInfoDatabase : RoomDatabase() {

    companion object {
        private var INSTANCE: CountryInfoDatabase? = null

        fun getInstance(application: Application): CountryInfoDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(application, CountryInfoDatabase::class.java,
                    "country_info_database")
                    .build()
            }

            return INSTANCE!!
        }
    }

    abstract fun countryInfoDao(): CountryInfoDao
}