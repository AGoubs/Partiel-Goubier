package com.goubierarnaud.github.presentation.search

import com.goubierarnaud.github.domain.model.UserShort

sealed class SearchState {
    class SuccessState(val movies:List<UserShort>) : SearchState()

    object ErrorState : SearchState()

    object LoadingState : SearchState()
}
