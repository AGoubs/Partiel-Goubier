package com.goubierarnaud.github.data.repository

import android.content.Context
import com.goubierarnaud.github.data.database.AppDatabase
import com.goubierarnaud.github.data.database.model.Favorite
import com.goubierarnaud.github.domain.model.UserRepos
import com.goubierarnaud.github.domain.repository.FavoriteRepository

class DatabaseRepository : FavoriteRepository {
    override suspend fun getFavorite(context: Context): List<Favorite> {
        TODO("Not yet implemented")
    }

    override suspend fun addFavorite(context: Context, userRepos: UserRepos) {
        TODO("Not yet implemented")
    }
}

fun UserRepos.toFavorite() = Favorite(this.id, this.name)