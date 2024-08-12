package com.atlys.movieapp.repository

import com.atlys.movieapp.models.MovieApiResponseDto
import com.atlys.movieapp.repository.network.IMovieNetworkSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class MovieRepository @Inject constructor(private val networkSource: IMovieNetworkSource) :
    IMovieRepository {
    override suspend fun fetchMoviesList(): MovieApiResponseDto {
        return networkSource.fetchMoviesList()
    }

    override suspend fun fetchMoviesListByQuery(query: String): MovieApiResponseDto {
        return networkSource.fetchMoviesListByQuery(query)
    }

}