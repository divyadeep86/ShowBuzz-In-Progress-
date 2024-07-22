package com.vh.showbuzz.home.movieList.domain

import com.vh.showbuzz.home.movieList.data.MovieDTO
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val adult: Boolean,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val popularity: String,
    val release_date: String,
    val title: String,
    val poster_path: String,
    val vote_average: String,
    val vote_count: String
){

    companion object{
        fun getPreviewData() = Movie(
            adult = false,
            genre_ids = listOf(1,2,3),
            id = 1,
            original_language = "en",
            original_title = "Original Title",
            popularity = "1.0",
            release_date = "2021-10-10",
            title = "Title",
            poster_path = "poster_path",
            vote_average = "1.0",
            vote_count = "1"
        )
    }
}
fun MovieDTO.toMovie() = Movie(
    adult = adult,
    genre_ids = genre_ids,
    id = id,
    original_language = original_language,
    original_title = original_title,
    popularity = popularity.toString(),
    release_date = release_date,
    title = title,
    vote_average = vote_average.toString(),
    vote_count = vote_count.toString(),
    poster_path = "https://image.tmdb.org/t/p/original/$poster_path"
)
