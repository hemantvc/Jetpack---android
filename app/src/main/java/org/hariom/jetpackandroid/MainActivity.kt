package org.hariom.jetpackandroid

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    private val tvFactText : TextView
        get() = findViewById(R.id.tvFactText)
    private val btnUpdate: Button
        get() = findViewById(R.id.btnUpdate)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.factsLiveData.observe(this, Observer {
            // Code execute
            tvFactText.text = it
        })

        btnUpdate.setOnClickListener{
            mainViewModel.updateLiveData()
        }

    }


}