package com.example.coffeeapp.navgation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.coffeeapp.R
import com.example.coffeeapp.ui.theme.PrimaryColor

@Composable
fun BottomNavBar() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        Pair("store", R.drawable.baseline_coffee_maker_24),
        Pair("gift",  R.drawable.baseline_card_giftcard_24),
        Pair("receipt",  R.drawable.baseline_receipt_long_24)
    )

    Surface(
        modifier = Modifier
            .fillMaxWidth().padding(horizontal = 20.dp)
            .height(68.dp),
        color = Color.White,
        shape = MaterialTheme.shapes.large,

    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items.forEachIndexed { index, item ->
                IconButton(onClick = { selectedItem = index }) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        painter = painterResource(id = item.second),
                        contentDescription = item.first,
                        tint = if (selectedItem == index) Color.Black else Color.Gray.copy(alpha = 0.3f)
                    )


                }
            }
        }
    }
}