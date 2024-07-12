package com.vh.showbuzz.home.genres.data

import retrofit2.http.GET

interface GenresApi {

    @GET("genre/movie/list")
    suspend fun getGenresMovies(): GeneresDTO

    @GET("genre/tv/list")
    suspend fun getGenresTV(): GeneresDTO
}