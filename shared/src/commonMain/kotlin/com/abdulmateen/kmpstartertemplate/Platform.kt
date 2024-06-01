package com.abdulmateen.kmpstartertemplate

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform