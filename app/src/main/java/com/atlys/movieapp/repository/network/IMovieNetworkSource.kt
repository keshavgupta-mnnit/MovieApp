package com.atlys.movieapp.repository.network

import com.atlys.movieapp.models.MovieApiResponseDto
import kotlinx.coroutines.flow.Flow

interface IMovieNetworkSource {
    suspend fun fetchMoviesList(): MovieApiResponseDto
    suspend fun fetchMoviesListByQuery(query: String): MovieApiResponseDto
}