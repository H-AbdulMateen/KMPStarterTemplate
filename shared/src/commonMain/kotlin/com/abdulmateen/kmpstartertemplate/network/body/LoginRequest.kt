package com.abdulmateen.kmpstartertemplate.network.body


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    @SerialName("expiresInMins")
    val expiresInMins: Int?,
    @SerialName("password")
    val password: String?,
    @SerialName("username")
    val username: String?
)