package com.example.retrofit

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.repository.Reposi

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var textview:TextView
    private lateinit var button:Button
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textview= findViewById(R.id.textview)
        button = findViewById(R.id.btn)
        editText= findViewById(R.id.edit)

        //hello

        val reposi = Reposi()
        val viewModelFactory = MainViewModelFactory(reposi)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        button.setOnClickListener {
            val myNumber = editText.text.toString()
            viewModel.getCustomPost(Integer.parseInt(myNumber))

            viewModel.myResponse3.observe(this, Observer {response ->
                if (response.isSuccessful){
                    textview.text = response.body().toString()
                    response.body()?.forEach {
                        Log.d("Response", it.myUserID.toString())
                        Log.d("Response", it.id.toString())
                        Log.d("Response", it.title)
                        Log.d("Response", it.body)
                        Log.d("Response", "------------------")
                    }
                }
                else{

                    textview.text = response.code().toString()
                }
            })
        }
    }
}