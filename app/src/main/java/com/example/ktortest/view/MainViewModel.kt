package com.example.ktortest.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktortest.model.repository.NetworkRepository
import com.example.ktortest.model.ktor.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

private const val TAG = "MainViewModel"
@HiltViewModel
class MainViewModel @Inject constructor(private val networkRepository: NetworkRepository): ViewModel() {

    fun getPosts() {
        viewModelScope.launch {
            callPosts()
        }
    }

    private suspend fun callPosts() = withContext(Dispatchers.IO) {
        networkRepository.getPostById("5").let {
            when(it) {
                is NetworkResponse.Success -> {
                    Log.i(TAG, "callPosts: Success: ${it.data}")
                }
                is NetworkResponse.Error -> {
                    Log.i(TAG, "callPosts: Error: ${it.code}")
                }
            }
        }
    }
}