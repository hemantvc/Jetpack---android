package com.cheezycode.mvvmdemo

import androidx.lifecycle.LiveData
import org.hariom.jetpackandroid.Quote

class QuoteRepository(private val quoteDao: QuoteDao) {

    fun getQuotes(): LiveData<List<Quote>>{
        return quoteDao.getQuotes()
    }

    suspend fun insertQuote(quote: Quote){
        quoteDao.insertQuote(quote)
    }
}