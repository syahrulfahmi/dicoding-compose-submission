package com.sf.dcd.compose.core.data.source

sealed class DataResult<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : DataResult<T>(data)
    class Loading<T>(data: T? = null) : DataResult<T>(data)
    class Error<T>(message: String, data: T? = null) : DataResult<T>(data, message)
}