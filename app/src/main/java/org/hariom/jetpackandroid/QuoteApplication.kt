package org.hariom.jetpackandroid

import android.app.Application
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import org.hariom.jetpackandroid.api.QuoteService
import org.hariom.jetpackandroid.api.RetrofitHelper
import org.hariom.jetpackandroid.db.QuoteDatabase
import org.hariom.jetpackandroid.repository.QuoteRepository
import org.hariom.jetpackandroid.worker.QuoteWorker
import java.util.concurrent.TimeUnit

class QuoteApplication : Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
        setUpWorker()
    }

    private fun setUpWorker() {
        val constraint = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        val workerRequest = PeriodicWorkRequest.Builder(QuoteWorker::class.java,15, TimeUnit.MINUTES).setConstraints(constraint).build()
        WorkManager.getInstance(this).enqueue(workerRequest)


    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService, database, applicationContext)
    }
}