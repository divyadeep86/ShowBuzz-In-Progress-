package com.vh.showbuzz.home.movieList.domain

import com.vh.showbuzz.common.utils.convertNumberToDouble
import com.vh.showbuzz.common.utils.extractYear
import com.vh.showbuzz.common.utils.toPercentage
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
    val release_year:String,
    val title: String,
    val overview:String,
    val poster_path: String,
    val scorePercentage:Int,
    val prgress:Float,
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
            release_year = "2024",
            title = "Title",
            poster_path = "poster_path",
            scorePercentage = 0,
            prgress = 0f,
            overview = "Moview overview"
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
    release_year = release_date.extractYear().toString(),
    title = title,
    overview = overview,
    scorePercentage = vote_average.toPercentage(),
    prgress = vote_average.convertNumberToDouble().toFloat(),
    poster_path = "https://image.tmdb.org/t/p/original/$poster_path"
)
