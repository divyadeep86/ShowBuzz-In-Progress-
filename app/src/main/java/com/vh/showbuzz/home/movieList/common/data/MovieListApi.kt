package com.vh.showbuzz.home.movieList.common.data

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieListApi {
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(@Query("language") language:String,@Query("page") page:Int): MovieListDTO

    @GET("movie/popular")
    suspend fun getPopularMovies(): MovieListDTO

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(): MovieListDTO

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(): MovieListDTO
}