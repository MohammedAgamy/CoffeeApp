package com.example.coffeeapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.coffeeapp.R
import com.example.coffeeapp.ui.theme.GrayLight
import com.example.coffeeapp.ui.theme.PrimaryColor

@Composable
fun SignUpScreen(navHostController:NavHostController){


    var email by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        Spacer(modifier = Modifier.height(40.dp))
        Image(
            painter = painterResource(R.drawable.baseline_arrow_back_24),
            contentDescription = "Back",
            modifier = Modifier
                .size(60.dp)
                .padding(4.dp)
                .padding(start = 10.dp)
        )


        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "Sign up",
            fontFamily = FontFamily(Font(R.font.poppinsmedium)),
            fontSize = 35.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(4.dp)
                .padding(start = 40.dp)
        )
        Text(
            "Create an account here",
            fontFamily = FontFamily(Font(R.font.poppinsmedium)),
            fontSize = 18.sp,
            color = Color.LightGray,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(4.dp)
                .padding(start = 40.dp)
        )
        Spacer(modifier = Modifier.height(60.dp))
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name", color = GrayLight) },
            leadingIcon = { // Icon at the start of the text field
                Icon(
                    painter = painterResource(R.drawable.baseline_account_circle_24),
                    contentDescription = "Phone Icon", tint = PrimaryColor
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .padding(horizontal = 10.dp)
                .height(55.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = PrimaryColor,
                focusedContainerColor = White,
                disabledContainerColor = White,
                unfocusedLabelColor = White,
                unfocusedContainerColor = White,
                disabledLabelColor = PrimaryColor,
                focusedLabelColor = PrimaryColor,
                focusedIndicatorColor = PrimaryColor,
                unfocusedIndicatorColor = LightGray,
                cursorColor = PrimaryColor,
                unfocusedTextColor = LightGray


            )

        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Phone", color = GrayLight) },
            leadingIcon = { // Icon at the start of the text field
                Icon(
                    painter = painterResource(R.drawable.baseline_phone_iphone_24),
                    contentDescription = "Phone Icon", tint = PrimaryColor
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .padding(horizontal = 10.dp)
                .height(55.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = PrimaryColor,
                focusedContainerColor = White,
                disabledContainerColor = White,
                unfocusedLabelColor = White,
                unfocusedContainerColor = White,
                disabledLabelColor = PrimaryColor,
                focusedLabelColor = PrimaryColor,
                focusedIndicatorColor = PrimaryColor,
                unfocusedIndicatorColor = LightGray,
                cursorColor = PrimaryColor,
                unfocusedTextColor = LightGray


            )

        )
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email", color = GrayLight) },
            leadingIcon = { // Icon at the start of the text field
                Icon(
                    painter = painterResource(R.drawable.baseline_email_24),
                    contentDescription = "Phone Icon", tint = PrimaryColor
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .padding(horizontal = 10.dp)
                .height(55.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = PrimaryColor,
                focusedContainerColor = White,
                disabledContainerColor = White,
                unfocusedLabelColor = White,
                unfocusedContainerColor = White,
                disabledLabelColor = PrimaryColor,
                focusedLabelColor = PrimaryColor,
                focusedIndicatorColor = PrimaryColor,
                unfocusedIndicatorColor = LightGray,
                cursorColor = PrimaryColor,
                unfocusedTextColor = LightGray


            )

        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password", color = GrayLight) },
            leadingIcon = { // Icon at the start of the text field
                Icon(
                    painter = painterResource(R.drawable.baseline_lock_outline_24),
                    contentDescription = "Phone Icon", tint = PrimaryColor
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.baseline_remove_red_eye_24),
                    contentDescription = "Phone Icon", tint = PrimaryColor
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .padding(horizontal = 10.dp)
                .height(55.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = PrimaryColor,
                focusedContainerColor = White,
                disabledContainerColor = White,
                unfocusedLabelColor = White,
                unfocusedContainerColor = White,
                disabledLabelColor = PrimaryColor,
                focusedLabelColor = PrimaryColor,
                focusedIndicatorColor = PrimaryColor,
                unfocusedIndicatorColor = LightGray,
                cursorColor = PrimaryColor,
                unfocusedTextColor = LightGray


            )

        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "By Sign up you agree with our Terms of us ",
            color = Black,
            fontFamily = FontFamily(Font(R.font.poppinsmedium)),
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(50.dp))

        FloatingActionButton(
            onClick = {

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
        Spacer(modifier = Modifier.height(30.dp))

        Row (modifier = Modifier.fillMaxWidth().padding(2.dp).padding(start = 10.dp).clickable {
            navHostController.navigate("LogInScreen")
        }){
            Text(
                "Already a member?",
                color = LightGray,
                fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                fontSize = 14.sp,
                textAlign = TextAlign.Center,

                )
            Text(
                "Sign ip",
                color = Black,
                fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                fontSize = 14.sp,
                textAlign = TextAlign.Center,

                )
        }



    }
}