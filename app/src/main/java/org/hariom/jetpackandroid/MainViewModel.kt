package org.hariom.jetpackandroid

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

/**
 * Example taken from below view
 * https://www.youtube.com/watch?v=HfkyXuZdD_c&list=PLRKyZvuMYSIO0jLgj8g6sADnD0IBaWaw2&index=5
 */
class MainViewModel(val context: Context) : ViewModel() {
    private var quoteList : Array<Quote> = emptyArray()
    private var index : Int =  0

    init {
        quoteList = loadQoutesFromAssets()
    }

    private fun loadQoutesFromAssets(): Array<Quote> {
        val inputStream = context.assets.open("quotes.json")
        val size : Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()

        return gson.fromJson(json,Array<Quote>::class.java)
    }

    fun getQoute() = quoteList[index]

    fun nextQoute() = quoteList[++index]

    fun previousQoute() = quoteList[--index]

}