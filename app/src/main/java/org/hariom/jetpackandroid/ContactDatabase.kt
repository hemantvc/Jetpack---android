package org.hariom.jetpackandroid

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Contact::class], version = 3)
@TypeConverters(Convertors::class)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDAO() : ContactDAO

    companion object {

        val migration_2_3 = object : Migration( 2, 3){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }

        }

        @Volatile
        private var  INSTANCE: ContactDatabase? = null

        fun getDataBase(context: Context) : ContactDatabase{
            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ContactDatabase :: class.java, "contact")
                        .addMigrations(migration_2_3)
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}