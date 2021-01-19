package com.goubierarnaud.github.data.database.dao

import androidx.room.*
import com.goubierarnaud.github.data.database.model.Favorite

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM favorite")
    suspend fun getAllFavorite(): List<Favorite>

    @Query("SELECT * FROM favorite WHERE id = :id")
    suspend fun getFavorite(id: String): List<Favorite>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(favorite: Favorite)

    @Delete
    suspend fun deleteFavorite(favorite: Favorite)
}