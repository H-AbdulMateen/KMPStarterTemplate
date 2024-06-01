package com.abdulmateen.kmpstartertemplate

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.abdulmateen.kmpstartertemplate.navigation.NavigationRoot
import com.abdulmateen.kmpstartertemplate.screens.auth.login.LoginScreen
import com.abdulmateen.kmpstartertemplate.theme.AppTheme

@Composable
fun App(
    navController: NavHostController
) {
    AppTheme {
        NavigationRoot(navController = navController, isLoggedIn = false)
    }
}