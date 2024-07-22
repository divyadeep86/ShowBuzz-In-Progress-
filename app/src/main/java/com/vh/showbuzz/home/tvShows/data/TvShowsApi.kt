package com.vh.showbuzz.home.tvShows.data

import retrofit2.http.GET
import retrofit2.http.Query

interface TvShowsApi {

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("language") language:String, @Query("page") page:Int): TvShowListDTO

    @GET("tv/top_rated")
    suspend fun getTopRatedTvShows(@Query("language") language:String, @Query("page") page:Int): TvShowListDTO

}
