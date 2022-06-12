package org.hariom.jetpackandroid.api

import org.hariom.jetpackandroid.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

    @GET("/quotess")
    suspend fun getQuotes(@Query("page") page: Int) : Response<QuoteList>

}