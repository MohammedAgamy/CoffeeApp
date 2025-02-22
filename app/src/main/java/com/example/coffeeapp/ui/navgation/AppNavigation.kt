package com.example.coffeeapp.ui.navgation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffeeapp.ui.WelcomeScreen
import com.example.coffeeapp.ui.components.LogInScreen

@Composable
fun AppNavigation (){
    val navController = rememberNavController()
    val context = LocalContext.current


    NavHost( navController = navController,
        startDestination = "WelcomeScreen") {

        composable("WelcomeScreen") { WelcomeScreen(navController) }
        composable("LogInScreen") { LogInScreen() }

    }
}