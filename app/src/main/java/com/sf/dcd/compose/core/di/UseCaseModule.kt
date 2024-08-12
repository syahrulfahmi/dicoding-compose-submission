package com.sf.dcd.compose.core.di

import com.sf.dcd.compose.core.domain.repository.MovieRepository
import com.sf.dcd.compose.core.domain.usecase.MovieUseCase
import com.sf.dcd.compose.core.domain.usecase.MovieUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideMovieUseCase(movieRepository: MovieRepository): MovieUseCase = MovieUseCaseImpl(movieRepository)

}