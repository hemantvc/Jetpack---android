package org.hariom.jetpackandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.hariom.jetpackandroid.repository.Response
import org.hariom.jetpackandroid.viewmodel.MainViewModel
import org.hariom.jetpackandroid.viewmodel.MainViewModelFactory

/**
 * API Response handling
 * https://youtu.be/IUEJwwD2z70
 */
class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = (application as QuoteApplication).quoteRepository

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {
            when(it){
                is Response.Loading -> {}
                is Response.Success -> {
                    it.data?.let {
                        Toast.makeText(this@MainActivity, it.results.size.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
                is Response.Error -> {
                    Toast.makeText(this@MainActivity, "Some error occurred.", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}