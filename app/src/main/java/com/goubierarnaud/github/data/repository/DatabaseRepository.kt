package com.goubierarnaud.github.data.repository

import android.content.Context
import com.goubierarnaud.github.data.database.AppDatabase
import com.goubierarnaud.github.data.database.model.Favorite
import com.goubierarnaud.github.domain.model.UserRepos
import com.goubierarnaud.github.domain.repository.FavoriteRepository

class DatabaseRepository : FavoriteRepository {
    override suspend fun getFavorite(context: Context): List<Favorite> {
       return AppDatabase.getInstance(context)?.getFavoriteDao()?.getAllFavorite()?: emptyList()
    }

    override suspend fun addFavorite(context: Context, id: Int) {
        AppDatabase.getInstance(context)?.getFavoriteDao()?.addFavorite(Favorite(id))
    }
    override suspend fun deleteFavorite(context: Context, id: Int) {
        AppDatabase.getInstance(context)?.getFavoriteDao()?.deleteFavorite(Favorite(id))
    }
}


