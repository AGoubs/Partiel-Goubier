package com.goubierarnaud.github.data.model

import com.google.gson.annotations.SerializedName

data class GithubUserShort(
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatar: String,
)
