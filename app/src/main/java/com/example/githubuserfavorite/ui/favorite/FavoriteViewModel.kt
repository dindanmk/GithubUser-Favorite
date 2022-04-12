package com.example.githubuserfavorite.ui.favorite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.githubuserfavorite.data.room.UserDatabase
import com.example.githubuserfavorite.data.room.UserFavorite
import com.example.githubuserfavorite.data.room.UserFavoriteDao

class FavoriteViewModel(application: Application): AndroidViewModel(application) {
    private var userDb: UserDatabase?
    private var userDao: UserFavoriteDao?

    init {
        userDb = UserDatabase.getDatabase(application)
        userDao = userDb?.userFavoriteDao()
    }

    fun getUserFavorite(): LiveData<List<UserFavorite>>?{
        return userDao?.getUserFavorite()
    }
}