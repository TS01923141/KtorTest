package com.example.ktortest.model.ktor

import android.media.session.MediaSessionManager
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*

class ApiWorker {
    companion object{
        val BASE_URL = "https://jsonplaceholder.typicode.com"

        val client = HttpClient(CIO) {
            //Header
            install(DefaultRequest) {
                header("Accept", "application/json")
                header("Content-type", "application/json")
                contentType(ContentType.Application.Json)
                //add a header to all the requests your token
        //        header("Authorization", "Bearer ${SessionManager.userToken}")
            }

            //Json
            install(JsonFeature) {
                serializer = GsonSerializer()
            }
            //Now you see response logs inside terminal
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.HEADERS
            }
        }
    }
}