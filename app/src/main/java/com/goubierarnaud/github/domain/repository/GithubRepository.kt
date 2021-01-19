package com.goubierarnaud.github.domain.repository

import com.goubierarnaud.github.domain.model.UserShort

interface GithubRepository {

    suspend fun searchUser(search: String): List<UserShort>

}