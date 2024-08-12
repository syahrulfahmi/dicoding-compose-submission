package com.sf.dcd.compose.core.data.mapper

import com.sf.dcd.compose.core.data.source.remote.response.MovieResponse
import com.sf.dcd.compose.core.domain.model.MovieDomain
import com.sf.dcd.compose.core.util.Mapper

class MovieMapper : Mapper<MovieResponse.Result, MovieDomain.Result> {
    override fun map(input: MovieResponse.Result): MovieDomain.Result {
        return MovieDomain.Result(
            page = input.page,
            results = input.results.mapToResult(),
            totalPages = input.totalPages,
            totalResults = input.totalResults
        )
    }

    private fun List<MovieResponse.Data>.mapToResult(): List<MovieDomain.Data> {
        return this.map {
            MovieDomain.Data(
                adult = it.adult,
                backdropPath = it.backdropPath,
                genreIds = it.genreIds.map { it },
                id = it.id,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                title = it.title,
                video = it.video,
                voteCount = it.voteCount,
                voteAverage = it.voteAverage
            )
        }
    }
}