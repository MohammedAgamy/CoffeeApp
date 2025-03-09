package com.example.coffeeapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.coffeeapp.R
import com.example.coffeeapp.ui.theme.Black
import com.example.coffeeapp.ui.theme.GrayLight
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.example.coffeeapp.navgation.BottomNavBar

@Composable
fun Home(navHostController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {

        Header()
        Spacer(modifier = Modifier.height(30.dp))
        CoffeeScreen(navHostController)
    }
}


@Composable
fun Header() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {

        val (textH1, textH2, iconH1, iconH2) = createRefs()
        Text(
            "Welcome",
            fontSize = 19.sp,
            color = GrayLight,
            modifier = Modifier.constrainAs(textH1) {
                top.linkTo(parent.top, margin = 60.dp)
                start.linkTo(parent.start, margin = 30.dp)
            })

        Text("Alex", fontSize = 22.sp, color = Black, modifier = Modifier.constrainAs(textH2) {
            top.linkTo(textH1.top, margin = 30.dp)
            start.linkTo(parent.start, margin = 30.dp)
        })


        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = "Profile",
            modifier = Modifier
                .constrainAs(iconH1) {
                    top.linkTo(parent.top, margin = 65.dp)
                    end.linkTo(parent.end, margin = 30.dp)
                }
                .size(28.dp)
        )

        Image(
            painter = painterResource(R.drawable.buy),
            contentDescription = "Buy",
            modifier = Modifier
                .constrainAs(iconH2) {
                    top.linkTo(parent.top, margin = 65.dp)
                    end.linkTo(iconH1.start, margin = 5.dp)
                }
                .size(28.dp)
        )
    }


}


@Composable
fun CoffeeScreen(navHostController: NavHostController) {
    val coffeeList = listOf(
        "Americano" to R.drawable.americano,
        "Cappuccino" to R.drawable.cappuccino,
        "Latte" to R.drawable.latte,
        "Flat White" to R.drawable.flatwhite,
        "Raf" to R.drawable.raf,
        "Espresso" to R.drawable.espresso
    )



    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column (modifier = Modifier.fillMaxSize()){
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp),
                colors = CardDefaults.cardColors(Color(0xFF2C3E50))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Select your coffee",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(coffeeList) { coffee ->
                            CoffeeItem(name = coffee.first, imageRes = coffee.second , onClick = {
                                when(coffee.first){
                                    "Americano" -> navHostController.navigate("Americano")
                                    "Cappuccino" -> navHostController.navigate("Cappuccino")
                                    "Latte" -> navHostController.navigate("Latte")
                                    "Flat" -> navHostController.navigate("Flat")
                                }
                            })
                        }
                    }
                }
                Spacer(modifier = Modifier.height(40.dp))
                BottomNavBar()
                Spacer(modifier = Modifier.height(90.dp))

            }

        }
    }
}

@Composable
fun CoffeeItem(name: String, imageRes: Int , onClick: ()-> Unit ) {
    Column(
        modifier = Modifier
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .padding(8.dp)
            .fillMaxWidth().clickable {
                onClick()
            }
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = name,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 8.dp).fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

