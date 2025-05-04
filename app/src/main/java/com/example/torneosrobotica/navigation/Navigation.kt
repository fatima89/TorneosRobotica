package com.example.torneosrobotica.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.torneosrobotica.views.HomeView
import com.example.torneosrobotica.views.LoginView
import com.example.torneosrobotica.views.MapsViewScreen
import com.example.torneosrobotica.views.SingUpView
import com.example.torneosrobotica.views.PrincipalView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun Navigation (navHostController: NavHostController,auth: FirebaseAuth) {

    NavHost(navController = navHostController, startDestination = "home"){
        composable("home")
        {
            HomeView(
                navigateToLogin = {navHostController.navigate("logIn")},
                navigateToSignUP = {navHostController.navigate("signUp")},
                navigateToMap = {navHostController.navigate("mapa")}
            )
        }
        composable("logIn")
        {
            LoginView(auth){ navHostController.navigate("principal")}
        }
        composable("signUp")
        {
            SingUpView(auth)
        }
        composable("principal"){
            PrincipalView()
        }
        composable("mapa")
        {
            MapsViewScreen()
        }
    }
}