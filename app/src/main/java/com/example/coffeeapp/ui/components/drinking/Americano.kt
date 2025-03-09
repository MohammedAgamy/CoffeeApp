package com.example.coffeeapp.ui.components.drinking

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Americano()
{
    Text(
        text = "Americano",
        fontSize = 30.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(top = 8.dp).fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}