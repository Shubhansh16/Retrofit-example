package com.example.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repository.Reposi
import kotlinx.coroutines.launch

class MainViewModel(private val reposi: Reposi) :ViewModel() {

    val myResponse:MutableLiveData<Post> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
           val response = reposi.getPost()
            myResponse.value = response
        }
    }
}