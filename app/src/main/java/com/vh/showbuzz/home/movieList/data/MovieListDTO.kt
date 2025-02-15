package com.vh.showbuzz.home.movieList.data

import kotlinx.serialization.Serializable

@Serializable
data class MovieListDTO(
    val dates: Dates?=null,
    val page: Int,
    val results: List<MovieDTO>,
    val total_pages: Int,
    val total_results: Int
)
@Serializable
data class Dates(
    val maximum: String,
    val minimum: String
)
@Serializable
data class MovieDTO(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)