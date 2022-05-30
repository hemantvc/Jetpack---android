package org.hariom.jetpackandroid

import android.content.Context
import androidx.room.*

@Database(entities = [Contact::class], version = 2)
@TypeConverters(Convertors::class)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDAO() : ContactDAO

    companion object {
        @Volatile
        private var  INSTANCE: ContactDatabase? = null

        fun getDataBase(context: Context) : ContactDatabase{
            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ContactDatabase :: class.java, "contact").build()
                }
            }
            return INSTANCE!!
        }
    }
}