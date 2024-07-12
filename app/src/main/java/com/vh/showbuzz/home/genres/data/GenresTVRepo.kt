package com.vh.showbuzz.home.genres.data

import android.util.Log
import com.vh.showbuzz.common.network.ErrorConstant
import com.vh.showbuzz.common.network.ResponseHandler
import com.vh.showbuzz.common.network.getError
import retrofit2.HttpException
import java.io.IOException

class GenresTVRepo(private val genresApi: GenresApi) {

    suspend fun getGenresList(): ResponseHandler<GeneresDTO> {
        return try {
            ResponseHandler.Success(genresApi.getGenresTV())
        } catch (e: HttpException) {
            Log.e("${this.javaClass.name}:HttpException-->", e.message())
            // HTTP exception handling: Wrap message in Failure
            ResponseHandler.Failure(
                message = e.response()?.errorBody()?.getError() ?: ErrorConstant.ErrorParsingExp
            )
        } catch (e: IOException) {
            Log.e("\"${this.javaClass.name}:IOException-->", "${e.message}")
            // Network/IO exception handling: Wrap network error message in Failure
            ResponseHandler.Failure(ErrorConstant.NetworkErrorMessage)
        } catch (e: Exception) {
            e.localizedMessage?.let { Log.e("\"${this.javaClass.name}:Exp-->", it)
                ResponseHandler.Failure(it)
            }?: ResponseHandler.Failure(ErrorConstant.UnknownErrorMessage)
            // General exception handling: Wrap unknown error message in Failure

        }
    }
}