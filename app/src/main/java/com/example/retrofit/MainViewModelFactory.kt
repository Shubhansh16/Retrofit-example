package com.example.retrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.repository.Reposi

class MainViewModelFactory(
    private val reposi: Reposi)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(reposi) as T
    }
}