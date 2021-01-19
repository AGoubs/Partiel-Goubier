package com.goubierarnaud.github.domain.repository

import android.content.Context
import com.goubierarnaud.github.data.database.model.Favorite
import com.goubierarnaud.github.domain.model.UserRepos

interface FavoriteRepository {

    suspend fun getFavorite(context: Context): List<Favorite>

    suspend fun addFavorite(context: Context, userRepos: UserRepos)
}