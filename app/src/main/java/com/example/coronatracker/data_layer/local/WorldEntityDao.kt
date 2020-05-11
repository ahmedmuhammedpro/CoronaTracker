package com.example.coronatracker.data_layer.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.coronatracker.data_layer.model.World

@Dao
public interface WorldEntityDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg world: World)

    @Query("select * from world_table where id like :id")
    fun findById(id: Int): World

    @Query("select * from world_table")
    fun getAll(): LiveData<List<World>>

    @Delete
    fun delete(vararg world: World)
}