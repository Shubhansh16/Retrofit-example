package com.example.repository

import com.example.api.RetrofitInstance
import okhttp3.Response
import com.example.retrofit.Post as Post

class Reposi {

    suspend fun getPost(): retrofit2.Response<Post> {
       return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int) : retrofit2.Response<Post> {
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun getCustomPost(userId:Int): retrofit2.Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost(userId)
    }
}