package com.example.coffeeapp.ui.components.Custom

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapp.ui.theme.GrayLight
import com.example.coffeeapp.ui.theme.PrimaryColor

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    error: String?,
    icon: Int,
    keyboardType: KeyboardType = KeyboardType.Text
) {

    Column {
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label, color = GrayLight) },
            isError = error != null,
            leadingIcon = {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = "Icon",
                    tint = PrimaryColor
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            colors = androidx.compose.material3.TextFieldDefaults.colors(
                focusedTextColor = PrimaryColor,
                focusedContainerColor = White,
                disabledContainerColor = White,
                unfocusedLabelColor = White,
                unfocusedContainerColor = White,
                disabledLabelColor = PrimaryColor,
                focusedLabelColor = PrimaryColor,
                focusedIndicatorColor = if (error != null) Red else PrimaryColor,
                unfocusedIndicatorColor = LightGray,
                cursorColor = PrimaryColor,
                unfocusedTextColor = LightGray,
                errorContainerColor = Red,
            )
        )
        error?.let {
            Text(
                it,
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 12.dp)
            )
        }
    }
}