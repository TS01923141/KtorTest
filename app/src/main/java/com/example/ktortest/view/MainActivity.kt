package com.example.ktortest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.ktortest.R
import dagger.hilt.android.AndroidEntryPoint

//參考資料:https://medium.com/overapp-android/rest-api-with-ktor-on-android-13fd835cdf65
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getPosts()
    }
}