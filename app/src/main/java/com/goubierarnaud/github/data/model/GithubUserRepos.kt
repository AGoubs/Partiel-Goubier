package com.goubierarnaud.github.data.model

import com.google.gson.annotations.SerializedName

data class GithubUserRepos(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("forks")
    val forks: Int,
    @SerializedName("watchers")
    val watchers: Int,
    @SerializedName("license")
    val license: GithubLicense?,

)
