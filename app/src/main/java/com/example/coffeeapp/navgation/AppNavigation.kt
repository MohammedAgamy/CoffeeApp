package com.example.coffeeapp.navgation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffeeapp.ui.components.Home
import com.example.coffeeapp.ui.components.welcomescreen.WelcomeScreen
import com.example.coffeeapp.ui.components.authscreen.LogInScreen
import com.example.coffeeapp.ui.components.authscreen.SignUpScreen
import com.example.coffeeapp.ui.components.drinking.Americano
import com.example.coffeeapp.ui.components.drinking.Cappuccino
import com.example.coffeeapp.ui.components.welcomescreen.SplashScreen

@Composable
fun AppNavigation (){
    val navController = rememberNavController()
    val context = LocalContext.current


    NavHost( navController = navController,
        startDestination = "WelcomeScreen") {

        composable("WelcomeScreen") { WelcomeScreen(navController) }
        composable("LogInScreen") { LogInScreen(navController) }
        composable("SignUpScreen") { SignUpScreen(navController) }
        composable("Home") { Home(navController) }
        composable("Splash") { SplashScreen(navController) }
        composable("Americano") { Americano() }
        composable("Cappuccino") { Cappuccino() }
        composable("Flat") { SplashScreen(navController) }
        composable("Latte") { SplashScreen(navController) }

    }
}