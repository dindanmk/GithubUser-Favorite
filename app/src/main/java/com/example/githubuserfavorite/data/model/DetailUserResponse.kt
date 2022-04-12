package com.example.githubuserfavorite.data.model

import com.google.gson.annotations.SerializedName

class DetailUserResponse(
    @field:SerializedName("login")
    val login: String?,

    @field:SerializedName("id")
    val id: Int?,

    @field:SerializedName("avatar_url")
    val avatar_url: String?,

    @field:SerializedName("followers")
    val followers: Int?,

    @field:SerializedName("following")
    val following: Int?,

    @field:SerializedName("name")
    val name: String?,

    @field:SerializedName("public_repos")
    val repository: Int?,

    @field:SerializedName("company")
    val company: String?,

    @field:SerializedName("location")
    val location: String?,

)