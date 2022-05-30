package org.hariom.jetpackandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * https://www.youtube.com/watch?v=QsilZEC-cOs&list=PLRKyZvuMYSIO0jLgj8g6sADnD0IBaWaw2&index=16
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.rvProgrammingLIst)

        val adapter = ProgrammingAdapter()

        val p1 = ProgrammingItem(1,"P", "Python")
        val p2 = ProgrammingItem(2,"S", "Sql")
        val p3 = ProgrammingItem(3,"D", "Dart")

        adapter.submitList(listOf(p1,p2,p3))

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed(Runnable {

            val p4 = ProgrammingItem(3,"D", "Dart")
            val p5 = ProgrammingItem(4,"A", "Android")
            val p6 = ProgrammingItem(5,"R", "Rust")

            adapter.submitList(listOf(p4,p5,p6))

        }, 4000)

    }
}