package com.goubierarnaud.github.data.api

import com.goubierarnaud.github.data.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {
    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    @GET("/search/users")
    suspend fun searchUser(
        @Query("q") login: String,
    ) : SearchResponse
}