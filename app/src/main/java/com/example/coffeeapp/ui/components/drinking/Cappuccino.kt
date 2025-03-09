package com.example.coffeeapp.ui.components.drinking

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.coffeeapp.R
import com.example.coffeeapp.ui.theme.Black
import com.example.coffeeapp.ui.theme.White

@Composable
fun Cappuccino() {
    Column {
        HeaderCappuccino()
        Spacer(modifier = Modifier.height(25.dp))
        ImgCoup()
        Spacer(modifier = Modifier.height(10.dp))
        Details()

    }

}

@Composable
fun Details() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (cappuccino, button, space1, ristretto, buttonOnOns, buttonTow , space2) = createRefs()
        var count by remember { mutableStateOf(1) }

        Text(
            "Cappuccino",
            fontSize = 18.sp,
            color = Black,
            modifier = Modifier.constrainAs(cappuccino) {
                top.linkTo(parent.top, margin = 15.dp)
                start.linkTo(parent.start, margin = 25.dp)
            })


        Row(
            modifier = Modifier
                .constrainAs(button) {
                    top.linkTo(parent.top, margin = 10.dp)
                    end.linkTo(parent.end, margin = 25.dp)
                }
                .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(24.dp))
                .size(width = 150.dp, height = 40.dp)
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            IconButton(onClick = { if (count > 1) count-- }) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = "Decrease",
                    tint = Color(0xFF2C3E50)
                )
            }

            Text(
                text = count.toString(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2C3E50)
            )

            IconButton(onClick = { count++ }) {
                Icon(Icons.Default.Add, contentDescription = "Increase", tint = Color(0xFF2C3E50))
            }
        }


        Spacer(modifier = Modifier
            .constrainAs(space1) {
                top.linkTo(button.bottom, margin = 20.dp)
            }
            .height(1.dp)
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .background(color = Color.LightGray))


        Text(
            "Ristretto",
            fontSize = 18.sp,
            color = Black,
            modifier = Modifier.constrainAs(ristretto) {
                top.linkTo(space1.top, margin = 25.dp)
                start.linkTo(parent.start, margin = 25.dp)
            })




        Button(onClick = {}, modifier = Modifier.constrainAs(buttonOnOns) {
            top.linkTo(space1.top, margin = 10.dp)
            end.linkTo(parent.end, margin = 25.dp)
        }, colors = ButtonColors(
            containerColor = White ,
            contentColor = Black,
            disabledContainerColor = White ,
            disabledContentColor = Black
        ) , border = BorderStroke(1.dp , color = Color.LightGray)) {
            Text("One")
        }

        Button(onClick = {}, modifier = Modifier.constrainAs(buttonTow) {
            top.linkTo(space1.top, margin = 10.dp)
            end.linkTo(buttonOnOns.end, margin = 90.dp)
        }, colors = ButtonColors(
            containerColor = White ,
            contentColor = Black,
            disabledContainerColor = White ,
            disabledContentColor = Black
        ) , border = BorderStroke(1.dp , color = Color.LightGray)
        ) {
            Text("Tow")
        }

        Spacer(modifier = Modifier
            .constrainAs(space2) {
                top.linkTo(ristretto.bottom, margin = 20.dp)
            }
            .height(1.dp)
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .background(color = Color.LightGray))
    }


}


@Composable
fun ImgCoup() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(White),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.cappuccino),
            contentDescription = "cappuccino",
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp),
            contentScale = ContentScale.Fit
        )

    }

}


@Composable
fun HeaderCappuccino() {


    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (image1, textH1, iconH1) = createRefs()

        Image(
            painter = painterResource(R.drawable.baseline_arrow_back_24),
            contentDescription = "Back",
            modifier = Modifier
                .constrainAs(image1) {
                    top.linkTo(parent.top, margin = 50.dp)
                    start.linkTo(parent.start, margin = 25.dp)
                }
                .size(28.dp)
        )

        Text(
            "Cappuccino",
            fontSize = 22.sp,
            color = Black,
            modifier = Modifier.constrainAs(textH1) {
                top.linkTo(parent.top, margin = 50.dp)
                end.linkTo(parent.end, margin = 130.dp)
            })


        Image(
            painter = painterResource(R.drawable.buy),
            contentDescription = "Buy",
            modifier = Modifier
                .constrainAs(iconH1) {
                    top.linkTo(parent.top, margin = 50.dp)
                    end.linkTo(parent.end, margin = 25.dp)
                }
                .size(28.dp)
        )
    }


}
