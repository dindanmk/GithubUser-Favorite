package com.example.githubuserfavorite.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [UserFavorite::class],
    version = 1
)
abstract class UserDatabase: RoomDatabase() {
    companion object{
        @Volatile
        var INSTANCE : UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase?{
            if (INSTANCE==null){
                synchronized(UserDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "user database").build()
                }
            }
            return INSTANCE
        }
    }

    abstract fun userFavoriteDao(): UserFavoriteDao
}