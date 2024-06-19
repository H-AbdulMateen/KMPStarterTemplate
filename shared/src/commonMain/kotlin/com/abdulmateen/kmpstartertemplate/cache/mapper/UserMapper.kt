package com.abdulmateen.kmpstartertemplate.cache.mapper

import com.abdulmateen.kmpstartertemplate.cache.UserEntity
import com.abdulmateen.kmpstartertemplate.entity.User

fun UserEntity.toUser(): User {
    return User(
        email = email,
        firstName = firstName,
        gender = gender,
        id = id?.toInt(),
        image = image,
        lastName = lastName,
        refreshToken = refreshToken,
        token = token,
        username = username
    )
}

fun User.toEntityUser(): UserEntity = UserEntity(
    email = email ?: "",
    username = username ?: "",
    firstName = firstName ?: "",
    lastName = lastName ?: "",
    gender = gender ?: "",
    id = id?.toLong(),
    image = image,
    refreshToken = refreshToken,
    token = token

)