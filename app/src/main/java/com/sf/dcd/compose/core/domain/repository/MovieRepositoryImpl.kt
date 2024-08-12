package com.sf.dcd.compose.core.domain.repository

import com.sf.dcd.compose.core.data.source.remote.network.movie.MovieDataSource
import com.sf.dcd.compose.core.data.source.remote.response.MovieResponse
import com.sf.dcd.compose.core.util.suspendDataResult
import retrofit2.Response


class MovieRepositoryImpl(
    private val dataSource: MovieDataSource,
) : MovieRepository {

    override suspend fun getPopularMovie(): Response<MovieResponse.Result> {
        return suspendDataResult { dataSource.getPopularMovie() }
    }
}
