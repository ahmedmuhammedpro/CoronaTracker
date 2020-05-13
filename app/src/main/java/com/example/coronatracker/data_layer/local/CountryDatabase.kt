package com.example.coronatracker.data_layer.local

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coronatracker.data_layer.model.Country

@Database(entities = [Country::class], version = 1, exportSchema = false)
public abstract class CountryDatabase : RoomDatabase() {

    companion object {
        private var INSTANCE: CountryDatabase? = null
        private var co: Context? = null

        fun getInstance(context: Context): CountryDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, CountryDatabase::class.java,
                    "country_database")
                    .build()
            }

            return INSTANCE!!
        }
    }

    abstract fun countryDao(): CountryDao
}