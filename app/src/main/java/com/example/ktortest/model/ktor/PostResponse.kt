package com.example.ktortest.model.ktor

import com.google.gson.annotations.SerializedName

data class PostResponse (
    @SerializedName("body")
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)