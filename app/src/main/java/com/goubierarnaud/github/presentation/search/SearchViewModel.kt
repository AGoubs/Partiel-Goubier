package com.goubierarnaud.github.presentation.search

import android.app.Application
import androidx.lifecycle.*
import com.goubierarnaud.github.domain.repository.GithubRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class SearchViewModel(application: Application) : AndroidViewModel(application){
    private val repository: GithubRepository = com.goubierarnaud.github.data.repository.GithubRepository(getApplication())

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