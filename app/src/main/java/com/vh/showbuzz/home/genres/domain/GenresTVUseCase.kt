package com.vh.showbuzz.home.genres.domain

import com.vh.showbuzz.common.network.ResponseHandler
import com.vh.showbuzz.common.state.DataState
import com.vh.showbuzz.home.genres.data.GenresTVRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GenresTVUseCase(private val genresTVRepo: GenresTVRepo) {

    fun getGenresTV(): Flow<DataState<List<String>>> = flow {
        emit(DataState.loading(isLoading = true))
        when(val response = genresTVRepo.getGenresList()){
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