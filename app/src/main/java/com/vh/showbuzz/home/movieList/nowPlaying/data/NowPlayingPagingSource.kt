package com.vh.showbuzz.home.movieList.nowPlaying.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.vh.showbuzz.common.network.ErrorConstant
import com.vh.showbuzz.common.network.getError
import com.vh.showbuzz.home.movieList.common.data.MovieDTO
import com.vh.showbuzz.home.movieList.common.data.MovieListApi
import retrofit2.HttpException
import java.io.IOException

class NowPlayingPagingSource(private val movieListApi: MovieListApi) : PagingSource<Int, MovieDTO>(){

    override fun getRefreshKey(state: PagingState<Int,MovieDTO>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int,MovieDTO> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = movieListApi.getNowPlayingMovies(language = "en-US", page = nextPageNumber)
            LoadResult.Page(
                data =response.results,
                prevKey = if (nextPageNumber == 1) null else nextPageNumber - 1,
                nextKey = if (response.total_pages==nextPageNumber) null else nextPageNumber + 1
            )
        }
        catch (e: HttpException) {
            Log.e("NowPlayingPagingSource:HttpException-->", e.message())
            LoadResult.Error(Exception(message = e.response()?.errorBody()?.getError() ?: ErrorConstant.ErrorParsingExp))
        } catch (e: IOException) {
            Log.e("NowPlayingPagingSource:IOException-->", "${e.message}")
            ErrorConstant.NetworkErrorMessage
            LoadResult.Error(Exception(message = ErrorConstant.NetworkErrorMessage))
        } catch (e: Exception) {
            Log.e("NowPlayingPagingSource:Exp-->", e.localizedMessage)
            LoadResult.Error(e)
        }
    }
}