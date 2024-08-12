package com.sf.dcd.compose.core.data.source.remote.network.movie

import com.sf.dcd.compose.BuildConfig
import com.sf.dcd.compose.core.data.source.remote.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDataSource {

    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Response<MovieResponse.Result>
}