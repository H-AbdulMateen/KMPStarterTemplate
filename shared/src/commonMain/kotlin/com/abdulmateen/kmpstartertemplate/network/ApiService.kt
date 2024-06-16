package com.abdulmateen.kmpstartertemplate.network

import com.abdulmateen.kmpstartertemplate.entity.User
import com.abdulmateen.kmpstartertemplate.network.body.LoginRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class ApiService {
    private val httpClient = HttpClient {
        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun login(email: String, password: String): User{
        return httpClient.post("https://dummyjson.com/auth/login"){
            contentType(ContentType.Application.Json)
            setBody(LoginRequest(username = email, password = password, expiresInMins = 60))
        }.body()

    }
}