package org.hariom.jetpackandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.hariom.jetpackandroid.models.QuoteList
import org.hariom.jetpackandroid.repository.QuoteRepository
import org.hariom.jetpackandroid.repository.Response

class MainViewModel(private val repository: QuoteRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getQuotes(1)
        }
    }

    val quotes : LiveData<Response<QuoteList>>
    get() = repository.quotes
}