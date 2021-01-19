package com.goubierarnaud.github.domain.model

data class UserRepos(
    val id: Int,
    val name: String,
    val description: String?,
    val language: String?,
    val forks: Int,
    val watchers: Int,
    val license: String?,
)
