package com.abdulmateen.kmpstartertemplate.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("email")
    val email: String?,
    @SerialName("firstName")
    val firstName: String?,
    @SerialName("gender")
    val gender: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("image")
    val image: String?,
    @SerialName("lastName")
    val lastName: String?,
    @SerialName("refreshToken")
    val refreshToken: String?,
    @SerialName("token")
    val token: String?,
    @SerialName("username")
    val username: String?
)