package com.vh.showbuzz.home.movieList.nowPlaying.domain

import com.vh.showbuzz.home.movieList.common.data.MovieDTO

data class Movie(
    val adult: Boolean,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val popularity: Double,
    val release_date: String,
    val title: String,
    val poster_path: String,
    val vote_average: Double,
    val vote_count: Int
){

    companion object{
        fun getPreviewData() = Movie(
            adult = false,
            genre_ids = listOf(1,2,3),
            id = 1,
            original_language = "en",
            original_title = "Original Title",
            popularity = 1.0,
            release_date = "2021-10-10",
            title = "Title",
            poster_path = "poster_path",
            vote_average = 1.0,
            vote_count = 1
        )
    }
}
fun MovieDTO.toMovie() = Movie(
    adult = adult,
    genre_ids = genre_ids,
    id = id,
    original_language = original_language,
    original_title = original_title,
    popularity = popularity,
    release_date = release_date,
    title = title,
    vote_average = vote_average,
    vote_count = vote_count,
    poster_path = poster_path
)
