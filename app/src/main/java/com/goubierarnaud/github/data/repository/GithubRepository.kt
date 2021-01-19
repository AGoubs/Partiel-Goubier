package com.goubierarnaud.github.data.repository

import com.goubierarnaud.github.data.api.GithubApi
import com.goubierarnaud.github.data.model.GithubUserShort
import com.goubierarnaud.github.domain.model.UserShort
import com.goubierarnaud.github.domain.repository.GithubRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubRepository : GithubRepository {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(GithubApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(GithubApi::class.java)

    override suspend fun searchUser(search: String): List<UserShort> {
        return api.searchUser(search).users.map {
            it.toUserShort()
        }
    }
}

fun GithubUserShort.toUserShort() = UserShort(this.id, this.login, this.avatar)
