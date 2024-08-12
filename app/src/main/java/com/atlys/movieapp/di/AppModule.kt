package com.atlys.movieapp.di

import com.atlys.movieapp.repository.IMovieRepository
import com.atlys.movieapp.repository.MovieRepository
import com.atlys.movieapp.repository.network.IMovieNetworkSource
import com.atlys.movieapp.repository.network.MovieNetworkSource
import com.atlys.movieapp.repository.network.api.MovieApi
import com.atlys.movieapp.utils.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideCoinApi(): MovieApi {
        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieNetworkSource(movieApi: MovieApi): IMovieNetworkSource {
        return MovieNetworkSource(movieApi)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(networkSource: IMovieNetworkSource): IMovieRepository {
        return MovieRepository(networkSource)
    }
}