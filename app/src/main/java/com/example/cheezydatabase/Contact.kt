package com.example.cheezydatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "Contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val mobile:String,
    val createdDate: Date,
    val isActive:Int
)
