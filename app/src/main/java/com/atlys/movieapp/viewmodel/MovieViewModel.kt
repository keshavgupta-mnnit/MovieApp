package com.atlys.movieapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atlys.movieapp.usecase.GetMovieListUseCase
import com.atlys.movieapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val useCase: GetMovieListUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(MovieListUiState())
    val state = _state.asStateFlow()

    private val _searchString = MutableStateFlow("")
    val searchString = _searchString.asStateFlow()

    init {
        fetchMovie()
    }

    fun fetchMovie() {
        useCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = MovieListUiState(
                        allList = result.data?.results ?: emptyList(),
                        isLoading = false,
                        filteredList = null
                    )
                }

                is Resource.Error -> {
                    _state.value = MovieListUiState(error = result.message ?: "Error Occurred")
                }

                is Resource.Loading -> {
                    _state.value = _state.value.copy(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun fetchMovieByQuery(query: String) {
        _searchString.value = query
        if (query.isNotBlank()) {
            useCase.getMovieListByQuery(query).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value =
                            _state.value.copy(
                                filteredList = result.data?.results ?: emptyList(),
                                isLoading = false
                            )
                    }

                    is Resource.Error -> {
                        _state.value = MovieListUiState(error = result.message ?: "Error Occurred")
                    }

                    is Resource.Loading -> {
                        _state.value = _state.value.copy(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
        } else {
            _state.value = _state.value.copy(filteredList = null)
        }
    }
}

