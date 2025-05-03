package com.example.torneosrobotica.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.torneosrobotica.views.HomeView
import com.example.torneosrobotica.views.LoginView
import com.example.torneosrobotica.views.SingUpView
import com.google.firebase.auth.FirebaseAuth

@Composable
fun Navigation (navHostController: NavHostController,auth: FirebaseAuth) {

    NavHost(navController = navHostController, startDestination = "home"){
        composable("home")
        {
            HomeView(
                navigateToLogin = {navHostController.navigate("logIn")},
                navigateToSignUP = {navHostController.navigate("signUp")}
            )
        }
        composable("logIn")
        {
            LoginView(auth)
        }
        composable("signUp")
        {
            SingUpView(auth)
        }
    }
}