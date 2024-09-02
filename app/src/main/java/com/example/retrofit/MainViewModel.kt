package com.example.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repository.Reposi
import kotlinx.coroutines.launch
import okhttp3.Response

class MainViewModel(private val reposi: Reposi) :ViewModel() {

    val myResponse: MutableLiveData<retrofit2.Response<Post>> = MutableLiveData()
    val myResponse2: MutableLiveData<retrofit2.Response<Post>> = MutableLiveData()
    val myResponse3: MutableLiveData<retrofit2.Response<List<Post>>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
           val response = reposi.getPost()
            myResponse.value = response
        }
    }

    fun getPost2(number: Int){
        viewModelScope.launch {
            val response = reposi.getPost2(number)
            myResponse2.value = response
        }
    }

    fun getCustomPost(userId:Int){
        viewModelScope.launch {
            val response = reposi.getCustomPost(userId)
            myResponse3.value = response
        }
    }
}