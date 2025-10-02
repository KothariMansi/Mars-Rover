package com.kotharimansi.marsrover.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MarsRoverSavedPhotoDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(marsRoverSavedLocalModel: MarsRoverSavedLocalModel): Long

    @Delete
    suspend fun delete(marsRoverSavedLocalModel: MarsRoverSavedLocalModel)

    @Query("SELECT rover_photo_id FROM rover_photo WHERE sol = :sol AND rover_name = :roverName")
    fun allSavedId(sol: String, roverName: String): Flow<List<Int>>

}