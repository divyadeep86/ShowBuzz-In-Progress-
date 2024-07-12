package com.vh.showbuzz.home.genres.domain

import com.vh.showbuzz.common.network.ResponseHandler
import com.vh.showbuzz.common.state.DataState
import com.vh.showbuzz.home.genres.data.GenresMoviesRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GenresMoviesUseCase(val genresMoviesRepo: GenresMoviesRepo) {

    fun getGenresMovies():Flow<DataState<List<String>>> = flow {
        emit(DataState.loading(isLoading = true))
        when(val response = genresMoviesRepo.getGenresMovies()){
            is ResponseHandler.Success -> {
                val genres = response.data.genres.map { it.name }
                emit(DataState.success(genres))
            }
            is ResponseHandler.Failure-> {
                emit(DataState.error(response.message))
            }
        }

    }

}