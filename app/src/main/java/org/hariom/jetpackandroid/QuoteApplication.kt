package org.hariom.jetpackandroid

import android.app.Application
import org.hariom.jetpackandroid.api.QuoteService
import org.hariom.jetpackandroid.api.RetrofitHelper
import org.hariom.jetpackandroid.db.QuoteDatabase
import org.hariom.jetpackandroid.repository.QuoteRepository

class QuoteApplication : Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService, database, applicationContext)
    }
}