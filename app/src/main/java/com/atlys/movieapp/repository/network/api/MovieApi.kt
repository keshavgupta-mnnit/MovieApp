package com.atlys.movieapp.repository.network.api

import com.atlys.movieapp.models.MovieApiResponseDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.QueryMap

interface MovieApi {
    @GET("/3/trending/movie/day")
    suspend fun fetchMovieList(
        @HeaderMap headers: Map<String, String>, @QueryMap queryMap: Map<String, String>
    ): MovieApiResponseDto

    @GET("/3/search/movie")
    suspend fun fetchMovieListBySearch(
        @HeaderMap headers: Map<String, String>, @QueryMap queryMap: Map<String, String>
    ): MovieApiResponseDto
}