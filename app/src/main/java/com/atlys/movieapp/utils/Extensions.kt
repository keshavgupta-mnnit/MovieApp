package com.atlys.movieapp.utils

//fun <T> toResultFlow(call: suspend () -> Response<T>?) : Flow<ApiResult<T>?> {
//
//    return flow {
//        emit(ApiResult.Loading(null, true))
//        val c = call()  /* have to initialize the call method first*/
//        c?.let {
//            try {
//                if (c.isSuccessful && c.body() != null) {
//                    c.body()?.let {
//                        emit(ApiResult.Success(it))
//                    }
//                } else {
//                    c.errorBody()?.let {
//                        emit(ApiResult.Error(it.string()))
//                    }
//                }
//            }catch (e: Exception){
//                emit(ApiResult.Error(e.toString()))
//            }
//        }
//    }.flowOn(Dispatchers.IO)
//}