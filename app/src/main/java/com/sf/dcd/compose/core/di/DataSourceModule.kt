package com.sf.dcd.compose.core.di

import com.sf.dcd.compose.core.data.source.remote.network.ApiConfig
import com.sf.dcd.compose.core.data.source.remote.network.movie.MovieDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module()
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun provideMovieDataSource(retrofit: Retrofit): MovieDataSource = ApiConfig.getApiDataSource(retrofit)
}