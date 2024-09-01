package com.example.api

import com.example.retrofit.Post
import retrofit2.http.GET

interface SimpleApi  {

    @GET("posts/1")
    suspend fun getPost(): Post
}