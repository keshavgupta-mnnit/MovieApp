package com.atlys.movieapp.usecase

import com.atlys.movieapp.models.MovieApiResponseDto
import com.atlys.movieapp.repository.IMovieRepository
import com.atlys.movieapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(private val repository: IMovieRepository) {
    operator fun invoke(): Flow<Resource<MovieApiResponseDto>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repository.fetchMoviesList()))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected Error Occurred"))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: "Couldn't reach server. Check Internet connection"
                )
            )
        }
    }

    fun getMovieListByQuery(query: String): Flow<Resource<MovieApiResponseDto>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repository.fetchMoviesListByQuery(query)))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected Error Occurred"))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: "Couldn't reach server. Check Internet connection"
                )
            )
        }
    }
}