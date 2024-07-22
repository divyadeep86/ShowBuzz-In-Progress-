package com.vh.showbuzz.home.tvShows.domain

import com.vh.showbuzz.home.tvShows.data.TVShowDTO
import kotlinx.serialization.Serializable

@Serializable
data class TvShow(
    val adult: Boolean,
    val backdrop_path: String,
    val first_air_date: String,
    val genre_ids: List<String>,
    val id: String,
    val name: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: String,
    val poster_path: String,
    val vote_average: String,
    val vote_count: String
)

fun TVShowDTO.toTvShow(): TvShow {
    return TvShow(
        adult = adult,
        backdrop_path = backdrop_path?:"",
        first_air_date = first_air_date,
        genre_ids = genre_ids.map { it.toString() },
        id = id.toString(),
        name = name,
        origin_country = origin_country,
        original_language = original_language,
        original_name = original_name,
        overview = overview,
        popularity = popularity.toString(),
        poster_path = poster_path,
        vote_average = vote_average.toString(),
        vote_count = vote_count.toString()
    )
}
