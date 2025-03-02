package com.example.coffeeapp.ui.components.welcomescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.coffeeapp.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navHostController: NavHostController) {

    LaunchedEffect(Unit) {
        delay(3000)
        navHostController.navigate("Home")
    }

    Box(modifier = Modifier.fillMaxSize() , contentAlignment = Alignment.Center) {
        Image(painter = painterResource(R.drawable.fg), contentDescription = "Background" , modifier = Modifier.fillMaxSize() , contentScale = ContentScale.FillBounds)


        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0x8B1D2335))) {

        }

        Image(
            painter = painterResource(R.drawable.imagecoffee),
            contentDescription = "welcome Image ",

            )
        Text(
            "Magic Coffee",
            fontFamily = FontFamily(Font(R.font.reeniebeanieregular)),
            fontSize = 45.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )

    }

}