package org.hariom.jetpackandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Example taken from below view
 * https://www.youtube.com/watch?v=HfkyXuZdD_c&list=PLRKyZvuMYSIO0jLgj8g6sADnD0IBaWaw2&index=5
 */
class MainViewModel() : ViewModel() {

    private val factsLiveDataObject = MutableLiveData<String> ("This is a fact")

    val factsLiveData : LiveData<String>
           get() =  factsLiveDataObject

    fun updateLiveData(){
        factsLiveDataObject.value = "Android facts. Hariom"
    }
}