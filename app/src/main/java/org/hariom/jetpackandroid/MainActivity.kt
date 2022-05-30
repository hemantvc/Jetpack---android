package org.hariom.jetpackandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/***
 * https://www.youtube.com/watch?v=yPL13Iwy6oM&list=PLRKyZvuMYSIO0jLgj8g6sADnD0IBaWaw2&index=10
 */
class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = ContactDatabase.getDataBase(this)


        GlobalScope.launch {
            database.contactDAO().insertContact(Contact(0,"Sid","9033762473"))
        }


    }

    fun getData(view: View) {
        database.contactDAO().getContact().observe(this, Observer {
            Log.d("database data", "getData: $it")
        })
    }
}