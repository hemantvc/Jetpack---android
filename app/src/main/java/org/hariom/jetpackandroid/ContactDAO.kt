package org.hariom.jetpackandroid

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDAO {
    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("Select * from CONTACT")
    fun getContact() : LiveData<List<Contact>>

}