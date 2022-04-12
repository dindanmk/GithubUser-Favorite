package com.example.githubuserfavorite.ui.detail

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.githubuserfavorite.data.api.RetrofitClient
import com.example.githubuserfavorite.data.model.DetailUserResponse
import com.example.githubuserfavorite.data.room.UserDatabase
import com.example.githubuserfavorite.data.room.UserFavorite
import com.example.githubuserfavorite.data.room.UserFavoriteDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserViewModel (application: Application): AndroidViewModel(application){
    val user = MutableLiveData<DetailUserResponse>()

    private var userDb: UserDatabase?
    private var userDao: UserFavoriteDao?

    init{
        userDb = UserDatabase.getDatabase(application)
        userDao = userDb?.userFavoriteDao()
    }

    fun setUserDetail(username: String){
        RetrofitClient.apiInstance
            .getUserDetail(username)
            .enqueue(object: Callback<DetailUserResponse>{
                override fun onResponse(
                    call: Call<DetailUserResponse>,
                    response: Response<DetailUserResponse>
                ) {
                    if (response.isSuccessful){
                        user.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<DetailUserResponse>, t: Throwable) {
                    Log.d("Failure", t.message!!)
                }
            })
    }

    fun getUserDetail(): LiveData<DetailUserResponse>{
        return user
    }

    fun addToFavorite(username: String, id: Int, avatarUrl: String){
        CoroutineScope(Dispatchers.IO).launch {
            val user = UserFavorite(
                username,
                id,
                avatarUrl
            )

            userDao?.addToFavorite(user)
        }
    }

    fun checkFavorite(id: Int) = userDao?.checkFavorite(id)

    fun removeFromUser(id: Int){
        CoroutineScope(Dispatchers.IO).launch {
            userDao?.removeFromUser(id)
        }
    }
}