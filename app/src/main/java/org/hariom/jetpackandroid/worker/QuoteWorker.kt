package org.hariom.jetpackandroid.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.hariom.jetpackandroid.QuoteApplication

class QuoteWorker (private val context: Context, params : WorkerParameters) : Worker(context, params){
    override fun doWork(): Result {
        Log.d("QuoteWorker", "Worker called!")
         val repository = (context as QuoteApplication).quoteRepository
         CoroutineScope(Dispatchers.IO).launch {
             repository.getQuotesBackground()
         }
        return Result.success()
    }
}