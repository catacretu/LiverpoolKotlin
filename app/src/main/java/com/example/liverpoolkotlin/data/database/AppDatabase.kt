package com.example.liverpoolkotlin.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.liverpoolkotlin.data.local.dao.PlayerDAO
import com.example.liverpoolkotlin.data.local.model.PlayerEntity

@Database(entities = [PlayerEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getPlayerDAO(): PlayerDAO

    companion object{
        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
           if(INSTANCE== null) {
               INSTANCE= Room.databaseBuilder(
                   context.applicationContext, AppDatabase::class.java,"Database"
               ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
           }
            return INSTANCE!!
        }
    }
}