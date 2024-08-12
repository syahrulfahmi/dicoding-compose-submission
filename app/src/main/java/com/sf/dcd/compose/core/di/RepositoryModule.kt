package com.sf.dcd.compose.core.di

import com.sf.dcd.compose.core.data.source.remote.network.movie.MovieDataSource
import com.sf.dcd.compose.core.domain.repository.MovieRepository
import com.sf.dcd.compose.core.domain.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(movieDataSource: MovieDataSource): MovieRepository = MovieRepositoryImpl(movieDataSource)

}