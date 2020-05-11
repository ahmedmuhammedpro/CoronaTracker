package com.example.coronatracker.data_layer.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.coronatracker.data_layer.model.World

@Dao
public interface WorldEntityDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg world: World)

    @Query("select * from world_table where id like :id")
    suspend fun findById(id: Int): World

    @Delete
    suspend fun delete(vararg world: World)
}