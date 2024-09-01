package com.example.repository

import com.example.api.RetrofitInstance
import com.example.retrofit.Post
import retrofit2.Retrofit

class Reposi {

    suspend fun getPost():Post{
       return RetrofitInstance.api.getPost()
    }
}