package com.example.ktortest.model.repository

import com.example.ktortest.model.ktor.ApiWorker
import com.example.ktortest.model.ktor.NetworkResponse
import com.example.ktortest.model.ktor.NetworkResponseCode
import com.example.ktortest.model.ktor.PostResponse
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import javax.inject.Inject

class NetworkRepository() {
    //https://jsonplaceholder.typicode.com/posts?id=5
    suspend fun getPostById(idPost: String): NetworkResponse<MutableList<PostResponse>> {
        return try {
            val response: HttpResponse =
                ApiWorker.client.get("${ApiWorker.BASE_URL}/posts") {
                    parameter("id", idPost)
                }
            //Return response
            (NetworkResponse.Success(response.receive()))

        } catch (e: Throwable) {
            (NetworkResponse.Error(NetworkResponseCode.checkError(e)))
        }
    }
}