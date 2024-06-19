package com.abdulmateen.kmpstartertemplate.di

import com.abdulmateen.kmpstartertemplate.cache.AndroidDatabaseDriverFactory
import com.abdulmateen.kmpstartertemplate.cache.DatabaseDriverFactory
import com.abdulmateen.kmpstartertemplate.network.ApiService
import com.abdulmateen.kmpstartertemplate.repository.AuthRepository
import com.abdulmateen.kmpstartertemplate.viewmodels.LoginViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<ApiService> { ApiService() }
    viewModel { LoginViewModel() }
    single<AuthRepository> {
        AuthRepository(
            databaseDriverFactory = AndroidDatabaseDriverFactory(
            androidContext()
        ),
            apiService = get()
        )
    }
}