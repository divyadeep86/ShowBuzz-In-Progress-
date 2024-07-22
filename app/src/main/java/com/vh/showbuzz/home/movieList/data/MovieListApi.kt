package com.vh.showbuzz.home.movieList.data

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieListApi {
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(@Query("language") language:String,@Query("page") page:Int): MovieListDTO

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("language") language:String,@Query("page") page:Int,@Query("sortBy") sortBy:String = "popularity.desc"): MovieListDTO

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("language") language:String,@Query("page") page:Int): MovieListDTO

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query("language") language:String,@Query("page") page:Int, @Query("release_date.gte") releaseDate:String="2024-07-20",@Query("release_date.lte") releaseDate2:String="2025-07-20"): MovieListDTO
}