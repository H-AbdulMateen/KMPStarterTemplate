package com.abdulmateen.kmpstartertemplate

import com.abdulmateen.kmpstartertemplate.entity.User
import com.abdulmateen.kmpstartertemplate.network.ApiService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.dsl.module

class KoinHelper : KoinComponent {
    private val apiService: ApiService by inject()
    suspend fun login(email: String, password: String): User = apiService.login(email, password)
}

fun initKoin(){
    startKoin {
        modules(
            module {
                single<ApiService> { ApiService() }
            }
        )
    }
}