package com.atlys.movieapp.viewmodel

import com.atlys.movieapp.models.MovieDto

data class MovieListUiState(
    val isLoading: Boolean = false,
    val allList: List<MovieDto>? = null,
    val filteredList: List<MovieDto>? = null,
    val error: String = ""
)