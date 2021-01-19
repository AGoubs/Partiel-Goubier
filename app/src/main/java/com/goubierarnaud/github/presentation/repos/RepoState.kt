package com.goubierarnaud.github.presentation.repos

import com.goubierarnaud.github.domain.model.UserRepos

sealed class RepoState {
    class SuccessState(val repos:List<UserRepos>) : RepoState()

    object ErrorState : RepoState()

    object LoadingState : RepoState()
}
