package com.example.coffeeapp.ui.components.drinking

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.os.Build
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.FractionalThreshold
import androidx.wear.compose.material.TimeText
import androidx.wear.compose.material.TimeTextDefaults
import androidx.wear.compose.material.rememberSwipeableState
import androidx.wear.compose.material.swipeable
import com.example.coffeeapp.R
import com.example.coffeeapp.ui.theme.Black
import com.example.coffeeapp.ui.theme.PrimaryColor
import com.example.coffeeapp.ui.theme.White
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Calendar
import java.util.Locale

import kotlin.math.roundToInt

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

@SuppressLint("DefaultLocale")
@OptIn(ExperimentalWearMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Details() {

    val context = LocalContext.current
    val timePicker = remember { mutableStateOf("05:42 AM") }
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {

        val (cappuccino, button, space1, swipeable, clock, space4, ristretto , time, buttonOnOns, buttonTow, space2, onsite, row, space3, row2, volume) = createRefs()
        var count by remember { mutableStateOf(1) }
        val (amount,amountLE,nextBtn) = createRefs()
        var selectedOption by remember { mutableStateOf("onsite") }
        var selectedOptionVolume by remember { mutableStateOf("volume") }


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
            containerColor = White,
            contentColor = Black,
            disabledContainerColor = White,
            disabledContentColor = Black
        ), border = BorderStroke(1.dp, color = Color.LightGray)
        ) {
            Text("One")
        }

        Button(onClick = {}, modifier = Modifier.constrainAs(buttonTow) {
            top.linkTo(space1.top, margin = 10.dp)
            end.linkTo(buttonOnOns.end, margin = 90.dp)
        }, colors = ButtonColors(
            containerColor = White,
            contentColor = Black,
            disabledContainerColor = White,
            disabledContentColor = Black
        ), border = BorderStroke(1.dp, color = Color.LightGray)
        ) {
            Text("Tow")
        }

        Spacer(
            modifier = Modifier
                .constrainAs(space2) {
                    top.linkTo(ristretto.bottom, margin = 20.dp)
                }
                .height(1.dp)
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .background(color = Color.LightGray))


        Text(
            "Onsite / Takeaway",
            fontSize = 18.sp,
            color = Black,
            modifier = Modifier.constrainAs(onsite) {
                top.linkTo(space2.top, margin = 18.dp)
                start.linkTo(parent.start, margin = 25.dp)
            })

        Row(
            modifier = Modifier
                .constrainAs(row) {
                    top.linkTo(space2.top, margin = 10.dp)
                    end.linkTo(parent.end, margin = 5.dp)
                }
                .size(width = 150.dp, height = 40.dp)
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(if (selectedOption == "onsite") R.drawable.onsitblack else R.drawable.onsutgray),
                contentDescription = "Onsite",
                modifier = Modifier.clickable {
                    selectedOption = "onsite"

                })
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(if (selectedOption == "takeaway") R.drawable.tackblack else R.drawable.tackgray),
                contentDescription = "Takeaway",
                modifier = Modifier.clickable {
                    selectedOption = "takeaway"


                })
        }


        Spacer(
            modifier = Modifier
                .constrainAs(space3) {
                    top.linkTo(row.bottom, margin = 20.dp)
                }
                .height(1.dp)
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .background(color = Color.LightGray))


        Text(
            "Volume, ml",
            fontSize = 18.sp,
            color = Black,
            modifier = Modifier.constrainAs(volume) {
                top.linkTo(space3.top, margin = 30.dp)
                start.linkTo(parent.start, margin = 25.dp)
            })

        Row(
            modifier = Modifier
                .constrainAs(row2) {
                    top.linkTo(space3.top, margin = 10.dp)
                    end.linkTo(parent.end)
                }
                .size(width = 190.dp, height = 70.dp)
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(if (selectedOptionVolume == "volume") R.drawable.tackblack else R.drawable.tackgray),
                contentDescription = "Onsite",
                modifier = Modifier
                    .clickable {
                        selectedOptionVolume = "volume"

                    }
                    .size(60.dp)
            )
            Image(
                painter = painterResource(if (selectedOptionVolume == "takeaway") R.drawable.tackblack else R.drawable.tackgray),
                contentDescription = "Takeaway",
                modifier = Modifier
                    .clickable {
                        selectedOptionVolume = "takeaway"
                    }
                    .size(40.dp)
            )
            Image(
                painter = painterResource(if (selectedOptionVolume == "third") R.drawable.tackblack else R.drawable.tackgray),
                contentDescription = "Takeaway",
                modifier = Modifier
                    .clickable {
                        selectedOptionVolume = "third"
                    }
                    .size(30.dp)
            )
        }


        Spacer(
            modifier = Modifier
                .constrainAs(space4) {
                    top.linkTo(row2.bottom, margin = 20.dp)
                }
                .height(1.dp)
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .background(color = Color.LightGray))


        Text(
            "Prepare by a certain time today?",
            fontSize = 16.sp,
            color = Black,
            modifier = Modifier.constrainAs(time) {
                top.linkTo(space4.top, margin = 30.dp)
                start.linkTo(parent.start, margin = 25.dp)
            })


        val height = 30.dp
        val width = 70.dp

        val sizePx = with(LocalDensity.current) { (width - height).toPx() }
        val swipeableState = rememberSwipeableState(0)  // يتم تخزين حالة السحب هنا
        val anchors = mapOf(0f to 0, sizePx to 1) // يحدد نقاط التوقف عند السحب

        Row(
            modifier = Modifier
                .constrainAs(swipeable) {
                    top.linkTo(space4.top, margin = 25.dp)
                    end.linkTo(parent.end, margin = 15.dp)
                }
                .height(height)
                .width(width)
                .clip(RoundedCornerShape(height))
                .background(if (swipeableState.currentValue == 1) Color.Green else Color.Gray) // تغيير لون الخلفية
                .border(1.dp, Color.DarkGray, CircleShape)
                .padding(horizontal = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier
                    .offset {
                        IntOffset(
                            swipeableState.offset.value.roundToInt(),
                            0
                        )
                    } // تحديث الموقع أثناء السحب
                    .size(height)
                    .clip(CircleShape)
                    .background(Color.White)
                    .swipeable(
                        state = swipeableState,
                        anchors = anchors,
                        thresholds = { _, _ -> FractionalThreshold(0.3f) },
                        orientation = Orientation.Horizontal
                    )
            )
        }


        Box(
            modifier = Modifier
                .constrainAs(clock) {
                    top.linkTo(swipeable.top, margin = 40.dp)
                    end.linkTo(parent.end, margin = 8.dp)
                }
                .width(150.dp)
                .pointerInput(Unit) {
                    val calendar = Calendar.getInstance()
                    val hour = calendar.get(Calendar.HOUR_OF_DAY)
                    val minute = calendar.get(Calendar.MINUTE)

                    TimePickerDialog(
                        context,
                        { _, selectedHour, selectedMinute ->
                            val amPm = if (selectedHour >= 12) "PM" else "AM"
                            val formattedHour =
                                if (selectedHour % 12 == 0) 12 else selectedHour % 12
                            timePicker.value =
                                String.format("%02d:%02d %s", formattedHour, selectedMinute, amPm)
                        },
                        hour, minute, false // false لاستخدام تنسيق AM/PM
                    ).show()
                }
        ) {
            OutlinedTextField(
                value = timePicker.value,
                onValueChange = {},
                readOnly = true, //
                modifier = Modifier
                    .width(150.dp),
                trailingIcon = {
                    Icon(Icons.Default.Notifications, contentDescription = "Pick Time")
                },
                colors = androidx.compose.material3.TextFieldDefaults.colors(
                    focusedTextColor = PrimaryColor,
                    focusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledLabelColor = PrimaryColor,
                    focusedLabelColor = PrimaryColor,
                    unfocusedIndicatorColor = Black,
                    cursorColor = PrimaryColor,
                    unfocusedTextColor = Black,
                )
            )
        }

        Text(
            "Total Amount ",
            fontSize = 22.sp,
            color = Black,
            modifier = Modifier.constrainAs(amount){
                top.linkTo(clock.top , margin = 65.dp)
                start.linkTo(parent.start , margin = 10.dp)
            }
        )

        Text(
            "15 L.E ",
            fontSize = 22.sp,
            color = Black,
            modifier = Modifier.constrainAs(amountLE){
                top.linkTo(clock.top , margin = 65.dp)
                end.linkTo(parent.end , margin = 40.dp)
            }
        )


        Button(onClick = {
        }, modifier = Modifier.height(60.dp).constrainAs(nextBtn){
            top.linkTo(amount.top , margin = 35.dp)
            end.linkTo(parent.end , margin = 20.dp)
            start.linkTo(parent.start, margin = 20.dp)
        }.fillMaxWidth(), colors = ButtonColors(
            containerColor = PrimaryColor,
            contentColor = White ,
            disabledContentColor = White,
            disabledContainerColor = PrimaryColor
        )
        ) { Text("Next" , color = White , fontSize = 24.sp) }
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
                .height(160.dp),
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

