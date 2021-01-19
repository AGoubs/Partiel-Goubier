package com.goubierarnaud.github.presentation.repos

import android.app.Application
import androidx.lifecycle.*
import com.goubierarnaud.github.data.repository.DatabaseRepository
import com.goubierarnaud.github.domain.model.UserRepos
import com.goubierarnaud.github.domain.repository.FavoriteRepository
import com.goubierarnaud.github.domain.repository.GithubRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class RepoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: GithubRepository =
        com.goubierarnaud.github.data.repository.GithubRepository(getApplication())

    private val repositoryFavorite: FavoriteRepository = DatabaseRepository()


    private val _state = MutableLiveData<RepoState>()
    val state: LiveData<RepoState> get() = _state

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

    fun addFavorite(id: Int) {
        viewModelScope.launch {
            repositoryFavorite.addFavorite(getApplication(), id)
        }
    }

    fun deleteFavorite(id: Int) {
        viewModelScope.launch {
            repositoryFavorite.deleteFavorite(getApplication(), id)
        }
    }
}