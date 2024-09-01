package com.example.retrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.repository.Reposi

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val reposi = Reposi()
        val viewModelFactory = MainViewModelFactory(reposi)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer {response->
            Log.d("Response", response.myUserID.toString())
            Log.d("Response", response.id.toString())
            Log.d("Response", response.title)
            Log.d("Response", response.body)
        })
    }
}