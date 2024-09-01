package com.example.retrofit

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("userId")
    val myUserID:Int,
    val id: Int,
    val title:String,
    val body:String
)
