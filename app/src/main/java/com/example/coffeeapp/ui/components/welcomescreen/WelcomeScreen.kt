package com.example.coffeeapp.ui.components.welcomescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.coffeeapp.R
import com.example.coffeeapp.ui.theme.PrimaryColor

@Composable
fun WelcomeScreen(navHostController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .background(color = PrimaryColor),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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


        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "Feel yourself like",
            fontSize = 35.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Normal,
        )
        Text(
            "a barista!",
            fontSize = 35.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Normal,
        )

        Text(
            "Magic coffee on order",
            fontSize = 20.sp,
            color = Color.LightGray,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(120.dp))
        FloatingActionButton(
            onClick = {
                navHostController.navigate("LogInScreen")
            },
            containerColor = PrimaryColor,
            contentColor = Color.White,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.End)
                .shadow(8.dp, shape = androidx.compose.foundation.shape.CircleShape)

        ) {
            Icon(
                painter = painterResource(R.drawable.baseline_arrow_right_alt_24),
                contentDescription = "Next",
               Modifier.background(PrimaryColor)
            )
        }
    }


}