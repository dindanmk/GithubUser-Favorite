package com.example.githubuserfavorite.data.api

import com.example.githubuserfavorite.data.model.DetailUserResponse
import com.example.githubuserfavorite.data.model.User
import com.example.githubuserfavorite.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("/users/{username}")
    @Headers("Authorization: token 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")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}