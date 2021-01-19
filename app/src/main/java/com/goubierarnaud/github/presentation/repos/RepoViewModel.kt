package com.goubierarnaud.github.presentation.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goubierarnaud.github.domain.repository.GithubRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class RepoViewModel : ViewModel() {
    private val repository: GithubRepository = com.goubierarnaud.github.data.repository.GithubRepository()

    private val _state = MutableLiveData<RepoState>()
    val state : LiveData<RepoState> get() = _state

    fun getUserRepos(text: String) {
        _state.value = RepoState.LoadingState

        viewModelScope.launch {
            try {
                _state.value = RepoState.SuccessState(repository.getUserRepos(text))
            } catch (e: Exception) {
                _state.value = RepoState.ErrorState
            }
        }
    }
}