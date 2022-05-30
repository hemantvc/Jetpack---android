package org.hariom.jetpackandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(applicationContext,
            ContactDatabase :: class.java, "contact").build()

        GlobalScope.launch {
            database.contactDAO().insertContact(Contact(0,"Sid","9033762473"))
        }
    }
}