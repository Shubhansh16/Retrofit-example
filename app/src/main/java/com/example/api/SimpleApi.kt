package com.example.api

import com.example.retrofit.Post
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleApi  {

    @GET("posts/1")
    suspend fun getPost(): retrofit2.Response<Post>


    @GET("posts/{postNumber}")
    suspend fun getPost2(
      @Path("postNumber") number: Int
    ): retrofit2.Response<Post>


    @GET("posts")
    suspend fun getCustomPost(
        @Query("userId") userId :Int
    ):retrofit2.Response<List<Post>>
}