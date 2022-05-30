package org.hariom.jetpackandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(Observer())
        Log.d("Main", "Activity onCreate method call ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Main", "Activity onRestart method call ")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Main", "Activity onPause method call ")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("Main", "Activity onRestart method call ")
    }
}