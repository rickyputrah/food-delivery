package com.rickyputrah.fooddelivery.data.repository

import androidx.annotation.Keep
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

sealed class ResultRepository<out T : Any> {

    class Success<out T : Any>(val data: T) : ResultRepository<T>()

    class Error(val exception: Throwable) : ResultRepository<Nothing>()
}

suspend fun <T : Any> handleRequest(requestFunc: suspend () -> T): ResultRepository<T> {
    return withContext(Dispatchers.IO) {
        try {
            ResultRepository.Success(requestFunc.invoke())
        } catch (ex: Throwable) {
            when (ex is HttpException) {
                true -> ResultRepository.Error(
                    ApiException(
                        ex.message,
                        ex is IOException,
                        ex.code()
                    )
                )
                false -> ResultRepository.Error(ApiException(ex.message, ex is IOException))
            }
        }
    }
}

@Keep
class ApiException(
    message: String? = null,
    val isNetworkError: Boolean = false,
    val errorCode: Int = 0,
    val data: String? = null
) : Exception(message)