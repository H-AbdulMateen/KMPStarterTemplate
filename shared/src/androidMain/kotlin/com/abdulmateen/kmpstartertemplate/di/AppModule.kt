package com.abdulmateen.kmpstartertemplate.di

import com.abdulmateen.kmpstartertemplate.network.ApiService
import com.abdulmateen.kmpstartertemplate.viewmodels.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<ApiService> { ApiService() }
    viewModel { LoginViewModel() }

}