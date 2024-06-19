package com.abdulmateen.kmpstartertemplate

import com.abdulmateen.kmpstartertemplate.cache.IOSDatabaseDriverFactory
import com.abdulmateen.kmpstartertemplate.entity.User
import com.abdulmateen.kmpstartertemplate.network.ApiService
import com.abdulmateen.kmpstartertemplate.repository.AuthRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.dsl.module

class KoinHelper : KoinComponent {
    private val authRepository: AuthRepository by inject()
    suspend fun login(email: String, password: String): User = authRepository.login(email, password)
}

fun initKoin(){
    startKoin {
        modules(
            module {
                single<ApiService> { ApiService() }
                single<AuthRepository> {
                    AuthRepository(
                        databaseDriverFactory = IOSDatabaseDriverFactory(), apiService = get()
                    )
                }
            }
        )
    }
}