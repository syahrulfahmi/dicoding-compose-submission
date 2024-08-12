package com.sf.dcd.compose.core.util

import com.sf.dcd.compose.core.data.source.DataResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Response

abstract class BaseCall {

    /**
     * @param [R] [is ResponseType]
     */

    @Suppress("UNCHECKED_CAST")
    private fun <M : Mapper<I, O>, I : Any, O : Any> dataToDomainMapper(mapper: M, data: Any): O {
        return mapper.map(data as I)
    }

    suspend fun <R, O> call(
        mapper: Mapper<R, O>,
        call: suspend () -> Response<R>
    ) : Flow<DataResult<O>> = flow {
        emit(DataResult.Loading(null))
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null){
                    val dataMapper = mapper.map(body)
                    emit(DataResult.Success(dataMapper))
                }
            } else {
                val errorBody = response.errorBody()?.string().orEmpty()
                val message = JSONObject(errorBody).getString("message")
                emit(DataResult.Error(message))
            }
        } catch (e: Exception) {
            emit(DataResult.Error(e.message.orEmpty()))
        }
    }
}

suspend fun <T> suspendDataResult(request: suspend () -> Response<T>): Response<T> {
    return withContext(Dispatchers.IO) { request.invoke() }
}