package com.example.githubuserfavorite.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserFavoriteDao {
    @Insert
    fun addToFavorite(userFavorite: UserFavorite)

    @Query("SELECT * FROM user_favorite")
    fun getUserFavorite(): LiveData<List<UserFavorite>>

    @Query("SELECT count(*) FROM user_favorite WHERE user_favorite.id = :id")
    fun checkFavorite(id: Int): Int

    @Query("DELETE FROM user_favorite WHERE user_favorite.id = :id")
    fun removeFromUser(id: Int): Int
}