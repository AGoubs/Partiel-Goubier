package com.goubierarnaud.github.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("items")
    val users: List<GithubUserShort>,
    @SerializedName("total_count")
    val resultNumber: Int,
)
