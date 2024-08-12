package com.sf.dcd.compose.core.domain.usecase

import com.sf.dcd.compose.core.data.mapper.MovieMapper
import com.sf.dcd.compose.core.data.source.DataResult
import com.sf.dcd.compose.core.domain.model.MovieDomain
import com.sf.dcd.compose.core.domain.repository.MovieRepository
import com.sf.dcd.compose.core.util.BaseCall
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    suspend fun getMovie(): Flow<DataResult<MovieDomain.Result>>
}

class MovieUseCaseImpl(private val movieRepository: MovieRepository) : MovieUseCase, BaseCall() {
    override suspend fun getMovie(): Flow<DataResult<MovieDomain.Result>> {
        return call(mapper = MovieMapper()) {
            movieRepository.getPopularMovie()
        }
    }
}