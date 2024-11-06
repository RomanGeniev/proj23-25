package com.example.proj23_25

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 2, entities = [BookEntity::class]
)
abstract class MainDb: RoomDatabase() {
    abstract fun getBookDao(): IDao

    companion object{
        fun getDb(context:Context) : MainDb {
            return Room.databaseBuilder(context.applicationContext,MainDb::class.java,"test_db").build()
        }
    }
}