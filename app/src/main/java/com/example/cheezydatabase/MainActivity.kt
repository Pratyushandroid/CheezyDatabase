package com.example.cheezydatabase


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var database: ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//
//        database = Room.databaseBuilder(
//            applicationContext,
//            ContactDatabase::class.java,
//            "ContactDB"
//        ).build()

        database = ContactDatabase.getDatabase(this)

        GlobalScope.launch {
            database.ContactDao().insertContact(Contact(0,"Anuj","7897781973", Date(),1))
        }

    }

    fun getData(view: View) {
        database.ContactDao().getContact().observe(this, Observer {
            Log.d("Pratyush", it.toString())
        })
    }
}