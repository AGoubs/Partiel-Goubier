package com.goubierarnaud.github.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goubierarnaud.github.domain.repository.GithubRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class SearchViewModel : ViewModel() {
    private val repository: GithubRepository = com.goubierarnaud.github.data.repository.GithubRepository()

    private val _state = MutableLiveData<SearchState>()
    val state : LiveData<SearchState> get() = _state

    fun searchUser(text: String) {
        _state.value = SearchState.LoadingState

        viewModelScope.launch {
            try {
                _state.value = SearchState.SuccessState(repository.searchUser(text))
            } catch (e: Exception) {
                _state.value = SearchState.ErrorState
            }
        }
    }
}