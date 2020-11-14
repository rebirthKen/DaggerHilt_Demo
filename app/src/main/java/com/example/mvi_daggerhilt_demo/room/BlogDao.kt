package com.example.mvi_daggerhilt_demo.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface BlogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(blogCacheEntity: BlogCacheEntity): Long
}