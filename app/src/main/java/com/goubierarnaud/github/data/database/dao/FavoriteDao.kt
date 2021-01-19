package com.goubierarnaud.github.data.database.dao

import androidx.room.*
import com.goubierarnaud.github.data.database.model.Favorite

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM favorite")
    suspend fun getAllBookmark(): List<Favorite>

}