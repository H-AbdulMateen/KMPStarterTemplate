package com.abdulmateen.kmpstartertemplate.repository

import com.abdulmateen.kmpstartertemplate.cache.Database
import com.abdulmateen.kmpstartertemplate.cache.DatabaseDriverFactory
import com.abdulmateen.kmpstartertemplate.entity.User
import com.abdulmateen.kmpstartertemplate.network.ApiService

class AuthRepository(
    databaseDriverFactory: DatabaseDriverFactory,
    val apiService: ApiService
) {
    private val database = Database(databaseDriverFactory)
    @Throws(Exception::class)
    suspend fun login(email: String, password: String): User{
        val user = apiService.login(email = email, password = password).also {
            database.insertUser(it)
        }
        return user
    }

}