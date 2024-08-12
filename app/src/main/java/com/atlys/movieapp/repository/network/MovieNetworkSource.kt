package com.atlys.movieapp.repository.network

import com.atlys.movieapp.models.MovieApiResponseDto
import com.atlys.movieapp.repository.network.api.MovieApi
import com.atlys.movieapp.utils.ApiConstants
import com.atlys.movieapp.utils.AppUtils
import javax.inject.Inject

class MovieNetworkSource @Inject constructor(private val movieApi: MovieApi) : IMovieNetworkSource {
    override suspend fun fetchMoviesList(): MovieApiResponseDto {
        val queryParams = mutableMapOf<String, String>()
        queryParams[ApiConstants.KEY_LANGUAGE] = ApiConstants.VALUE_LANGUAGE

        return movieApi.fetchMovieList(getCommonHeader(), queryParams)
    }

    override suspend fun fetchMoviesListByQuery(query: String): MovieApiResponseDto {
        val queryParams = mutableMapOf<String, String>()
        queryParams[ApiConstants.KEY_LANGUAGE] = ApiConstants.VALUE_LANGUAGE
        queryParams[ApiConstants.KEY_QUERY] = query

        return movieApi.fetchMovieListBySearch(getCommonHeader(), queryParams)
    }

    private fun getCommonHeader(): Map<String, String> {
        val apiKey = AppUtils.getApiKey()
        val headers = mutableMapOf<String, String>()
        headers[ApiConstants.KEY_AUTHORIZATION] = "Bearer $apiKey"
        headers[ApiConstants.KEY_ACCEPT] = ApiConstants.APPLICATION_JSON
        return headers
    }
}