package com.goubierarnaud.github.data.repository

import com.goubierarnaud.github.data.api.GithubApi
import com.goubierarnaud.github.data.model.GithubUserRepos
import com.goubierarnaud.github.data.model.GithubUserShort
import com.goubierarnaud.github.domain.model.UserRepos
import com.goubierarnaud.github.domain.model.UserShort
import com.goubierarnaud.github.domain.repository.GithubRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubRepository : GithubRepository {

    private val retrofit: Retrofit

    init {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(GithubApi.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val api = retrofit.create(GithubApi::class.java)

    override suspend fun searchUser(search: String): List<UserShort> {
        return api.searchUser(search).users.map {
            it.toUserShort()
        }
    }

    override suspend fun getUserRepos(login: String): List<UserRepos> {
        return api.getUserRepos(login).map {
            it.tuUserRepos()
        }
    }
}

fun GithubUserShort.toUserShort() = UserShort(
    this.id,
    this.login,
    this.avatar
)

fun GithubUserRepos.tuUserRepos() = UserRepos(
    this.id,
    this.name,
    this.description,
    this.language,
    this.forks,
    this.watchers,
    this.license?.name,
)
