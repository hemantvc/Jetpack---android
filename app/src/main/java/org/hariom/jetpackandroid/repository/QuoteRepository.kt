package org.hariom.jetpackandroid.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.hariom.jetpackandroid.api.QuoteService
import org.hariom.jetpackandroid.db.QuoteDatabase
import org.hariom.jetpackandroid.models.QuoteList
import org.hariom.jetpackandroid.utils.NetworkUtils

class QuoteRepository(
    private val quoteService: QuoteService,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context
) {

    private val quotesLiveData = MutableLiveData<Response<QuoteList>>()

    val quotes: LiveData<Response<QuoteList>>
    get() = quotesLiveData

    suspend fun getQuotes(page: Int){

        if(NetworkUtils.isInternetAvailable(applicationContext)){
            try {
                val result = quoteService.getQuotes(page)
                if(result?.body() != null){
                    quoteDatabase.quoteDao().addQuotes(result.body()!!.results)
                    quotesLiveData.postValue(Response.Success(result.body()))
                } else {
                    quotesLiveData.postValue(Response.Error("API Error."))
                }
            }catch (e : Exception){
                quotesLiveData.postValue(Response.Error(e.message.toString()))
            }

        }
        else{
            val quotes = quoteDatabase.quoteDao().getQuotes()
            val quoteList = QuoteList(1,1,1,quotes, 1, 1)
            quotesLiveData.postValue(Response.Success(quoteList))
        }

    }
    
    suspend fun getQuotesBackground(){
        val randomNumber = (Math.random() * 10).toInt()
        val result  = quoteService.getQuotes(randomNumber)
        if(result?.body() != null){
            quoteDatabase.quoteDao().addQuotes(result.body()!!.results)
        }
    }
}
