package com.vh.showbuzz.home.tvShows.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.vh.showbuzz.common.network.ErrorConstant
import com.vh.showbuzz.common.network.getError
import retrofit2.HttpException
import java.io.IOException

class TvShowsPagingSource(private val tvShowsApi: TvShowsApi,private val tvShowType: TvShowType):PagingSource<Int,TVShowDTO>() {

    override fun getRefreshKey(state: PagingState<Int, TVShowDTO>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TVShowDTO> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = when(tvShowType){
                TvShowType.POPULAR -> tvShowsApi.getPopularTvShows(language = "en-US", page = nextPageNumber)
                TvShowType.TOP_RATED -> tvShowsApi.getTopRatedTvShows(language = "en-US", page = nextPageNumber)
            }
            LoadResult.Page(
                data =response.results,
                prevKey = if (nextPageNumber == 1) null else nextPageNumber - 1,
                nextKey = if (response.total_pages==nextPageNumber) null else nextPageNumber + 1
            )
        }
        catch (e: HttpException) {
            Log.e("TvShowsPagingSource:${tvShowType.name}:HttpException-->", e.message())
            LoadResult.Error(java.lang.Exception( e.response()?.errorBody()?.getError() ?: ErrorConstant.ErrorParsingExp))
        } catch (e: IOException) {
            Log.e("TvShowsPagingSource:${tvShowType.name}:IOException-->", "${e.message}")
            ErrorConstant.NetworkErrorMessage
            LoadResult.Error(java.lang.Exception( ErrorConstant.NetworkErrorMessage))
        } catch (e: Exception) {
            Log.e("TvShowsPagingSource:${tvShowType.name}:Exp-->", e.localizedMessage)
            LoadResult.Error(e)
        }
    }
}

enum class TvShowType {
    POPULAR,
    TOP_RATED
}