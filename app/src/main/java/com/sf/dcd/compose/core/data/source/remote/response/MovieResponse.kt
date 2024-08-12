package com.sf.dcd.compose.core.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


class MovieResponse {

    @Parcelize
    data class Result(
        @SerializedName("page") val page: Int? = 0,
        @SerializedName("results") val results: List<Data> = listOf(),
        @SerializedName("total_pages") val totalPages: Int? = 0,
        @SerializedName("total_results") val totalResults: Int? = 0
    ) : Parcelable

    @Parcelize
    data class Data(
        @SerializedName("adult") val adult: Boolean?,
        @SerializedName("backdrop_path") val backdropPath: String?,
        @SerializedName("genre_ids") val genreIds: List<Int>,
        @SerializedName("id") val id: Int?,
        @SerializedName("original_language") val originalLanguage: String?,
        @SerializedName("original_title") val originalTitle: String?,
        @SerializedName("overview") val overview: String?,
        @SerializedName("popularity") val popularity: Double?,
        @SerializedName("poster_path") val posterPath: String?,
        @SerializedName("release_date") val releaseDate: String?,
        @SerializedName("title") val title: String?,
        @SerializedName("video") val video: Boolean?,
        @SerializedName("vote_average") val voteAverage: Double?,
        @SerializedName("vote_count") val voteCount: Int?
    ) : Parcelable

}