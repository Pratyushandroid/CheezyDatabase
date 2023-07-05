package com.example.cheezydatabase

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@androidx.room.Dao
interface Dao {
    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

   @Delete
   suspend fun deleteContact(contact: Contact)

   @Query("SELECT * FROM Contact")
   fun getContact():LiveData<List<Contact>>

}