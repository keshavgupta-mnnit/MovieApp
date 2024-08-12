package com.atlys.movieapp.repository

import com.atlys.movieapp.models.MovieApiResponseDto

interface IMovieRepository {
    suspend fun fetchMoviesList(): MovieApiResponseDto
    suspend fun fetchMoviesListByQuery(query: String): MovieApiResponseDto
}