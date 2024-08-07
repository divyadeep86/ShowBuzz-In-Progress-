package com.vh.showbuzz.home.movieList.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.vh.showbuzz.common.network.ErrorConstant
import com.vh.showbuzz.common.network.getError
import com.vh.showbuzz.common.utils.getCurrentDate
import com.vh.showbuzz.common.utils.getCurrentDatePlusYearString
import com.vh.showbuzz.common.utils.toDate
import retrofit2.HttpException
import java.io.IOException
import java.time.LocalDate

class UpcomingMoviePagingSource(
    private val movieListApi: MovieListApi, private val movieType: MovieType
) : PagingSource<Int, MovieDTO>() {

    override fun getRefreshKey(state: PagingState<Int, MovieDTO>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieDTO> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = when (movieType) {
                MovieType.NOW_PLAYING -> movieListApi.getNowPlayingMovies(
                    language = "en-US", page = nextPageNumber
                )

                MovieType.POPULAR -> movieListApi.getPopularMovies(
                    language = "en-US", page = nextPageNumber
                )

                MovieType.TOP_RATED -> movieListApi.getTopRatedMovies(
                    language = "en-US", page = nextPageNumber
                )

                MovieType.UPCOMING -> movieListApi.getUpcomingMovies(
                    language = "en-US", page = nextPageNumber, releaseDateLte = getCurrentDate().toString(), releaseDateGte = getCurrentDatePlusYearString(1)
                )
            }


            LoadResult.Page(
                data = response.results,
                prevKey = if (nextPageNumber == 1) null else nextPageNumber - 1,
                nextKey = if (response.total_pages == nextPageNumber) null else nextPageNumber + 1
            )
        } catch (e: HttpException) {
            Log.e("MovieListPaging:${movieType.name}:HttpException-->", e.message())
            LoadResult.Error(
                java.lang.Exception(
                    e.response()?.errorBody()?.getError() ?: ErrorConstant.ErrorParsingExp
                )
            )
        } catch (e: IOException) {
            Log.e("MovieListPaging:${movieType.name}:IOException-->", "${e.message}")
            ErrorConstant.NetworkErrorMessage
            LoadResult.Error(java.lang.Exception(ErrorConstant.NetworkErrorMessage))
        } catch (e: Exception) {
            Log.e("MovieListPaging:${movieType.name}:Exp-->", e.localizedMessage)
            LoadResult.Error(e)
        }
    }
}