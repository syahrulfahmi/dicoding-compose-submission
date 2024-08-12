package com.sf.dcd.compose.core.domain.repository

import com.sf.dcd.compose.core.data.source.remote.response.MovieResponse
import retrofit2.Response

interface MovieRepository {
    suspend fun getPopularMovie(): Response<MovieResponse.Result>
}