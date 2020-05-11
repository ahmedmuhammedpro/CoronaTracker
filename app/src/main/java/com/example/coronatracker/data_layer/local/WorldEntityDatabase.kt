package com.example.coronatracker.data_layer.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coronatracker.data_layer.model.World

@Database(entities = [World::class], version = 1, exportSchema = false)
public abstract class WorldEntityDatabase : RoomDatabase() {

    companion object {
        private var INSTANCE: WorldEntityDatabase? = null

        fun getInstance(application: Application): WorldEntityDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(application, WorldEntityDatabase::class.java,
                    "world_entity_database")
                    .build()
            }

            return INSTANCE!!
        }
    }

    abstract fun worldEntityDao(): WorldEntityDao
}