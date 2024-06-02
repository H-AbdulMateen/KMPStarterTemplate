package com.abdulmateen.kmpstartertemplate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.abdulmateen.kmpstartertemplate.screens.auth.login.LoginScreen
import com.abdulmateen.kmpstartertemplate.screens.auth.sign_up.SignUpScreen
import com.abdulmateen.kmpstartertemplate.screens.dashboard.HomeScreen

@Composable
fun NavigationRoot(
    navController: NavHostController,
    isLoggedIn: Boolean
) {
    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) GraphRoot.Dashboard.name else GraphRoot.Auth.name)
    {
        authGraph(navController)
        dashboardGraph(navController)
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController){
    navigation(
        startDestination = ScreenRoute.Login.name,
        route = GraphRoot.Auth.name
    ){
        composable(route = ScreenRoute.Login.name){
            LoginScreen(
                onSignUpClick = {
                    navController.navigate(ScreenRoute.SignUp.name)
                },
                onSignInSuccess = {
                    navController.navigate(GraphRoot.Dashboard.name) {
                        popUpTo(GraphRoot.Auth.name) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(route = ScreenRoute.SignUp.name){
            SignUpScreen(
                onSignInClick = {
                    navController.navigateUp()
                },
                onSuccessRegistration = {
                    navController.navigateUp()
                }
            )
        }
    }
}

private fun NavGraphBuilder.dashboardGraph(navController: NavHostController){
    navigation(
        startDestination = ScreenRoute.Home.name,
        route = GraphRoot.Dashboard.name
    ){
        composable(ScreenRoute.Home.name){
            HomeScreen(
                onLogoutClick = {
                    navController.navigate(GraphRoot.Auth.name){
                        popUpTo(GraphRoot.Dashboard.name){
                            inclusive = true
                        }
                    }
                }
            )
        }

    }
}

enum class GraphRoot() {
    Auth,
    Dashboard
}