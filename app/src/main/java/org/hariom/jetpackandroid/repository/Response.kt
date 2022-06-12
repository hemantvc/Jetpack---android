package org.hariom.jetpackandroid.repository

//sealed class Response(){
//    class Loading : Response(),
//    class Success(val quoteList: QuoteList) : Response(),
//    class Error(val errorMessage : String) : Response()
//}

sealed class Response<T>(val data : T? = null, val errorMessage: String? = null){
    class Loading<T> : Response<T>()
    class Success<T>(data: T? = null) : Response<T>(data = data)
    class Error<T>(errorMessage: String) : Response<T>(errorMessage = errorMessage)
}