package com.abdulmateen.kmpstartertemplate.cache

import com.abdulmateen.kmpstartertemplate.cache.mapper.toEntityUser
import com.abdulmateen.kmpstartertemplate.cache.mapper.toUser
import com.abdulmateen.kmpstartertemplate.entity.User

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.userEntityQueries

    internal fun getUserInfo(userId: Long): User? {
        return dbQuery.getUserInfo(userId).executeAsOneOrNull()?.toUser()
    }

    internal fun insertUser(user: User){
        dbQuery.insertUser(
            email = user.email ?: "",
            username = user.username ?: "",
            firstName = user.firstName,
            lastName = user.lastName,
            gender = user.gender,
            id = user.id?.toLong() ?: 0L,
            image = user.image,
            refreshToken = user.refreshToken,
            token = user.token
        )
    }
}