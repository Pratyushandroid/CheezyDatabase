package com.example.cheezydatabase

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [Contact::class], version = 2)
@TypeConverters(Converters::class)
abstract class ContactDatabase:RoomDatabase() {
    abstract fun ContactDao(): Dao


    companion object{

        val migration_1_2 = object :Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }

        }
        @Volatile
       private var Instance :ContactDatabase? = null


        fun getDatabase(context: Context) : ContactDatabase {

            if (Instance == null) {

                synchronized(this) {
                    Instance = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "ContactDB"
                    )
                        .addMigrations(migration_1_2)
                        .build()
                }
            }
            return Instance!!
        }
    }
}